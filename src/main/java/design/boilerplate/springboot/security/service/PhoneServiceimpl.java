package design.boilerplate.springboot.security.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import design.boilerplate.springboot.model.Company;
import design.boilerplate.springboot.model.PhoneType;
import design.boilerplate.springboot.model.Phone;
import design.boilerplate.springboot.model.Phone;
import design.boilerplate.springboot.model.PhoneType;
import design.boilerplate.springboot.model.User;
import design.boilerplate.springboot.repository.PhoneRepository;
import design.boilerplate.springboot.repository.PhoneTypeRepository;
import design.boilerplate.springboot.security.dto.PhoneTypeDto;
import design.boilerplate.springboot.security.dto.PhonesDto;

@Service
public class PhoneServiceimpl implements PhoneService {

	@Autowired
	PhoneTypeService phoneTypeService;

	@Autowired
	PhoneRepository phoneRepository;

	@Override
	public Phone createPhone(Phone phone) {
		
		PhoneType type = phoneTypeService.getPhoneTypeByName(phone.getPhoneTypeId().getPhoneTypeName());
		phone.setPhoneTypeId(type);
		
		return phoneRepository.save(phone);
	}
	
	@Override
	public PhonesDto convertToPhoneDto(Phone phone) {

		PhonesDto dto = new PhonesDto();
		
		PhoneTypeDto typeDto = new PhoneTypeDto();
		
		BeanUtils.copyProperties(phone.getPhoneTypeId(), typeDto);

		dto.setPhoneTypeId(typeDto);

		BeanUtils.copyProperties(phone, dto);

		return dto;
	}

	@Override
	public Phone convertToPhone(PhonesDto dto) {

		Phone phone = new Phone();
		
		PhoneType type = new PhoneType();
		
		BeanUtils.copyProperties(dto.getPhoneTypeId(), type);
		
		phone.setPhoneTypeId(type);

		BeanUtils.copyProperties(dto, phone);

		return phone;
	}
	
	

}
