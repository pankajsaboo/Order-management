package design.boilerplate.springboot.security.service;

import java.util.List;

import design.boilerplate.springboot.model.Company;
import design.boilerplate.springboot.model.CompanyType;
import design.boilerplate.springboot.model.CompanyTypeRelation;
import design.boilerplate.springboot.security.dto.CompanyDto;
import design.boilerplate.springboot.security.dto.CompanyTypeDto;
import design.boilerplate.springboot.security.dto.CompanyTypeRelationDto;

public interface CompanyTypeRelationService {
	
	CompanyTypeRelation createRelation(CompanyTypeRelationDto companyTypeRelationDto);
	
	CompanyTypeRelationDto createCompanyToCompanyTypeRelation(CompanyTypeRelationDto companyTypeRelationDto);
	
	CompanyTypeRelationDto getRelation(Long id);
	
	CompanyTypeRelationDto getRelationByCompany(CompanyDto companyDto);
	
	List<CompanyTypeRelationDto> getRelationByCompanyType(CompanyTypeDto companyTypeDto);

	CompanyTypeRelationDto convertRelationToRelationDto(CompanyTypeRelation companyTypeRelation);

	CompanyTypeRelation convertRelationDtoToRelation(CompanyTypeRelationDto companyTypeRelationDto);

}
