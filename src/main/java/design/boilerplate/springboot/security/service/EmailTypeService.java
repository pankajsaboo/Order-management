package design.boilerplate.springboot.security.service;

import java.util.List;

import design.boilerplate.springboot.model.EmailType;
import design.boilerplate.springboot.security.dto.EmailTypeDto;

public interface EmailTypeService {
	
	EmailTypeDto createEmailType(EmailTypeDto emailTypeDto);

	EmailTypeDto getEmailType(Long id);
	
	EmailType getEmailTypeByName(String emailTypeName);
	
	EmailTypeDto getEmailTypeByEmailTypeName(String emailTypeName);
	
	List<EmailTypeDto> getEmailTypesByStatus(String status);
	
	EmailTypeDto updateEmailType(EmailTypeDto emailTypeDto);
	
	boolean deleteEmailType(EmailTypeDto emailTypeDto);

}
