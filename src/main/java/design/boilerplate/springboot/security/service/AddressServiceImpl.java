package design.boilerplate.springboot.security.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import design.boilerplate.springboot.model.Address;
import design.boilerplate.springboot.model.AddressType;
import design.boilerplate.springboot.model.City;
import design.boilerplate.springboot.repository.AddressRepository;
import design.boilerplate.springboot.security.dto.AddressDto;
import design.boilerplate.springboot.security.dto.CityDto;
import design.boilerplate.springboot.security.mapper.AddressMapper;

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
	public Address createAddress(AddressDto addressDto) {

		Address address = convertAddressDtoToAddress(addressDto);

		AddressType addressTypeId = addressTypeService
				.getAddressTypeByName(address.getAddressTypeId().getAddressTypeName());

		City cityId = cityService.getCityByName(address.getCityId().getCityName());

		address.setAddressTypeId(addressTypeId);

		address.setCityId(cityId);

		return addressRepository.save(address);
	}

	@Override
	public Address createAddress(Address address) {
		
		AddressType addressTypeId = addressTypeService
				.getAddressTypeByName(address.getAddressTypeId().getAddressTypeName());

		City cityId = cityService.getCityByName(address.getCityId().getCityName());

		address.setAddressTypeId(addressTypeId);

		address.setCityId(cityId);

		return addressRepository.save(address);
	}

	@Override
	public AddressDto convertAddressToAddressDto(Address address) {
		return AddressMapper.INSTANCE.convertToAddressDto(address);
	}

	@Override
	public Address convertAddressDtoToAddress(AddressDto addressDto) {
		return AddressMapper.INSTANCE.convertToAddress(addressDto);
	}

}
