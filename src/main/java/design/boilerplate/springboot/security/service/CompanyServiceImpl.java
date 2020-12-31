package design.boilerplate.springboot.security.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import design.boilerplate.springboot.model.Company;
import design.boilerplate.springboot.repository.CompanyRepository;
import design.boilerplate.springboot.security.dto.CompanyDto;

@Service
public class CompanyServiceImpl implements CompanyService{

	@Autowired
	CompanyRepository companyRepository;
	
	@Override
	public CompanyDto getCompany(Long id) {
		
		CompanyDto companyDto = new CompanyDto();
		
		BeanUtils.copyProperties(companyRepository.findById(id).get(), companyDto);
		
		return companyDto;
	}

	@Override
	public Long createCompany(Company company) {
		
		return companyRepository.save(company).getId();
	}

}
