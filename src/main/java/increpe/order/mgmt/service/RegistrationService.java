package increpe.order.mgmt.service;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import increpe.order.mgmt.model.Address;
import increpe.order.mgmt.model.Company;
import increpe.order.mgmt.model.Emails;
import increpe.order.mgmt.model.Phone;
import increpe.order.mgmt.model.Roles;
import increpe.order.mgmt.model.SalesPerson;
import increpe.order.mgmt.model.User;
import increpe.order.mgmt.model.SalesPersonWorkAreaRelation;
import increpe.order.mgmt.model.WorkAreaMaster;
import increpe.order.mgmt.repository.SalesPersonWorkAreaRelationRepository;
import increpe.order.mgmt.security.dto.AddressDto;
import increpe.order.mgmt.security.dto.AuthenticatedUserDto;
import increpe.order.mgmt.security.dto.CompanyDto;
import increpe.order.mgmt.security.dto.CompanyTypeRelationDto;
import increpe.order.mgmt.security.dto.CompanyUserRelationDto;
import increpe.order.mgmt.security.dto.EmailsDto;
import increpe.order.mgmt.security.dto.PhonesDto;
import increpe.order.mgmt.security.dto.RegistrationRequest;
import increpe.order.mgmt.security.dto.RegistrationResponse;
import increpe.order.mgmt.security.dto.SalesPersonDto;
import increpe.order.mgmt.security.dto.WorkAreaMasterDto;
import increpe.order.mgmt.security.mapper.CompanyMapper;
import increpe.order.mgmt.security.mapper.UserMapper;
import increpe.order.mgmt.security.service.UserService;
import increpe.order.mgmt.utils.GeneralMessageAccessor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RegistrationService {

	private static final String REGISTRATION_SUCCESSFUL = "registration_successful";
	private static final String USERNAME_OR_PASSWORD_INVALID = "Invalid username or password.";

	@Autowired
	CompanyTypeRelationService companyTypeRelationService;

	@Autowired
	CompanyUserRelationService companyUserRelationService;

	@Autowired
	CompanyService companyServie;

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	UserValidationService userValidationService;

	@Autowired
	GeneralMessageAccessor generalMessageAccessor;

	@Autowired
	EmailService emailService;

	@Autowired
	PhoneService phoneService;

	@Autowired
	AddressService addressService;

	@Autowired
	UserService userService;

	@Autowired
	WorkAreaMasterService workAreaService;

	@Autowired
	SalesPersonService salesPersonService;

	public RegistrationResponse register(RegistrationRequest registrationRequest) {

		userValidationService.validateUser(registrationRequest);

		CompanyDto companyId = registerCompany(registrationRequest);

		AuthenticatedUserDto userId = registerUser(companyId, registrationRequest.getUserId());

		registerAddress(registrationRequest.getAddressId(), companyId, userId);

		registerEmail(registrationRequest.getEmailId(), companyId, userId);

		registerPhone(registrationRequest.getPhoneId(), companyId, userId);

		final String username = userId.getUsername();
		final String registrationSuccessMessage = generalMessageAccessor.getMessage(null, REGISTRATION_SUCCESSFUL,
				username);

		log.info("{} registered successfully!", username);

		return new RegistrationResponse(registrationSuccessMessage);
	}

	public Company registerCustomer(RegistrationRequest registrationRequest) {

		CompanyDto companyId = registerCompany(registrationRequest);

		AuthenticatedUserDto userId = registerUser(companyId, registrationRequest.getUserId());

		registerAddress(registrationRequest.getAddressId(), companyId, userId);

		registerEmail(registrationRequest.getEmailId(), companyId, userId);

		registerPhone(registrationRequest.getPhoneId(), companyId, userId);

		return companyServie.convertToCompany(companyId);
	}

	public RegistrationResponse registerSalesPerson(SalesPersonDto salesPersonDto) {

		userValidationService.validateSalesPerson(salesPersonDto);

		CompanyDto companyId = salesPersonDto.getCompanyTypeRelationId().getCompanyId();

		AuthenticatedUserDto userId = registerUser(companyId, salesPersonDto.getUserId());

		salesPersonDto.setUserId(userId);

		List<WorkAreaMasterDto> workAreaList = salesPersonDto.getWorkAreaMasterList();

		SalesPerson salesPerson = salesPersonService.creatSalesPersonAccount(salesPersonDto);

		salesPersonService.mapWorkAreaToSalesPerson(workAreaList, salesPerson);

		registerAddress(salesPersonDto.getAddressId(), companyId, userId);

		registerEmail(salesPersonDto.getEmailId(), companyId, userId);

		registerPhone(salesPersonDto.getPhoneId(), companyId, userId);

		final String username = userId.getUsername();
		final String registrationSuccessMessage = generalMessageAccessor.getMessage(null, REGISTRATION_SUCCESSFUL,
				username);

		log.info("{} registered successfully!", username);

		return new RegistrationResponse(registrationSuccessMessage);
	}

	public CompanyDto registerCompany(RegistrationRequest registrationRequest) {

		CompanyTypeRelationDto relationDto = registrationRequest.getCompanyTypeRelationId();

		return companyTypeRelationService
				.convertRelationToRelationDto(companyTypeRelationService.createRelation(relationDto)).getCompanyId();
	}

	public AuthenticatedUserDto registerUser(CompanyDto companyId, AuthenticatedUserDto userId) {

		CompanyUserRelationDto relationDto = new CompanyUserRelationDto();

		relationDto.setCompanyId(companyId);

		relationDto.setUserId(userId);

		return companyUserRelationService.createRelation(relationDto).getUserId();
	}

	public EmailsDto registerEmail(EmailsDto emailDto, CompanyDto companyId, AuthenticatedUserDto userId) {

		if (Objects.isNull(emailDto))
			return null;

		EmailsDto updatedDto = new EmailsDto();
		BeanUtils.copyProperties(emailDto, updatedDto);

		updatedDto.setCompanyId(companyId);
		updatedDto.setUserId(userId);

		return emailService.createEmail(updatedDto);
	}

	public PhonesDto registerPhone(PhonesDto phoneDto, CompanyDto companyId, AuthenticatedUserDto userId) {

		if (Objects.isNull(phoneDto))
			return null;

		PhonesDto updatedDto = new PhonesDto();
		BeanUtils.copyProperties(phoneDto, updatedDto);

		updatedDto.setCompanyId(companyId);
		updatedDto.setUserId(userId);

		return phoneService.createPhone(updatedDto);
	}

	public AddressDto registerAddress(AddressDto addressDto, CompanyDto companyId, AuthenticatedUserDto userId) {

		if (Objects.isNull(addressDto))
			return null;

		AddressDto updatedDto = new AddressDto();
		BeanUtils.copyProperties(addressDto, updatedDto);

		updatedDto.setCompanyId(companyId);
		updatedDto.setUserId(userId);

		return addressService.createAddress(updatedDto);

	}
}
