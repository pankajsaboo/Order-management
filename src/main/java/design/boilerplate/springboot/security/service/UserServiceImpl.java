package design.boilerplate.springboot.security.service;

import design.boilerplate.springboot.model.Company;
import design.boilerplate.springboot.model.Roles;
import design.boilerplate.springboot.model.User;
import design.boilerplate.springboot.repository.EmailTypeRepository;
import design.boilerplate.springboot.repository.EmailsRepository;
import design.boilerplate.springboot.repository.RolesRepository;
import design.boilerplate.springboot.repository.UserRepository;
import design.boilerplate.springboot.security.dto.AddressDto;
import design.boilerplate.springboot.security.dto.AuthenticatedUserDto;
import design.boilerplate.springboot.security.dto.CompanyDto;
import design.boilerplate.springboot.security.dto.RegistrationRequest;
import design.boilerplate.springboot.security.dto.RegistrationResponse;
import design.boilerplate.springboot.security.mapper.CompanyMapper;
import design.boilerplate.springboot.security.mapper.UserMapper;
import design.boilerplate.springboot.service.UserValidationService;
import design.boilerplate.springboot.utils.GeneralMessageAccessor;
import design.boilerplate.springboot.utils.ProjectConstants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created on Ağustos, 2020
 *
 * @author Faruk
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

	private static final String REGISTRATION_SUCCESSFUL = "registration_successful";

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	CompanyService companyService;
	
	@Autowired
	EmailsService emailsService;
	
	@Autowired
	PhoneService phoneService;
	
	@Autowired
	RolesService rolesService;
	
	@Autowired
	AddressService addressService;

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	UserValidationService userValidationService;

	@Autowired
	GeneralMessageAccessor generalMessageAccessor;

	@Override
	public User findByUsername(String username) {

		return userRepository.findByUsername(username);
	}

	@Override
	public RegistrationResponse registration(RegistrationRequest registrationRequest) {

//		userValidationService.validateUser(registrationRequest);
//		
//		Company companyId = registerCompany(registrationRequest);
//		
//		Roles userRole = rolesService.getRole(ProjectConstants.USER_ROLE_TYPE_ID_ARRAY[0]);
//
//		final User user = UserMapper.INSTANCE.convertToUser(registrationRequest);
//		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//		user.setUserRole(userRole);
//		user.setCompanyId(companyId);
//		
//		emailsService.createEmail(companyId, null, registrationRequest.getEmail(), 1L);
//		
//		phoneService.createPhone(companyId, null, registrationRequest.getPhone(), 1L);
//		
//		AddressDto addressDto = registrationRequest.getAddress();
//		
//		addressDto.setCompanyId(companyId);
//		
//		addressService.createAddress(addressDto);
//		
//		userRepository.save(user);
//
//		final String username = registrationRequest.getUsername();
//		final String registrationSuccessMessage = generalMessageAccessor.getMessage(null, REGISTRATION_SUCCESSFUL, username);
//
//		log.info("{} registered successfully!", username);
//
//		return new RegistrationResponse(registrationSuccessMessage);
		
		return null;
	}

	@Override
	public AuthenticatedUserDto findAuthenticatedUserByUsername(String username) {

		final User user = findByUsername(username);

		return UserMapper.INSTANCE.convertToAuthenticatedUserDto(user);
	}

	@Override
	public Company registerCompany(RegistrationRequest registrationRequest) {
		
//		CompanyDto compayDto = CompanyMapper.INSTANCE.covertToCompanyDto(registrationRequest);
//		
//		return companyService.createCompany(compayDto, ProjectConstants.COMPANY_TYPE_ID_ARRAY[0]);
		
		return null;
	}	
	
}
