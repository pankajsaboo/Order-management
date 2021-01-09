package design.boilerplate.springboot.security.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import design.boilerplate.springboot.model.AddressType;
import design.boilerplate.springboot.repository.AddressTypeRepository;
import design.boilerplate.springboot.security.dto.AddressTypeDto;
import design.boilerplate.springboot.utils.ProjectConstants;

@Service
public class AddressTypeServiceImpl implements AddressTypeService {

	@Autowired
	AddressTypeRepository addressTypeRepository;

	@Override
	public AddressTypeDto createAddressType(AddressTypeDto addressTypeDto) {

		AddressType addressType = convertToAddressType(addressTypeDto);

		return convertToAddressTypeDto(addressTypeRepository.save(addressType));
	}

	@Override
	public AddressTypeDto getAddressType(Long id) {
		
		return convertToAddressTypeDto(addressTypeRepository.findById(id).get());
	}

	@Override
	public AddressType getAddressTypeByName(String addressTypeName) {
		
		return addressTypeRepository.findByAddressTypeName(addressTypeName);
	}

	@Override
	public AddressTypeDto getAddressTypeByAddressTypeName(String addressTypeName) {
		
		return convertToAddressTypeDto(addressTypeRepository.findByAddressTypeName(addressTypeName));
	}

	@Override
	public List<AddressTypeDto> getAddressTypesByStatus(String status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AddressTypeDto updateAddressType(AddressTypeDto addressTypeDto) {
		
		if(addressTypeRepository.existsById(addressTypeDto.getId())) {
			
			AddressType addressType = convertToAddressType(addressTypeDto);
			
			return convertToAddressTypeDto(addressTypeRepository.save(addressType));
			
		}
			
		return createAddressType(addressTypeDto);
		
	}

	@Override
	public boolean deleteAddressType(AddressTypeDto addressTypeDto) {
		
		if(addressTypeRepository.existsById(addressTypeDto.getId())) {
			
			addressTypeRepository.deleteById(addressTypeDto.getId());
			
			return addressTypeRepository.existsById(addressTypeDto.getId());
		}
		
		return false;
		
	}

	private AddressTypeDto convertToAddressTypeDto(AddressType addressType) {

		AddressTypeDto dto = new AddressTypeDto();

		BeanUtils.copyProperties(addressType, dto);

		return dto;
	}

	private AddressType convertToAddressType(AddressTypeDto dto) {

		AddressType addressType = new AddressType();

		BeanUtils.copyProperties(dto, addressType);

		return addressType;
	}

}
