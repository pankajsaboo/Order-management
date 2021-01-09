package design.boilerplate.springboot.security.service;

import java.util.List;


import design.boilerplate.springboot.model.CompanyType;
import design.boilerplate.springboot.security.dto.CompanyTypeDto;

public interface CompanyTypeService {
	
	CompanyTypeDto createCompanyType(CompanyTypeDto companyTypeDto);

	CompanyTypeDto getCompanyType(Long id);
	
	CompanyType getCompanyTypeByName(String companyTypeName);
	
	CompanyTypeDto getCompanyTypeByCompanyTypeName(String companyTypeName);
	
	List<CompanyTypeDto> getCompanyTypesByStatus(String status);
	
	CompanyTypeDto updateCompanyType(CompanyTypeDto companyTypeDto);
	
	boolean deleteCompanyType(CompanyTypeDto companyTypeDto);

}
