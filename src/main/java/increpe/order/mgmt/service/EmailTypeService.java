package increpe.order.mgmt.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import increpe.order.mgmt.model.EmailType;
import increpe.order.mgmt.repository.EmailTypeRepository;
import increpe.order.mgmt.security.dto.EmailTypeDto;

@Service
public class EmailTypeService {

	@Autowired
	EmailTypeRepository emailTypeRepository;

	
	public EmailTypeDto createEmailType(EmailTypeDto emailTypeDto) {
		
		EmailType emailType = convertToEmailType(emailTypeDto);

		return convertToEmailTypeDto(emailTypeRepository.save(emailType));
	}

	
	public EmailTypeDto getEmailType(Long id) {
		return convertToEmailTypeDto(emailTypeRepository.findById(id).get());
	}

	
	public EmailType getEmailTypeByName(String emailTypeName) {
		return emailTypeRepository.findByEmailTypeName(emailTypeName);
	}

	
	public EmailTypeDto getEmailTypeByEmailTypeName(String emailTypeName) {
		return convertToEmailTypeDto(emailTypeRepository.findByEmailTypeName(emailTypeName));
	}

	
	public List<EmailTypeDto> getEmailTypesByStatus(String status) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public EmailTypeDto updateEmailType(EmailTypeDto emailTypeDto) {
		
		if (emailTypeRepository.existsById(emailTypeDto.getId())) {

			EmailType emailType = convertToEmailType(emailTypeDto);

			return convertToEmailTypeDto(emailTypeRepository.save(emailType));
		} else {

			return createEmailType(emailTypeDto);
		}
	}

	
	public boolean deleteEmailType(EmailTypeDto emailTypeDto) {
		
		if (emailTypeRepository.existsById(emailTypeDto.getId())) {
			
			emailTypeRepository.deleteById(emailTypeDto.getId());

			return emailTypeRepository.existsById(emailTypeDto.getId());
		}
		
		return false;
	}

	private EmailTypeDto convertToEmailTypeDto(EmailType emailType) {

		EmailTypeDto dto = new EmailTypeDto();

		BeanUtils.copyProperties(emailType, dto);

		return dto;
	}

	private EmailType convertToEmailType(EmailTypeDto dto) {

		EmailType emailType = new EmailType();

		BeanUtils.copyProperties(dto, emailType);

		return emailType;
	}

}
