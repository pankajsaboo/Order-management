package design.boilerplate.springboot.security.service;

import design.boilerplate.springboot.model.Company;
import design.boilerplate.springboot.security.dto.CompanyDto;

public interface CompanyService {
	
	CompanyDto getCompany(Long id);
	
	Long createCompany(Company company);

}
