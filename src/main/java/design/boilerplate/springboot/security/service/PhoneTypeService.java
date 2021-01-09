package design.boilerplate.springboot.security.service;

import java.util.List;

import design.boilerplate.springboot.model.PhoneType;
import design.boilerplate.springboot.security.dto.PhoneTypeDto;

public interface PhoneTypeService {
	
	PhoneTypeDto createPhoneType(PhoneTypeDto phoneTypeDto);

	PhoneTypeDto getPhoneType(Long id);
	
	PhoneType getPhoneTypeByName(String phoneTypeName);
	
	PhoneTypeDto getPhoneTypeByPhoneTypeName(String phoneTypeName);
	
	List<PhoneTypeDto> getPhoneTypesByStatus(String status);
	
	PhoneTypeDto updatePhoneType(PhoneTypeDto phoneTypeDto);
	
	boolean deletePhoneType(PhoneTypeDto phoneTypeDto);

}
