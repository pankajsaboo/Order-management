package design.boilerplate.springboot.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import design.boilerplate.springboot.repository.CompanyTypeRepository;

@Service
public interface CompanyTypeService {
	
	String getCompanyTypeName(Long id);

}
