package increpe.order.mgmt.service;

import java.util.Objects;

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

	
	public AddressDto createAddress(AddressDto addressDto) {

		Address address = convertAddressDtoToAddress(addressDto);

		AddressType addressTypeId = addressTypeService
				.getAddressTypeByName(address.getAddressTypeId().getAddressTypeName());

		City cityId = cityService.getCityByName(address.getCityId().getCityName());

		address.setAddressTypeId(addressTypeId);

		address.setCityId(cityId);

		return convertAddressToAddressDto(addressRepository.save(address));
	}

	
	public Address createAddress(Address address) {
		
		AddressType addressTypeId = addressTypeService
				.getAddressTypeByName(address.getAddressTypeId().getAddressTypeName());

		City cityId = cityService.getCityByName(address.getCityId().getCityCode());

		address.setAddressTypeId(addressTypeId);

		address.setCityId(cityId);

		return addressRepository.save(address);
	}
	
	public AddressDto updateAddress(AddressDto addressDto) {
		
		if(Objects.isNull(addressDto.getId())) {
			return createAddress(addressDto);
		}
		
		Address address = convertAddressDtoToAddress(addressDto);
		
		return convertAddressToAddressDto(addressRepository.save(address));
	}
	
	public AddressDto getAddressByUserId(Long id) {
		
		return convertAddressToAddressDto(addressRepository.findByUserId_id(id));
	}

	
	public AddressDto convertAddressToAddressDto(Address address) {
		return AddressMapper.INSTANCE.convertToAddressDto(address);
	}

	
	public Address convertAddressDtoToAddress(AddressDto addressDto) {
		return AddressMapper.INSTANCE.convertToAddress(addressDto);
	}

}
