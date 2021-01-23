package increpe.order.mgmt.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import increpe.order.mgmt.model.PhoneType;
import increpe.order.mgmt.repository.PhoneTypeRepository;
import increpe.order.mgmt.security.dto.PhoneTypeDto;

@Service
public class PhoneTypeService {

	@Autowired
	PhoneTypeRepository phoneTypeRepository;

	
	public PhoneTypeDto createPhoneType(PhoneTypeDto phoneTypeDto) {

		PhoneType phoneType = convertToPhoneType(phoneTypeDto);

		return convertToPhoneTypeDto(phoneTypeRepository.save(phoneType));
	}

	
	public PhoneTypeDto getPhoneType(Long id) {
		return convertToPhoneTypeDto(phoneTypeRepository.findById(id).get());
	}

	
	public PhoneType getPhoneTypeByName(String phoneTypeName) {
		return phoneTypeRepository.findByPhoneTypeName(phoneTypeName);
	}

	
	public PhoneTypeDto getPhoneTypeByPhoneTypeName(String phoneTypeName) {
		return convertToPhoneTypeDto(phoneTypeRepository.findByPhoneTypeName(phoneTypeName));
	}

	
	public List<PhoneTypeDto> getPhoneTypesByStatus(String status) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public PhoneTypeDto updatePhoneType(PhoneTypeDto phoneTypeDto) {

		if (phoneTypeRepository.existsById(phoneTypeDto.getId())) {

			PhoneType phoneType = convertToPhoneType(phoneTypeDto);

			return convertToPhoneTypeDto(phoneTypeRepository.save(phoneType));
		} else {

			return createPhoneType(phoneTypeDto);
		}
	}

	
	public boolean deletePhoneType(PhoneTypeDto phoneTypeDto) {
		
		if (phoneTypeRepository.existsById(phoneTypeDto.getId())) {
			
			phoneTypeRepository.deleteById(phoneTypeDto.getId());

			return phoneTypeRepository.existsById(phoneTypeDto.getId());
		}
		
		return false;

	}

	private PhoneTypeDto convertToPhoneTypeDto(PhoneType phoneType) {

		PhoneTypeDto dto = new PhoneTypeDto();

		BeanUtils.copyProperties(phoneType, dto);

		return dto;
	}

	private PhoneType convertToPhoneType(PhoneTypeDto dto) {

		PhoneType phoneType = new PhoneType();

		BeanUtils.copyProperties(dto, phoneType);

		return phoneType;
	}

}
