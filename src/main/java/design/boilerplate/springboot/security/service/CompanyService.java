package design.boilerplate.springboot.security.service;

import design.boilerplate.springboot.model.Company;
import design.boilerplate.springboot.security.dto.CompanyDto;

public interface CompanyService {
	
	CompanyDto createCompany(CompanyDto companyDto);

	CompanyDto getCompany(Long id);
	
	Company getCompanyByName(String companyName);
	
	CompanyDto getCompanyByCompanyName(String companyName);
	
	CompanyDto updateCompany(CompanyDto companyDto);
	
	boolean deleteCompany(CompanyDto companyDto);

}
