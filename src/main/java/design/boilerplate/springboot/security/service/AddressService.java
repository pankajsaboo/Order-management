package design.boilerplate.springboot.security.service;

import design.boilerplate.springboot.model.Company;
import design.boilerplate.springboot.security.dto.AddressDto;

public interface AddressService {
	
	void createAddress(AddressDto addressDto);
	
//	void addNewAddress(String addressLine1, String addressLine2, String addressLine3, Company company, String cityCode, String addresstypeName);

}
