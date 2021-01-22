package design.boilerplate.springboot.security.service;

import java.util.List;

import design.boilerplate.springboot.model.WorkAreaMaster;
import design.boilerplate.springboot.security.dto.WorkAreaMasterDto;

public interface WorkAreaMasterService {
	
	WorkAreaMasterDto createWorkAreaMaster(WorkAreaMasterDto dto);
	
	List<WorkAreaMasterDto> getWorkAreaMasterByCompany(Long id);
	
	WorkAreaMasterDto updateWorkAreaMaster(WorkAreaMasterDto dto);
	
	boolean deleteWorkAreaMaster(Long id);

	WorkAreaMaster convertMasterServiceDtoToMasterService(WorkAreaMasterDto dto);
	
	WorkAreaMasterDto convertMasterServiceToMasterServiceDto(WorkAreaMaster workAreaMaster);
	
}
