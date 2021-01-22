package design.boilerplate.springboot.security.service;

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
	public WorkAreaMasterDto createWorkAreaMaster(WorkAreaMasterDto dto) {
		
		WorkAreaMaster master = convertMasterServiceDtoToMasterService(dto);
		
		return convertMasterServiceToMasterServiceDto(masterRepository.save(master));
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

}
