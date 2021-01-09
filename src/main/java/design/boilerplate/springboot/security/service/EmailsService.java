package design.boilerplate.springboot.security.service;

import design.boilerplate.springboot.model.Company;
import design.boilerplate.springboot.model.User;

public interface EmailsService {

	void createEmail(Company companyId, User userId, String emailId, Long emailTypeId);
}
