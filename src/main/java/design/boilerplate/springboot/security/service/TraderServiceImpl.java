package design.boilerplate.springboot.security.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import design.boilerplate.springboot.model.City;
import design.boilerplate.springboot.model.User;
import design.boilerplate.springboot.model.UserWorkAreaRelation;
import design.boilerplate.springboot.model.WorkAreaMaster;
import design.boilerplate.springboot.repository.UserWorkAreaRelationRepository;
import design.boilerplate.springboot.repository.WorkAreaMasterRepository;
import design.boilerplate.springboot.security.dto.AddressDto;
import design.boilerplate.springboot.security.dto.AuthenticatedUserDto;
import design.boilerplate.springboot.security.dto.CompanyDto;
import design.boilerplate.springboot.security.dto.CompanyUserRelationDto;
import design.boilerplate.springboot.security.dto.RegistrationRequest;
import design.boilerplate.springboot.security.dto.RegistrationResponse;
import design.boilerplate.springboot.security.dto.SalesPersonDto;
import design.boilerplate.springboot.security.dto.WorkAreaMasterDto;
import design.boilerplate.springboot.security.mapper.UserMapper;

@Service
public class TraderServiceImpl implements TraderService {
	
	@Autowired
	AddressService addressService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	CompanyService companyService;
	
	@Autowired
	PhoneService phoneService;
	
	@Autowired 
	RegistrationService registrationService;
	
	@Autowired
	CompanyUserRelationService relationService;
	
	@Autowired
	UserWorkAreaRelationRepository mappingRelationRepository;
	
	@Override
	public RegistrationResponse createNewSalesPersonAccount(RegistrationRequest registrationRequest) {
		
		return registrationService.registerSalesPerson(registrationRequest);
	}

	@Override
	public List<CompanyUserRelationDto> getAllSalesPersonAccountList(Long id) {
		
		return relationService.getRelationByCompany(id);
	}

	@Override
	public SalesPersonDto updateSalesPersonDatails(SalesPersonDto salesPersonDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteSalesPersonAccount(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public AuthenticatedUserDto convertSalesPersonDtoToAuthenticatedUserDto(SalesPersonDto salesPersonDto) {
		
		return UserMapper.INSTANCE.convertToAuthenticatedUserDto(salesPersonDto);
	}

	@Override
	public List<UserWorkAreaRelation> getMapping(Long id) {
		
		return mappingRelationRepository.findByUserId_id(id);
	}

}
