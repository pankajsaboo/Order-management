package increpe.order.mgmt.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import increpe.order.mgmt.model.Phone;
import increpe.order.mgmt.model.PhoneType;
import increpe.order.mgmt.repository.PhoneRepository;
import increpe.order.mgmt.security.dto.PhoneTypeDto;
import increpe.order.mgmt.security.dto.PhonesDto;

@Service
public class PhoneService {

	@Autowired
	PhoneTypeService phoneTypeService;

	@Autowired
	PhoneRepository phoneRepository;

	
	public Phone createPhone(Phone phone) {
		
		PhoneType type = phoneTypeService.getPhoneTypeByName(phone.getPhoneTypeId().getPhoneTypeName());
		phone.setPhoneTypeId(type);
		
		return phoneRepository.save(phone);
	}
	
	
	public PhonesDto convertToPhoneDto(Phone phone) {

		PhonesDto dto = new PhonesDto();
		
		PhoneTypeDto typeDto = new PhoneTypeDto();
		
		BeanUtils.copyProperties(phone.getPhoneTypeId(), typeDto);

		dto.setPhoneTypeId(typeDto);

		BeanUtils.copyProperties(phone, dto);

		return dto;
	}

	
	public Phone convertToPhone(PhonesDto dto) {

		Phone phone = new Phone();
		
		PhoneType type = new PhoneType();
		
		BeanUtils.copyProperties(dto.getPhoneTypeId(), type);
		
		phone.setPhoneTypeId(type);

		BeanUtils.copyProperties(dto, phone);

		return phone;
	}
	
	

}
