package design.boilerplate.springboot.security.service;

import org.springframework.beans.factory.annotation.Autowired;

import design.boilerplate.springboot.model.Company;
import design.boilerplate.springboot.model.CompanyType;
import design.boilerplate.springboot.model.CompanyTypeRelation;
import design.boilerplate.springboot.repository.CompanyTypeRelationRepository;
import design.boilerplate.springboot.security.dto.CompanyTypeRelationDto;

public class CompanyTypeRelationServiceImpl implements CompanyTypeRelationService {
	
	@Autowired
	CompanyTypeRelationRepository companyTypeRelationRepository;

	@Override
	public Long mapCompanyToType(Company company, CompanyType companyType) {
		
		return null;
	}

	

	

}
