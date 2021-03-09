package increpe.order.mgmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import increpe.order.mgmt.model.WorkAreaMaster;
import increpe.order.mgmt.repository.HolidayMasterRepository;
import increpe.order.mgmt.repository.WorkAreaMasterRepository;
import increpe.order.mgmt.security.dto.HolidayMasterDto;
import increpe.order.mgmt.security.dto.WorkAreaMasterDto;
import increpe.order.mgmt.security.mapper.CompanyMapper;

@Service
public class WorkAreaMasterService {
	
	@Autowired
	WorkAreaMasterRepository masterRepository;
	
	@Autowired
	CompanyService companyService;
	
	@Autowired
	HolidayMasterRepository holidayMasterRepository;

	
	public WorkAreaMasterDto createWorkAreaMaster(WorkAreaMasterDto dto) {
		
		WorkAreaMaster master = convertMasterServiceDtoToMasterService(dto);
		
		return convertMasterServiceToMasterServiceDto(masterRepository.save(master));
	}

	
	public List<WorkAreaMasterDto> getWorkAreaMasterByCompany(Long id) {
		
		return CompanyMapper.INSTANCE.convertToWorkAreaMasterDtoList(masterRepository.findByCompanyId_id(id));
	}

	
	public WorkAreaMasterDto updateWorkAreaMaster(WorkAreaMasterDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public boolean deleteWorkAreaMaster(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public WorkAreaMaster convertMasterServiceDtoToMasterService(WorkAreaMasterDto dto) {
		
		return CompanyMapper.INSTANCE.convertToWorkAreaMaster(dto);
	}

	
	public WorkAreaMasterDto convertMasterServiceToMasterServiceDto(WorkAreaMaster workAreaMaster) {
		
		return CompanyMapper.INSTANCE.convertToWorkAreaMasterDto(workAreaMaster);
	}
	
	public HolidayMasterDto createHolidayMaster(HolidayMasterDto masterDto) {
		
		return CompanyMapper.INSTANCE.convertToHolidayMasterDto(
				holidayMasterRepository.save(CompanyMapper.INSTANCE.convertToHolidayMaster(masterDto)));
	}
	
	public HolidayMasterDto getHolidayMasterbyCompanyIdAndMonthYear(Long id, String mY) {
		
		return CompanyMapper.INSTANCE.convertToHolidayMasterDto(
						holidayMasterRepository.findByCompanyId_idAndMonthYear(id, mY));
	}

}
