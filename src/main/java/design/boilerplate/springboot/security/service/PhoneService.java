package design.boilerplate.springboot.security.service;

import design.boilerplate.springboot.model.Company;
import design.boilerplate.springboot.model.User;

public interface PhoneService {
	
	void createPhone(Company companyId, User userId, String phoneNumber, Long phoneTypeId);

}
