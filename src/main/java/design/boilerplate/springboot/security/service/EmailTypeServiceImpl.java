package design.boilerplate.springboot.security.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import design.boilerplate.springboot.model.EmailType;
import design.boilerplate.springboot.repository.EmailTypeRepository;
import design.boilerplate.springboot.security.dto.EmailTypeDto;

@Service
public class EmailTypeServiceImpl implements EmailTypeService {

	@Autowired
	EmailTypeRepository emailTypeRepository;

	@Override
	public EmailTypeDto createEmailType(EmailTypeDto emailTypeDto) {
		
		EmailType emailType = convertToEmailType(emailTypeDto);

		return convertToEmailTypeDto(emailTypeRepository.save(emailType));
	}

	@Override
	public EmailTypeDto getEmailType(Long id) {
		return convertToEmailTypeDto(emailTypeRepository.findById(id).get());
	}

	@Override
	public EmailType getEmailTypeByName(String emailTypeName) {
		return emailTypeRepository.findByEmailTypeName(emailTypeName);
	}

	@Override
	public EmailTypeDto getEmailTypeByEmailTypeName(String emailTypeName) {
		return convertToEmailTypeDto(emailTypeRepository.findByEmailTypeName(emailTypeName));
	}

	@Override
	public List<EmailTypeDto> getEmailTypesByStatus(String status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmailTypeDto updateEmailType(EmailTypeDto emailTypeDto) {
		
		if (emailTypeRepository.existsById(emailTypeDto.getId())) {

			EmailType emailType = convertToEmailType(emailTypeDto);

			return convertToEmailTypeDto(emailTypeRepository.save(emailType));
		} else {

			return createEmailType(emailTypeDto);
		}
	}

	@Override
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
