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
	public CompanyDto createCompany(CompanyDto companyDto) {
		
		Company company = convertToCompany(companyDto);

		return convertToCompanyDto(companyRepository.save(company));
	}
	
	@Override
	public Company createCompany(Company company) {
		
		return companyRepository.save(company);
	}

	@Override
	public CompanyDto getCompany(Long id) {
		return convertToCompanyDto(companyRepository.findById(id).get());
	}

	@Override
	public Company getCompanyByName(String companyName) {
		return companyRepository.findByCompanyName(companyName);
	}

	@Override
	public CompanyDto getCompanyByCompanyName(String companyName) {

		return convertToCompanyDto(companyRepository.findByCompanyName(companyName));
	}

	@Override
	public CompanyDto updateCompany(CompanyDto companyDto) {
		
		if (companyRepository.existsById(companyDto.getId())) {

			Company company = convertToCompany(companyDto);

			return convertToCompanyDto(companyRepository.save(company));
			
		}

		return createCompany(companyDto);
	}

	@Override
	public boolean deleteCompany(CompanyDto companyDto) {
		
		if (companyRepository.existsById(companyDto.getId())) {
			
			companyRepository.deleteById(companyDto.getId());
			
			return companyRepository.existsById(companyDto.getId());
		}

		return false;
	}

	@Override
	public CompanyDto convertToCompanyDto(Company company) {

		CompanyDto dto = new CompanyDto();

		BeanUtils.copyProperties(company, dto);

		return dto;
	}

	@Override
	public Company convertToCompany(CompanyDto dto) {

		Company company = new Company();

		BeanUtils.copyProperties(dto, company);

		return company;
	}

}
