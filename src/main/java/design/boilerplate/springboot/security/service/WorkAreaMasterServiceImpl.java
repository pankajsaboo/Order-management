package design.boilerplate.springboot.security.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import design.boilerplate.springboot.model.WorkAreaMaster;
import design.boilerplate.springboot.repository.WorkAreaMasterRepository;
import design.boilerplate.springboot.security.dto.WorkAreaMasterDto;
import design.boilerplate.springboot.security.mapper.CompanyMapper;

@Service
public class WorkAreaMasterServiceImpl implements WorkAreaMasterService {
	
	@Autowired
	WorkAreaMasterRepository masterRepository;
	
	@Autowired
	CompanyService companyService;

	@Override
	public List<WorkAreaMasterDto> createWorkAreaMaster(List<WorkAreaMasterDto> dtoList) {
		
		List<WorkAreaMaster> masterList = convertDtoListToMasterList(dtoList);
		
		Iterable<WorkAreaMaster> iterable = masterRepository.saveAll(masterList);
		
		return convertMasterListToDtoList((List<WorkAreaMaster>)iterable);
	}

	@Override
	public List<WorkAreaMasterDto> getWorkAreaMasterByCompany(Long id) {
		
		return CompanyMapper.INSTANCE.convertToWorkAreaMasterDtoList(masterRepository.findByCompanyId_id(id));
	}

	@Override
	public WorkAreaMasterDto updateWorkAreaMaster(WorkAreaMasterDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteWorkAreaMaster(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public WorkAreaMaster convertMasterServiceDtoToMasterService(WorkAreaMasterDto dto) {
		
		return CompanyMapper.INSTANCE.convertToWorkAreaMaster(dto);
	}

	@Override
	public WorkAreaMasterDto convertMasterServiceToMasterServiceDto(WorkAreaMaster workAreaMaster) {
		
		return CompanyMapper.INSTANCE.convertToWorkAreaMasterDto(workAreaMaster);
	}

	@Override
	public List<WorkAreaMaster> convertDtoListToMasterList(List<WorkAreaMasterDto> dtoList) {
		
		return CompanyMapper.INSTANCE.convertToWorkAreaMasterList(dtoList);
	}

	@Override
	public List<WorkAreaMasterDto> convertMasterListToDtoList(List<WorkAreaMaster> masterList) {
		
		return CompanyMapper.INSTANCE.convertToWorkAreaMasterDtoList(masterList);
	}

}
