package design.boilerplate.springboot.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import design.boilerplate.springboot.model.Company;
import design.boilerplate.springboot.model.Country;
import design.boilerplate.springboot.model.EmailType;
import design.boilerplate.springboot.model.Emails;
import design.boilerplate.springboot.model.User;
import design.boilerplate.springboot.repository.EmailsRepository;

@Service
public class EmailsServiceImpl implements EmailsService {

	@Autowired
	EmailsRepository emailsRepository;

	@Autowired
	EmailTypeService emailTypeService;

	@Override
	public void createEmail(Company companyId, User userId, String emailId, Long emailTypeId) {
		
//		EmailType emailtype = emailTypeService.getEmailType(emailTypeId);
//
//		Emails email = new Emails();
//		
//		email.setEmailId(emailId);
//		email.setCompanyId(companyId);
//		email.setEmailTypeId(emailtype);
//		email.setUserId(userId);
//		
//		emailsRepository.save(email);
		
	}

	

}
