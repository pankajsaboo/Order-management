package design.boilerplate.springboot.security.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import design.boilerplate.springboot.model.Address;
import design.boilerplate.springboot.model.Company;
import design.boilerplate.springboot.model.Emails;
import design.boilerplate.springboot.model.Phone;
import design.boilerplate.springboot.model.User;
import design.boilerplate.springboot.security.dto.AddressDto;
import design.boilerplate.springboot.security.dto.EmailTypeDto;
import design.boilerplate.springboot.security.dto.EmailsDto;
import design.boilerplate.springboot.security.dto.PhonesDto;
import design.boilerplate.springboot.security.dto.RegistrationRequest;
import design.boilerplate.springboot.security.dto.RegistrationResponse;

public interface RegistrationService extends UserDetailsService {
	
	RegistrationResponse registerCustomer(RegistrationRequest request);
	
	Company registerCompany(RegistrationRequest request);
	
	User registerUser(RegistrationRequest request);
	
	Emails registerEmail(EmailsDto eDto, Company companyId, User userId);
	
	Phone registerPhone(PhonesDto pDto, Company companyId, User userId);
	
	Address registerAddress(AddressDto aDto, Company companyId, User userId);

	RegistrationResponse registerBuyer(RegistrationRequest registrationRequest);
	
	RegistrationResponse registerSalesPerson(RegistrationRequest registrationRequest);
}
