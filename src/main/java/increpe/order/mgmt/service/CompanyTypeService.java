package increpe.order.mgmt.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import increpe.order.mgmt.model.CompanyType;
import increpe.order.mgmt.repository.CompanyTypeRepository;
import increpe.order.mgmt.security.dto.CompanyTypeDto;

@Service
public class CompanyTypeService {

	@Autowired
	CompanyTypeRepository companyTypeRepository;

	
	public CompanyTypeDto createCompanyType(CompanyTypeDto companyTypeDto) {

		CompanyType companyType = convertToCompanyType(companyTypeDto);

		return convertToCompanyTypeDto(companyTypeRepository.save(companyType));
	}

	
	public CompanyType getCompanyType(Long id) {
		return companyTypeRepository.findById(id).get();
	}

	
	public CompanyType getCompanyTypeByName(String companyTypeName) {
		return companyTypeRepository.findByCompanyTypeName(companyTypeName);
	}

	
	public CompanyTypeDto getCompanyTypeByCompanyTypeName(String companyTypeName) {
		return convertToCompanyTypeDto(companyTypeRepository.findByCompanyTypeName(companyTypeName));
	}

	
	public List<CompanyTypeDto> getCompanyTypesByStatus(String status) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public CompanyTypeDto updateCompanyType(CompanyTypeDto companyTypeDto) {

		if (companyTypeRepository.existsById(companyTypeDto.getId())) {

			CompanyType companyType = convertToCompanyType(companyTypeDto);

			return convertToCompanyTypeDto(companyTypeRepository.save(companyType));
			
		} else {

			return createCompanyType(companyTypeDto);
		}
	}

	
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
