package increpe.order.mgmt.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import increpe.order.mgmt.model.Company;
import increpe.order.mgmt.repository.CompanyRepository;
import increpe.order.mgmt.security.dto.CompanyDto;

@Service
public class CompanyService {

	@Autowired
	CompanyRepository companyRepository;

	
	public CompanyDto createCompany(CompanyDto companyDto) {

		Company company = convertToCompany(companyDto);

		return convertToCompanyDto(companyRepository.save(company));
	}

	
	public Company createCompany(Company company) {

		return companyRepository.save(company);
	}

	
	public CompanyDto getCompany(Long id) {
		return convertToCompanyDto(companyRepository.findById(id).get());
	}

	
	public Company getCompanyByName(String companyName) {
		return companyRepository.findByCompanyName(companyName);
	}

	
	public CompanyDto getCompanyByCompanyName(String companyName) {

		return convertToCompanyDto(companyRepository.findByCompanyName(companyName));
	}

	
	public CompanyDto updateCompany(CompanyDto companyDto) {

		if (companyRepository.existsById(companyDto.getId())) {

			Company company = convertToCompany(companyDto);

			return convertToCompanyDto(companyRepository.save(company));

		}

		return createCompany(companyDto);
	}

	
	public boolean deleteCompany(CompanyDto companyDto) {

		if (companyRepository.existsById(companyDto.getId())) {

			companyRepository.deleteById(companyDto.getId());

			return companyRepository.existsById(companyDto.getId());
		}

		return false;
	}

	
	public CompanyDto convertToCompanyDto(Company company) {

		CompanyDto dto = new CompanyDto();

		BeanUtils.copyProperties(company, dto);

		return dto;
	}

	
	public Company convertToCompany(CompanyDto dto) {

		Company company = new Company();

		BeanUtils.copyProperties(dto, company);

		return company;
	}

}
