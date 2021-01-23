package increpe.order.mgmt.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import increpe.order.mgmt.model.EmailType;
import increpe.order.mgmt.model.Emails;
import increpe.order.mgmt.repository.EmailsRepository;
import increpe.order.mgmt.security.dto.EmailTypeDto;
import increpe.order.mgmt.security.dto.EmailsDto;

@Service
public class EmailService {

	@Autowired
	EmailsRepository emailsRepository;

	@Autowired
	EmailTypeService emailTypeService;

//	
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
	
	
	public Emails createEmail(Emails email) {
		
		EmailType emailTypeId = emailTypeService.getEmailTypeByName(email.getEmailTypeId().getEmailTypeName());
		
		email.setEmailTypeId(emailTypeId);
		
		return emailsRepository.save(email);
	}

	
	public EmailsDto createEmail(EmailsDto emailsDto) {
		
		EmailType emailTypeId = emailTypeService.getEmailTypeByName(emailsDto.getEmailTypeId().getEmailTypeName());
		
		Emails email = convertToEmails(emailsDto);
		
		email.setEmailTypeId(emailTypeId);
		
		return convertToEmailsDto(email);
	}
	
	
	public EmailsDto convertToEmailsDto(Emails email) {

		EmailsDto dto = new EmailsDto();
		
		EmailTypeDto typeDto = new EmailTypeDto();
		
		BeanUtils.copyProperties(email.getEmailTypeId(), typeDto);

		dto.setEmailTypeId(typeDto);

		BeanUtils.copyProperties(email, dto);

		return dto;
	}

	
	public Emails convertToEmails(EmailsDto dto) {

		Emails emails = new Emails();
		
		EmailType type = new EmailType();
		
		BeanUtils.copyProperties(dto.getEmailTypeId(), type);
		
		emails.setEmailTypeId(type);

		BeanUtils.copyProperties(dto, emails);

		return emails;
	}

}
