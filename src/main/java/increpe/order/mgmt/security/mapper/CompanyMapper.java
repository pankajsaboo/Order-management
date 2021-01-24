package increpe.order.mgmt.security.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import increpe.order.mgmt.model.Company;
import increpe.order.mgmt.model.CompanyTypeRelation;
import increpe.order.mgmt.model.CompanyUserRelation;
import increpe.order.mgmt.model.WorkAreaMaster;
import increpe.order.mgmt.security.dto.CompanyDto;
import increpe.order.mgmt.security.dto.CompanyTypeRelationDto;
import increpe.order.mgmt.security.dto.CompanyUserRelationDto;
import increpe.order.mgmt.security.dto.RegistrationRequest;
import increpe.order.mgmt.security.dto.WorkAreaMasterDto;

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
