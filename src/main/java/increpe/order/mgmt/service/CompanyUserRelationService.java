package increpe.order.mgmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import increpe.order.mgmt.model.CompanyUserRelation;
import increpe.order.mgmt.model.User;
import increpe.order.mgmt.repository.CompanyUserRelationRepository;
import increpe.order.mgmt.security.dto.CompanyUserRelationDto;
import increpe.order.mgmt.security.mapper.CompanyMapper;
import increpe.order.mgmt.security.service.UserService;

@Service
public class CompanyUserRelationService {
	
	@Autowired
	CompanyUserRelationRepository relationRepository;
	
	@Autowired
	CompanyService companyService;
	
	@Autowired
	UserService userService;

	
	public CompanyUserRelation createRelation(CompanyUserRelationDto companyUserRelationDto) {
		
		CompanyUserRelation relation = convertRelationDtoToRelation(companyUserRelationDto);
		
		User userId = userService.createUser(companyUserRelationDto.getUserId());
		
		relation.setUserId(userId);
		
		return relationRepository.save(relation);
	}

	
	public CompanyUserRelationDto createCompanyToUserRelation(CompanyUserRelationDto companyUserRelationDto) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public CompanyUserRelationDto getRelation(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<CompanyUserRelationDto> getRelationByCompany(Long id) {
		
		List<CompanyUserRelation> relationList = relationRepository.findByCompanyId_id(id);
		
		
		
		return CompanyMapper.INSTANCE.convertToCompanyUserRelationDtoList(relationList);
	}

	
	public CompanyUserRelationDto getRelationByUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public CompanyUserRelation convertRelationDtoToRelation(CompanyUserRelationDto companyUserRelationDto) {
		
		return CompanyMapper.INSTANCE.convertToCompanyUserRelation(companyUserRelationDto);
	}

	
	public CompanyUserRelationDto convertRelationToRelationDto(CompanyUserRelation companyUserRelation) {
		
		return CompanyMapper.INSTANCE.convertCompanyUserRelationDto(companyUserRelation);
	}

}
