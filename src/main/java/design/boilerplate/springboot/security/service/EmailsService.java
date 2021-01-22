package design.boilerplate.springboot.security.service;

import design.boilerplate.springboot.model.Company;
import design.boilerplate.springboot.model.Emails;
import design.boilerplate.springboot.model.User;
import design.boilerplate.springboot.security.dto.EmailsDto;

public interface EmailsService {

	//void createEmail(Company companyId, User userId, String emailId, Long emailTypeId);
	
	Emails createEmail(Emails email);
	
	EmailsDto createEmail(EmailsDto emailsDto);

	EmailsDto convertToEmailsDto(Emails email);

	Emails convertToEmails(EmailsDto dto);

}
