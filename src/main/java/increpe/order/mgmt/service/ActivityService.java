package increpe.order.mgmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import increpe.order.mgmt.model.ActivityMaster;
import increpe.order.mgmt.repository.ActivityMasterRepository;
import increpe.order.mgmt.repository.ActivityRepository;
import increpe.order.mgmt.security.dto.RegistrationResponse;
import increpe.order.mgmt.security.mapper.CompanyMapper;
import increpe.order.mgmt.sp.dto.ActivityDto;
import increpe.order.mgmt.sp.dto.ActivityMasterDto;

@Service
public class ActivityService {

	@Autowired
	ActivityRepository activityRepository;

	@Autowired
	ActivityMasterRepository activityMasterRepository;

	public RegistrationResponse createActivityMaster(ActivityMasterDto activityMasterDto) {

		activityMasterRepository.save(CompanyMapper.INSTANCE.convertToActivityMaster(activityMasterDto));

		return new RegistrationResponse("Activity Master created successfully!");

	}

	public RegistrationResponse createAllMasters(List<ActivityMasterDto> masterDtoList) {

		activityMasterRepository.saveAll(CompanyMapper.INSTANCE.convertToActivityMasterList(masterDtoList));

		return new RegistrationResponse("Activity Masters created successfully!");

	}

	public List<ActivityMasterDto> getAllActivityMastersForCompany(Long companyId) {

		return CompanyMapper.INSTANCE
				.convertToActivityMasterDtoList(activityMasterRepository.findByCompanyId_id(companyId));
	}

	public RegistrationResponse updateActivityMaster(ActivityMasterDto activityMasterDto) {

		activityMasterRepository.save(CompanyMapper.INSTANCE.convertToActivityMaster(activityMasterDto));

		return new RegistrationResponse("Activity Master updated successfully!");
	}
	
	
	public RegistrationResponse createNewActivity(ActivityDto activityDto) {
		
		activityRepository.save(CompanyMapper.INSTANCE.convertToActivity(activityDto));
		
		return new RegistrationResponse("Activity created successfully");
	}
	
	public List<ActivityDto> getAllActivitiesForSalesPerson(Long salesPersonId){
		
		return CompanyMapper.INSTANCE.convertToActivityDtoList(
				activityRepository.findBySalesPersonId_id(salesPersonId));
	}
	
	public RegistrationResponse updateActivity(ActivityDto activityDto) {

		activityRepository.save(CompanyMapper.INSTANCE.convertToActivity(activityDto));

		return new RegistrationResponse("Activity updated successfully!");
	} 
	
	public boolean deleteActivity(Long activityId) {
		
		activityRepository.deleteById(activityId);
		
		return activityRepository.existsById(activityId);
	}
}
