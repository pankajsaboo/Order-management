package design.boilerplate.springboot.security.service;

import java.util.List;

import design.boilerplate.springboot.model.AddressType;
import design.boilerplate.springboot.security.dto.AddressTypeDto;

public interface AddressTypeService {
	
	AddressTypeDto createAddressType(AddressTypeDto addressTypeDto);

	AddressTypeDto getAddressType(Long id);
	
	AddressType getAddressTypeByName(String addressTypeName);
	
	AddressTypeDto getAddressTypeByAddressTypeName(String addressTypeName);
	
	List<AddressTypeDto> getAddressTypesByStatus(String status);
	
	AddressTypeDto updateAddressType(AddressTypeDto addressTypeDto);
	
	boolean deleteAddressType(AddressTypeDto addressTypeDto);
	 
}
