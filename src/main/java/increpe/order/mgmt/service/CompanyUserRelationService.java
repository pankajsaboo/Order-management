package increpe.order.mgmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import increpe.order.mgmt.model.CompanyUserRelation;
import increpe.order.mgmt.model.User;
import increpe.order.mgmt.repository.CompanyUserRelationRepository;
import increpe.order.mgmt.security.dto.AuthenticatedUserDto;
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

	
	public CompanyUserRelationDto createRelation(CompanyUserRelationDto companyUserRelationDto) {
		
		User userId = userService.createUser(companyUserRelationDto.getUserId());
		
		CompanyUserRelation relation = convertRelationDtoToRelation(companyUserRelationDto);
		
		relation.setUserId(userId);
		
		return convertRelationToRelationDto(relationRepository.save(relation));
	}

	
//	public CompanyUserRelationDto createCompanyToUserRelation(CompanyUserRelationDto companyUserRelationDto) {
//		// TODO Auto-generated method stub
//		return convertRelationToRelationDto(createRelation(companyUserRelationDto));
//	}

	
	public CompanyUserRelationDto getRelationByCompanyAndUserType(Long companyId, Long userTypeId) {
		
		return convertRelationToRelationDto(
				relationRepository.findByCompanyId_idAndUserId_UserTypeId_id(companyId, userTypeId));
	}

	
	public List<CompanyUserRelationDto> getRelationByCompany(Long id) {
		
		List<CompanyUserRelation> relationList = relationRepository.findByCompanyId_id(id);
		
		
		
		return CompanyMapper.INSTANCE.convertToCompanyUserRelationDtoList(relationList);
	}

	
	public CompanyUserRelation getRelationByUser(User user) {
		
		return relationRepository.findByUserId_id(user.getId());
	}

	
	public CompanyUserRelation convertRelationDtoToRelation(CompanyUserRelationDto companyUserRelationDto) {
		
		return CompanyMapper.INSTANCE.convertToCompanyUserRelation(companyUserRelationDto);
	}

	
	public CompanyUserRelationDto convertRelationToRelationDto(CompanyUserRelation companyUserRelation) {
		
		return CompanyMapper.INSTANCE.convertCompanyUserRelationDto(companyUserRelation);
	}

}
