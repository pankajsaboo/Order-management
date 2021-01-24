package design.boilerplate.springboot.security.service;

import java.util.List;

import design.boilerplate.springboot.model.WorkAreaMaster;
import design.boilerplate.springboot.security.dto.WorkAreaMasterDto;

public interface WorkAreaMasterService {
	
	List<WorkAreaMasterDto> createWorkAreaMaster(List<WorkAreaMasterDto> dtoList);
	
	List<WorkAreaMasterDto> getWorkAreaMasterByCompany(Long id);
	
	WorkAreaMasterDto updateWorkAreaMaster(WorkAreaMasterDto dto);
	
	boolean deleteWorkAreaMaster(Long id);

	WorkAreaMaster convertMasterServiceDtoToMasterService(WorkAreaMasterDto dto);
	
	WorkAreaMasterDto convertMasterServiceToMasterServiceDto(WorkAreaMaster workAreaMaster);
	
	List<WorkAreaMaster> convertDtoListToMasterList(List<WorkAreaMasterDto> dtoList);
	
	List<WorkAreaMasterDto> convertMasterListToDtoList(List<WorkAreaMaster> masterList);
	
}
