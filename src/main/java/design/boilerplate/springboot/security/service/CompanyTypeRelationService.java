package design.boilerplate.springboot.security.service;

import design.boilerplate.springboot.model.Company;
import design.boilerplate.springboot.model.CompanyType;

public interface CompanyTypeRelationService {
	
	Long mapCompanyToType(Company company, CompanyType companyType);

}
