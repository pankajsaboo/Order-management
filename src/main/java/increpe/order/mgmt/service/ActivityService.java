package increpe.order.mgmt.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Tuple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import increpe.order.mgmt.model.ActivityMaster;
import increpe.order.mgmt.repository.ActivityMasterRepository;
import increpe.order.mgmt.repository.ActivityRepository;
import increpe.order.mgmt.security.dto.RegistrationResponse;
import increpe.order.mgmt.security.dto.RequestObject;
import increpe.order.mgmt.security.mapper.CompanyMapper;
import increpe.order.mgmt.sp.dto.ActivityDto;
import increpe.order.mgmt.sp.dto.ActivityMasterDto;
import increpe.order.mgmt.sp.dto.ActivityReportsDTO;
import increpe.order.mgmt.sp.dto.PageResultObject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@Service
public class ActivityService {

	@Autowired
	ObjectMapper objectMapper;

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

	public ActivityDto getActivityById(Long activityId) {

		return CompanyMapper.INSTANCE.convertToActivityDto(activityRepository.findById(activityId).get());
	}

	public RegistrationResponse updateActivityMaster(ActivityMasterDto activityMasterDto) {

		activityMasterRepository.save(CompanyMapper.INSTANCE.convertToActivityMaster(activityMasterDto));

		return new RegistrationResponse("Activity Master updated successfully!");
	}

	public RegistrationResponse createNewActivity(ActivityDto activityDto) {

		activityRepository.save(CompanyMapper.INSTANCE.convertToActivity(activityDto));

		return new RegistrationResponse("Activity created successfully");
	}

	public List<ActivityDto> getAllActivitiesForSalesPerson(Long salesPersonId) {

		return CompanyMapper.INSTANCE
				.convertToActivityDtoList(activityRepository.findBySalesPersonId_id(salesPersonId));
	}

	public PageResultObject<ActivityReportsDTO> findActivityReportsByUser(RequestObject req) {

		Pageable pageFilter = PageRequest.of(req.getPage(), req.getSize());

		Page resultPage = activityRepository.findActivityReportByUser(req.getCompanyId(), req.getUserId(), pageFilter);

		@SuppressWarnings("unchecked")
		List<Object[]> recordList = resultPage.getContent();

		List<ActivityReportsDTO> resultList = recordList.stream()
				.map(t -> new ActivityReportsDTO(t[0], t[1], t[2], t[3], t[4], t[5], t[6], t[7], t[8], t[9], t[10]))
				.collect(Collectors.toList());

		return new PageResultObject<ActivityReportsDTO>(resultList, resultPage.getPageable(),
				resultPage.getTotalElements(), resultPage.getTotalPages());

	}

	public PageResultObject<ActivityReportsDTO> findActivityReportsByDate(RequestObject req) {

		Pageable pageFilter = PageRequest.of(req.getPage(), req.getSize());

		Page resultPage = activityRepository.findActivityReportByDate(req.getCompanyId(), req.getDate(), pageFilter);

		@SuppressWarnings("unchecked")
		List<Object[]> recordList = resultPage.getContent();

		List<ActivityReportsDTO> resultList = recordList.stream()
				.map(t -> new ActivityReportsDTO(t[0], t[1], t[2], t[3], t[4], t[5], t[6], t[7], t[8], t[9], t[10]))
				.collect(Collectors.toList());

		return new PageResultObject<ActivityReportsDTO>(resultList, resultPage.getPageable(),
				resultPage.getTotalElements(), resultPage.getTotalPages());

	}

	public PageResultObject<ActivityReportsDTO> findActivityReportsByMonthYear(RequestObject req) {

		Pageable pageFilter = PageRequest.of(req.getPage(), req.getSize());

		String formattedMonthYear = req.getMonthYear().split("-")[0].toUpperCase() + "%" + req.getMonthYear().split("-")[1];
		Page resultPage = activityRepository.findActivityReportByMonthYear(req.getCompanyId(), formattedMonthYear, pageFilter);

		@SuppressWarnings("unchecked")
		List<Object[]> recordList = resultPage.getContent();

		List<ActivityReportsDTO> resultList = recordList.stream()
				.map(t -> new ActivityReportsDTO(t[0], t[1], t[2], t[3], t[4], t[5], t[6], t[7], t[8], t[9], t[10]))
				.collect(Collectors.toList());

		return new PageResultObject<ActivityReportsDTO>(resultList, resultPage.getPageable(),
				resultPage.getTotalElements(), resultPage.getTotalPages());

	}

//	public PageResultObject findActivityReports(RequestObject req) {
//
//
//		 List<ActivityReportsDTO> resultList = list.stream().map(t ->
//		 objectMapper.convertValue(t,
//		 ActivityReportsDTO.class)).collect(Collectors.toList());
//		t.get(0,String.class),
//		t.get(1, String.class),
//		t.get(2,String.class),
//		t.get(3, String.class),
//		t.get(4, Integer.class),
//		t.get(5, Date.class),
//		t.get(6, String.class),
//		t.get(7, String.class),
//		t.get(8, String.class)
//
//	}

	public RegistrationResponse updateActivity(ActivityDto activityDto) {

		activityRepository.save(CompanyMapper.INSTANCE.convertToActivity(activityDto));

		return new RegistrationResponse("Activity updated successfully!");
	}

	public boolean deleteActivity(Long activityId) {

		activityRepository.deleteById(activityId);

		return activityRepository.existsById(activityId);
	}
}
