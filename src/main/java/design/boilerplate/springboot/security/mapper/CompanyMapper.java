package design.boilerplate.springboot.security.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import design.boilerplate.springboot.model.Company;
import design.boilerplate.springboot.model.CompanyTypeRelation;
import design.boilerplate.springboot.model.CompanyUserRelation;
import design.boilerplate.springboot.model.WorkAreaMaster;
import design.boilerplate.springboot.security.dto.CompanyDto;
import design.boilerplate.springboot.security.dto.CompanyTypeRelationDto;
import design.boilerplate.springboot.security.dto.CompanyUserRelationDto;
import design.boilerplate.springboot.security.dto.RegistrationRequest;
import design.boilerplate.springboot.security.dto.TraderDto;
import design.boilerplate.springboot.security.dto.WorkAreaMasterDto;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CompanyMapper {
	
	CompanyMapper INSTANCE = Mappers.getMapper(CompanyMapper.class);
	
	Company convertToCompany(CompanyDto companyDto);
	
	CompanyDto convertToCompanyDto(Company company);
	
	CompanyTypeRelationDto convertToCompanyTypeRelationDto(RegistrationRequest registrationRequest);
	
	CompanyTypeRelation convertToCompanyTypeRelation(CompanyTypeRelationDto companyTypeRelationDto);
	
	CompanyTypeRelationDto convertToCompanyTypeRelationDto(CompanyTypeRelation companyTypeRelation);
	
	CompanyUserRelation convertToCompanyUserRelation(CompanyUserRelationDto companyUserRelationDto);
	
	CompanyUserRelationDto convertCompanyUserRelationDto(CompanyUserRelation companyUserRelation);
	
	List<CompanyUserRelationDto> convertToCompanyUserRelationDtoList(List<CompanyUserRelation> relationList);
	
	WorkAreaMasterDto convertToWorkAreaMasterDto(WorkAreaMaster workAreaMaster);
	
	WorkAreaMaster convertToWorkAreaMaster(WorkAreaMasterDto workAreaMasterDto);
	
	List<WorkAreaMasterDto> convertToWorkAreaMasterDtoList(List<WorkAreaMaster> masterList);
	
	List<WorkAreaMaster> convertToWorkAreaMasterList(List<WorkAreaMasterDto> masterDtoList);
}
