package increpe.order.mgmt.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import increpe.order.mgmt.model.AddressType;
import increpe.order.mgmt.repository.AddressTypeRepository;
import increpe.order.mgmt.security.dto.AddressTypeDto;

@Service
public class AddressTypeService {

	@Autowired
	AddressTypeRepository addressTypeRepository;

	
	public AddressTypeDto createAddressType(AddressTypeDto addressTypeDto) {

		AddressType addressType = convertToAddressType(addressTypeDto);

		return convertToAddressTypeDto(addressTypeRepository.save(addressType));
	}

	
	public AddressTypeDto getAddressType(Long id) {
		
		return convertToAddressTypeDto(addressTypeRepository.findById(id).get());
	}

	
	public AddressType getAddressTypeByName(String addressTypeName) {
		
		return addressTypeRepository.findByAddressTypeName(addressTypeName);
	}

	
	public AddressTypeDto getAddressTypeByAddressTypeName(String addressTypeName) {
		
		return convertToAddressTypeDto(addressTypeRepository.findByAddressTypeName(addressTypeName));
	}

	
	public List<AddressTypeDto> getAddressTypesByStatus(String status) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public AddressTypeDto updateAddressType(AddressTypeDto addressTypeDto) {
		
		if(addressTypeRepository.existsById(addressTypeDto.getId())) {
			
			AddressType addressType = convertToAddressType(addressTypeDto);
			
			return convertToAddressTypeDto(addressTypeRepository.save(addressType));
			
		}
			
		return createAddressType(addressTypeDto);
		
	}

	
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
