package design.boilerplate.springboot.security.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import design.boilerplate.springboot.model.CompanyType;
import design.boilerplate.springboot.repository.CompanyTypeRepository;
import design.boilerplate.springboot.security.dto.CompanyTypeDto;

@Service
public class CompanyTypeServiceImpl implements CompanyTypeService {

	@Autowired
	CompanyTypeRepository companyTypeRepository;

	@Override
	public CompanyTypeDto createCompanyType(CompanyTypeDto companyTypeDto) {

		CompanyType companyType = convertToCompanyType(companyTypeDto);

		return convertToCompanyTypeDto(companyTypeRepository.save(companyType));
	}

	@Override
	public CompanyTypeDto getCompanyType(Long id) {
		return convertToCompanyTypeDto(companyTypeRepository.findById(id).get());
	}

	@Override
	public CompanyType getCompanyTypeByName(String companyTypeName) {
		return companyTypeRepository.findByCompanyTypeName(companyTypeName);
	}

	@Override
	public CompanyTypeDto getCompanyTypeByCompanyTypeName(String companyTypeName) {
		return convertToCompanyTypeDto(companyTypeRepository.findByCompanyTypeName(companyTypeName));
	}

	@Override
	public List<CompanyTypeDto> getCompanyTypesByStatus(String status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CompanyTypeDto updateCompanyType(CompanyTypeDto companyTypeDto) {

		if (companyTypeRepository.existsById(companyTypeDto.getId())) {

			CompanyType companyType = convertToCompanyType(companyTypeDto);

			return convertToCompanyTypeDto(companyTypeRepository.save(companyType));
			
		} else {

			return createCompanyType(companyTypeDto);
		}
	}

	@Override
	public boolean deleteCompanyType(CompanyTypeDto companyTypeDto) {
		
		CompanyType companyType = companyTypeRepository.findByCompanyTypeName(companyTypeDto.getCompanyTypeName());

		companyTypeRepository.delete(companyType);

		return companyTypeRepository.existsById(companyType.getId());
	}

	private CompanyTypeDto convertToCompanyTypeDto(CompanyType companyType) {

		CompanyTypeDto dto = new CompanyTypeDto();

		BeanUtils.copyProperties(companyType, dto);

		return dto;
	}

	private CompanyType convertToCompanyType(CompanyTypeDto dto) {

		CompanyType companyType = new CompanyType();

		BeanUtils.copyProperties(dto, companyType);

		return companyType;
	}

}
