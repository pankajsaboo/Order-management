package increpe.order.mgmt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import increpe.order.mgmt.model.Address;
import increpe.order.mgmt.model.AddressType;
import increpe.order.mgmt.model.City;
import increpe.order.mgmt.repository.AddressRepository;
import increpe.order.mgmt.security.dto.AddressDto;
import increpe.order.mgmt.security.mapper.AddressMapper;

@Service
public class AddressService{

	@Autowired
	AddressRepository addressRepository;

	@Autowired
	CityService cityService;

	@Autowired
	CompanyService companyService;

	@Autowired
	AddressTypeService addressTypeService;

	
	public Address createAddress(AddressDto addressDto) {

		Address address = convertAddressDtoToAddress(addressDto);

		AddressType addressTypeId = addressTypeService
				.getAddressTypeByName(address.getAddressTypeId().getAddressTypeName());

		City cityId = cityService.getCityByName(address.getCityId().getCityName());

		address.setAddressTypeId(addressTypeId);

		address.setCityId(cityId);

		return addressRepository.save(address);
	}

	
	public Address createAddress(Address address) {
		
		AddressType addressTypeId = addressTypeService
				.getAddressTypeByName(address.getAddressTypeId().getAddressTypeName());

		City cityId = cityService.getCityByName(address.getCityId().getCityName());

		address.setAddressTypeId(addressTypeId);

		address.setCityId(cityId);

		return addressRepository.save(address);
	}

	
	public AddressDto convertAddressToAddressDto(Address address) {
		return AddressMapper.INSTANCE.convertToAddressDto(address);
	}

	
	public Address convertAddressDtoToAddress(AddressDto addressDto) {
		return AddressMapper.INSTANCE.convertToAddress(addressDto);
	}

}
