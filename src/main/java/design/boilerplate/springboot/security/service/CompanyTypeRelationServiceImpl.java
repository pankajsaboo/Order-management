package design.boilerplate.springboot.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import design.boilerplate.springboot.model.Company;
import design.boilerplate.springboot.model.CompanyType;
import design.boilerplate.springboot.model.CompanyTypeRelation;
import design.boilerplate.springboot.repository.CompanyTypeRelationRepository;
import design.boilerplate.springboot.security.dto.CompanyDto;
import design.boilerplate.springboot.security.dto.CompanyTypeDto;
import design.boilerplate.springboot.security.dto.CompanyTypeRelationDto;
import design.boilerplate.springboot.security.mapper.CompanyMapper;

@Service
public class CompanyTypeRelationServiceImpl implements CompanyTypeRelationService {

	@Autowired
	CompanyTypeRelationRepository companyTypeRelationRepository;

	@Autowired
	CompanyService companyService;

	@Autowired
	CompanyTypeService companyTypeService;

	@Override
	public CompanyTypeRelation createRelation(CompanyTypeRelationDto companyTypeRelationDto) {
		
		CompanyTypeRelation relation = convertRelationDtoToRelation(companyTypeRelationDto);

		CompanyType companyType = companyTypeService
				.getCompanyTypeByName(relation.getCompanyTypeId().getCompanyTypeName());

		Company company = companyService.getCompanyByName(relation.getCompanyId().getCompanyName());

		// For case where single company exists as Trader as well as Buyer
		if (company == null) {
			company = companyService.createCompany(relation.getCompanyId());
		}

		relation.setCompanyId(company);

		relation.setCompanyTypeId(companyType);
		
		return companyTypeRelationRepository.save(relation);
	}
	

	@Override
	public CompanyTypeRelationDto createCompanyToCompanyTypeRelation(CompanyTypeRelationDto companyTypeRelationDto) {
		
		return convertRelationToRelationDto(createRelation(companyTypeRelationDto));
	}

	@Override
	public CompanyTypeRelationDto getRelation(Long id) {

		return companyTypeRelationRepository.existsById(id)
				? convertRelationToRelationDto(companyTypeRelationRepository.findById(id).get())
				: null;
	}

	@Override
	public CompanyTypeRelationDto getRelationByCompany(CompanyDto companyDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompanyTypeRelationDto> getRelationByCompanyType(CompanyTypeDto companyTypeDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CompanyTypeRelation convertRelationDtoToRelation(CompanyTypeRelationDto companyTypeRelationDto) {

		return CompanyMapper.INSTANCE.convertToCompanyTypeRelation(companyTypeRelationDto);
	}

	@Override
	public CompanyTypeRelationDto convertRelationToRelationDto(CompanyTypeRelation companyTypeRelation) {

		return CompanyMapper.INSTANCE.convertToCompanyTypeRelationDto(companyTypeRelation);
	}


}
