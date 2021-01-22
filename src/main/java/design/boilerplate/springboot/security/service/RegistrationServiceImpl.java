package design.boilerplate.springboot.security.service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import design.boilerplate.springboot.model.Address;
import design.boilerplate.springboot.model.Company;
import design.boilerplate.springboot.model.Emails;
import design.boilerplate.springboot.model.Phone;
import design.boilerplate.springboot.model.Roles;
import design.boilerplate.springboot.model.User;
import design.boilerplate.springboot.model.UserType;
import design.boilerplate.springboot.model.UserWorkAreaRelation;
import design.boilerplate.springboot.model.WorkAreaMaster;
import design.boilerplate.springboot.repository.UserWorkAreaRelationRepository;
import design.boilerplate.springboot.security.dto.AddressDto;
import design.boilerplate.springboot.security.dto.AuthenticatedUserDto;
import design.boilerplate.springboot.security.dto.CompanyTypeRelationDto;
import design.boilerplate.springboot.security.dto.CompanyUserRelationDto;
import design.boilerplate.springboot.security.dto.EmailTypeDto;
import design.boilerplate.springboot.security.dto.EmailsDto;
import design.boilerplate.springboot.security.dto.PhonesDto;
import design.boilerplate.springboot.security.dto.RegistrationRequest;
import design.boilerplate.springboot.security.dto.RegistrationResponse;
import design.boilerplate.springboot.security.dto.WorkAreaMasterDto;
import design.boilerplate.springboot.security.mapper.CompanyMapper;
import design.boilerplate.springboot.security.mapper.UserMapper;
import design.boilerplate.springboot.service.UserValidationService;
import design.boilerplate.springboot.utils.GeneralMessageAccessor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RegistrationServiceImpl implements RegistrationService {

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
	EmailsService emailsService;

	@Autowired
	PhoneService phoneService;

	@Autowired
	AddressService addressService;

	@Autowired
	UserService userService;
	
	@Autowired
	WorkAreaMasterService workAreaService;
	
	@Autowired
	UserWorkAreaRelationRepository relationRepository;

	@Override
	public RegistrationResponse registerCustomer(RegistrationRequest registrationRequest) {

		userValidationService.validateUser(registrationRequest);

		Company companyId = registerCompany(registrationRequest);

		User userId = registerUser(registrationRequest);

		Address address = registerAddress(registrationRequest.getAddressId(), companyId, userId);

		Emails email = registerEmail(registrationRequest.getEmailId(), companyId, userId);

		Phone phone = registerPhone(registrationRequest.getPhoneId(), companyId, userId);

		final String username = userId.getUsername();
		final String registrationSuccessMessage = generalMessageAccessor.getMessage(null, REGISTRATION_SUCCESSFUL,
				username);

		log.info("{} registered successfully!", username);

		return new RegistrationResponse(registrationSuccessMessage);
	}

	@Override
	public RegistrationResponse registerBuyer(RegistrationRequest registrationRequest) {

		userValidationService.validateUser(registrationRequest);

		Company companyId = registerCompany(registrationRequest);

		User userId = registerUser(registrationRequest);

		Address address = registerAddress(registrationRequest.getAddressId(), companyId, userId);

		Emails email = registerEmail(registrationRequest.getEmailId(), companyId, userId);

		Phone phone = registerPhone(registrationRequest.getPhoneId(), companyId, userId);

		final String username = userId.getUsername();
		final String registrationSuccessMessage = generalMessageAccessor.getMessage(null, REGISTRATION_SUCCESSFUL,
				username);

		log.info("{} registered successfully!", username);

		return new RegistrationResponse(registrationSuccessMessage);
	}

	@Override
	public Company registerCompany(RegistrationRequest registrationRequest) {

		CompanyTypeRelationDto relationDto = CompanyMapper.INSTANCE
				.convertToCompanyTypeRelationDto(registrationRequest);

		return companyTypeRelationService.createRelation(relationDto).getCompanyId();
	}

	@Override
	public User registerUser(RegistrationRequest request) {
		
		CompanyUserRelationDto relationDto = new CompanyUserRelationDto();
		
		relationDto.setCompanyId(request.getCompanyId());
		
		relationDto.setUserId(request.getUserId());

		return companyUserRelationService.createRelation(relationDto).getUserId();
	}

	@Override
	public RegistrationResponse registerSalesPerson(RegistrationRequest registrationRequest) {

		userValidationService.validateUser(registrationRequest);
		
		Company companyId = CompanyMapper.INSTANCE.convertToCompany(registrationRequest.getCompanyId());

//		Company companyId = companyTypeRelationService
//				.convertRelationDtoToRelation(
//						companyTypeRelationService.getRelationByCompany(registrationRequest.getCompanyId()))
//				.getCompanyId();

		User userId = registerUser(registrationRequest);
		
		mapWorkAreaToUser(registrationRequest.getWorkAreaList(), userId);

		Address address = registerAddress(registrationRequest.getAddressId(), companyId, userId);

		Emails email = registerEmail(registrationRequest.getEmailId(), companyId, userId);

		Phone phone = registerPhone(registrationRequest.getPhoneId(), companyId, userId);

		final String username = userId.getUsername();
		final String registrationSuccessMessage = generalMessageAccessor.getMessage(null, REGISTRATION_SUCCESSFUL,
				username);

		log.info("{} registered successfully!", username);

		return new RegistrationResponse(registrationSuccessMessage);
	}

	@Override
	public Emails registerEmail(EmailsDto eDto, Company companyId, User userId) {

		Emails emailId = emailsService.convertToEmails(eDto);

		emailId.setCompanyId(companyId);

		emailId.setUserId(userId);

		return emailsService.createEmail(emailId);
	}

	@Override
	public Phone registerPhone(PhonesDto pDto, Company companyId, User userId) {

		Phone phoneId = phoneService.convertToPhone(pDto);

		phoneId.setCompanyId(companyId);

		phoneId.setUserId(userId);

		return phoneService.createPhone(phoneId);
	}

	@Override
	public Address registerAddress(AddressDto aDto, Company companyId, User userId) {

		Address addressId = addressService.convertAddressDtoToAddress(aDto);

		addressId.setCompanyId(companyId);

		addressId.setUserId(userId);

		return addressService.createAddress(addressId);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		final AuthenticatedUserDto authenticatedUser = userService.findAuthenticatedUserByUsername(username);

		if (Objects.isNull(authenticatedUser)) {
			throw new UsernameNotFoundException(USERNAME_OR_PASSWORD_INVALID);
		}

		final String authenticatedUsername = authenticatedUser.getUsername();
		final String authenticatedPassword = authenticatedUser.getPassword();
		final String userRole = authenticatedUser.getUserRole().getTitle();
		final SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(userRole);

		return (UserDetails) new User(authenticatedUsername, authenticatedPassword,
				(Roles) Collections.singletonList(grantedAuthority));
	}
	
	private UserWorkAreaRelation mapWorkAreaToUser(List<WorkAreaMasterDto> workAreaMasterDtoList, User userId) {
		
		List<WorkAreaMaster> masterList = CompanyMapper.INSTANCE.convertToWorkAreaMasterList(workAreaMasterDtoList);
		
		UserWorkAreaRelation relation = new UserWorkAreaRelation();
		
		relation.setUserId(userId);
		
		relation.setWorkAreaMasterIdList(masterList);
		
		return relationRepository.save(relation);
	}
}
