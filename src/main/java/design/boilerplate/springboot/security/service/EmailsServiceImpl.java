package design.boilerplate.springboot.security.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import design.boilerplate.springboot.model.Api;
import design.boilerplate.springboot.model.Company;
import design.boilerplate.springboot.model.Country;
import design.boilerplate.springboot.model.EmailType;
import design.boilerplate.springboot.model.Emails;
import design.boilerplate.springboot.model.User;
import design.boilerplate.springboot.repository.EmailsRepository;
import design.boilerplate.springboot.security.dto.ApiDto;
import design.boilerplate.springboot.security.dto.EmailTypeDto;
import design.boilerplate.springboot.security.dto.EmailsDto;

@Service
public class EmailsServiceImpl implements EmailsService {

	@Autowired
	EmailsRepository emailsRepository;

	@Autowired
	EmailTypeService emailTypeService;

//	@Override
//	public void createEmail(Company companyId, User userId, String emailId, Long emailTypeId) {
//		
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
//		
//	}
	
	@Override
	public Emails createEmail(Emails email) {
		
		EmailType emailTypeId = emailTypeService.getEmailTypeByName(email.getEmailTypeId().getEmailTypeName());
		
		email.setEmailTypeId(emailTypeId);
		
		return emailsRepository.save(email);
	}

	@Override
	public EmailsDto createEmail(EmailsDto emailsDto) {
		
		EmailType emailTypeId = emailTypeService.getEmailTypeByName(emailsDto.getEmailTypeId().getEmailTypeName());
		
		Emails email = convertToEmails(emailsDto);
		
		email.setEmailTypeId(emailTypeId);
		
		return convertToEmailsDto(email);
	}
	
	@Override
	public EmailsDto convertToEmailsDto(Emails email) {

		EmailsDto dto = new EmailsDto();
		
		EmailTypeDto typeDto = new EmailTypeDto();
		
		BeanUtils.copyProperties(email.getEmailTypeId(), typeDto);

		dto.setEmailTypeId(typeDto);

		BeanUtils.copyProperties(email, dto);

		return dto;
	}

	@Override
	public Emails convertToEmails(EmailsDto dto) {

		Emails emails = new Emails();
		
		EmailType type = new EmailType();
		
		BeanUtils.copyProperties(dto.getEmailTypeId(), type);
		
		emails.setEmailTypeId(type);

		BeanUtils.copyProperties(dto, emails);

		return emails;
	}

}
