package design.boilerplate.springboot.security.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import design.boilerplate.springboot.model.Address;
import design.boilerplate.springboot.model.AddressType;
import design.boilerplate.springboot.model.City;
import design.boilerplate.springboot.repository.AddressRepository;
import design.boilerplate.springboot.security.dto.AddressDto;

@Service
public class AddressServiceImpl implements AddressService {
	
	@Autowired
	AddressRepository addressRepository;
	
	@Autowired
	CityService cityService;
	
	@Autowired
	CompanyService companyService;
	
	@Autowired
	AddressTypeService addressTypeService;
	

	@Override
	public void createAddress(AddressDto addressDto) {
		
//		Address address = new Address();
//		
//		AddressType addressType =  addressTypeService.getAddressTypeByName(addressDto.getAddressType().toUpperCase());
//		
//		City city = cityService.getCityByName(addressDto.getCity());
//		
//		BeanUtils.copyProperties(addressDto, address);
//		
//		address.setAddressTypeId(addressType);
//		
//		address.setCityId(city);
//		
//		addressRepository.save(address);
		
		return;
		
	}


//	@Override
//	public void addNewAddress(String addressLine1, String addressLine2, String addressLine3, Company company,
//			String cityCode, String addresstypeName) {
//		
//		AddressDto addressDto = new AddressDto(addressLine1, addressLine2, addressLine3, company, cityCode, addressLine3);
//		
//		createAddress(addressDto);
//		
//		return;
//		
//	}

}
