package design.boilerplate.springboot.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import design.boilerplate.springboot.model.Company;
import design.boilerplate.springboot.model.CompanyUserRelation;
import design.boilerplate.springboot.model.User;
import design.boilerplate.springboot.repository.CompanyRepository;
import design.boilerplate.springboot.repository.CompanyUserRelationRepository;
import design.boilerplate.springboot.repository.UserRepository;
import design.boilerplate.springboot.security.dto.CompanyUserRelationDto;
import design.boilerplate.springboot.security.mapper.CompanyMapper;

@Service
public class CompanyUserRelationServiceImpl implements CompanyUserRelationService {
	
	@Autowired
	CompanyUserRelationRepository relationRepository;
	
	@Autowired
	CompanyService companyService;
	
	@Autowired
	UserService userService;

	@Override
	public CompanyUserRelation createRelation(CompanyUserRelationDto companyUserRelationDto) {
		
		CompanyUserRelation relation = convertRelationDtoToRelation(companyUserRelationDto);
		
		User userId = userService.createUser(companyUserRelationDto.getUserId());
		
		relation.setUserId(userId);
		
		return relationRepository.save(relation);
	}

	@Override
	public CompanyUserRelationDto createCompanyToUserRelation(CompanyUserRelationDto companyUserRelationDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CompanyUserRelationDto getRelation(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompanyUserRelationDto> getRelationByCompany(Long id) {
		
		List<CompanyUserRelation> relationList = relationRepository.findByCompanyId_id(id);
		
		
		
		return CompanyMapper.INSTANCE.convertToCompanyUserRelationDtoList(relationList);
	}

	@Override
	public CompanyUserRelationDto getRelationByUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CompanyUserRelation convertRelationDtoToRelation(CompanyUserRelationDto companyUserRelationDto) {
		
		return CompanyMapper.INSTANCE.convertToCompanyUserRelation(companyUserRelationDto);
	}

	@Override
	public CompanyUserRelationDto convertRelationToRelationDto(CompanyUserRelation companyUserRelation) {
		
		return CompanyMapper.INSTANCE.convertCompanyUserRelationDto(companyUserRelation);
	}

}
