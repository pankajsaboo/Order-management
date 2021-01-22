package design.boilerplate.springboot.security.service;

import java.util.List;

import design.boilerplate.springboot.model.Company;
import design.boilerplate.springboot.model.CompanyUserRelation;
import design.boilerplate.springboot.model.User;
import design.boilerplate.springboot.security.dto.CompanyUserRelationDto;

public interface CompanyUserRelationService {

	CompanyUserRelation createRelation(CompanyUserRelationDto companyUserRelationDto);
	
	CompanyUserRelationDto createCompanyToUserRelation(CompanyUserRelationDto companyUserRelationDto);
	
	CompanyUserRelationDto getRelation(Long id);
	
	List<CompanyUserRelationDto> getRelationByCompany(Long id);
	
	CompanyUserRelationDto getRelationByUser(User user);
	
	CompanyUserRelation convertRelationDtoToRelation(CompanyUserRelationDto companyUserRelationDto);
	
	CompanyUserRelationDto convertRelationToRelationDto(CompanyUserRelation companyUserRelation);
}
