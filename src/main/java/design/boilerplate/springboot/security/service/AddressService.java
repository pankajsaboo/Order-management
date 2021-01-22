package design.boilerplate.springboot.security.service;

import design.boilerplate.springboot.model.Address;
import design.boilerplate.springboot.model.Company;
import design.boilerplate.springboot.security.dto.AddressDto;

public interface AddressService {
	
	Address createAddress(AddressDto addressDto);
	
	Address createAddress(Address address);

	AddressDto convertAddressToAddressDto(Address address);

	Address convertAddressDtoToAddress(AddressDto addressDto);
	
}
