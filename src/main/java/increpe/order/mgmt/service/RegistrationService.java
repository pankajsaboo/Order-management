package increpe.order.mgmt.service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import increpe.order.mgmt.model.Address;
import increpe.order.mgmt.model.Company;
import increpe.order.mgmt.model.Emails;
import increpe.order.mgmt.model.Phone;
import increpe.order.mgmt.model.Roles;
import increpe.order.mgmt.model.User;
import increpe.order.mgmt.model.UserWorkAreaRelation;
import increpe.order.mgmt.model.WorkAreaMaster;
import increpe.order.mgmt.repository.UserWorkAreaRelationRepository;
import increpe.order.mgmt.security.dto.AddressDto;
import increpe.order.mgmt.security.dto.AuthenticatedUserDto;
import increpe.order.mgmt.security.dto.CompanyTypeRelationDto;
import increpe.order.mgmt.security.dto.CompanyUserRelationDto;
import increpe.order.mgmt.security.dto.EmailsDto;
import increpe.order.mgmt.security.dto.PhonesDto;
import increpe.order.mgmt.security.dto.RegistrationRequest;
import increpe.order.mgmt.security.dto.RegistrationResponse;
import increpe.order.mgmt.security.dto.WorkAreaMasterDto;
import increpe.order.mgmt.security.mapper.CompanyMapper;
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
	UserWorkAreaRelationRepository relationRepository;

	
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

	
	public Company registerCompany(RegistrationRequest registrationRequest) {

		CompanyTypeRelationDto relationDto = CompanyMapper.INSTANCE
				.convertToCompanyTypeRelationDto(registrationRequest);

		return companyTypeRelationService.createRelation(relationDto).getCompanyId();
	}

	
	public User registerUser(RegistrationRequest request) {
		
		CompanyUserRelationDto relationDto = new CompanyUserRelationDto();
		
		relationDto.setCompanyId(request.getCompanyId());
		
		relationDto.setUserId(request.getUserId());

		return companyUserRelationService.createRelation(relationDto).getUserId();
	}

	
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

	
	public Emails registerEmail(EmailsDto eDto, Company companyId, User userId) {

		Emails emailId = emailService.convertToEmails(eDto);

		emailId.setCompanyId(companyId);

		emailId.setUserId(userId);

		return emailService.createEmail(emailId);
	}

	
	public Phone registerPhone(PhonesDto pDto, Company companyId, User userId) {

		Phone phoneId = phoneService.convertToPhone(pDto);

		phoneId.setCompanyId(companyId);

		phoneId.setUserId(userId);

		return phoneService.createPhone(phoneId);
	}

	
	public Address registerAddress(AddressDto aDto, Company companyId, User userId) {

		Address addressId = addressService.convertAddressDtoToAddress(aDto);

		addressId.setCompanyId(companyId);

		addressId.setUserId(userId);

		return addressService.createAddress(addressId);
	}

	
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
