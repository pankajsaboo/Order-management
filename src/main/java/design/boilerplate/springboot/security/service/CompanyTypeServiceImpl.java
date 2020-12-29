package design.boilerplate.springboot.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import design.boilerplate.springboot.repository.CompanyTypeRepository;

@Service
public class CompanyTypeServiceImpl implements CompanyTypeService {
	
	@Autowired
	CompanyTypeRepository companyTypeRepository;

	@Override
	public String getCompanyTypeName(Long id) {
		
		 return companyTypeRepository.findById(id).get().getCompanyTypeName();
	}

}
