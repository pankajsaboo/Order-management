package design.boilerplate.springboot.security.service;

import java.util.List;

import design.boilerplate.springboot.model.UserWorkAreaRelation;
import design.boilerplate.springboot.security.dto.AuthenticatedUserDto;
import design.boilerplate.springboot.security.dto.CompanyDto;
import design.boilerplate.springboot.security.dto.CompanyUserRelationDto;
import design.boilerplate.springboot.security.dto.RegistrationRequest;
import design.boilerplate.springboot.security.dto.RegistrationResponse;
import design.boilerplate.springboot.security.dto.SalesPersonDto;
import design.boilerplate.springboot.security.dto.WorkAreaMasterDto;

public interface TraderService {
	
	RegistrationResponse createNewSalesPersonAccount(RegistrationRequest registrationRequest);
	
	List<CompanyUserRelationDto> getAllSalesPersonAccountList(Long id);
	
	SalesPersonDto updateSalesPersonDatails(SalesPersonDto salesPersonDto);
	
	boolean deleteSalesPersonAccount(Long id);
	
	AuthenticatedUserDto convertSalesPersonDtoToAuthenticatedUserDto(SalesPersonDto salesPersonDto);
	
	List<UserWorkAreaRelation> getMapping(Long id);
}
