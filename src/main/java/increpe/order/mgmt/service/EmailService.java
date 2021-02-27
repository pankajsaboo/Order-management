package increpe.order.mgmt.service;

import java.util.Objects;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import increpe.order.mgmt.model.EmailType;
import increpe.order.mgmt.model.Emails;
import increpe.order.mgmt.repository.EmailsRepository;
import increpe.order.mgmt.security.dto.EmailTypeDto;
import increpe.order.mgmt.security.dto.EmailsDto;
import increpe.order.mgmt.security.mapper.CompanyMapper;

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
		
		return convertToEmailsDto(emailsRepository.save(email));
	}
	
	public EmailsDto getEmailByUserId(Long id) {
		
		return convertToEmailsDto(emailsRepository.findByUserId_id(id));
	}
	
	public EmailsDto updateEmail(EmailsDto dto) {
		
		if(Objects.isNull(dto.getId())) {
			return createEmail(dto);
		}
		
		return convertToEmailsDto(emailsRepository.save(convertToEmails(dto)));
	}
	
	public EmailsDto convertToEmailsDto(Emails email) {
		
		if(Objects.isNull(email))
			return null;

		return CompanyMapper.INSTANCE.convertToEmailsDto(email);
	}

	
	public Emails convertToEmails(EmailsDto dto) {
		
		if(Objects.isNull(dto))
			return null;

		return CompanyMapper.INSTANCE.convertToEmails(dto);
	}

}
