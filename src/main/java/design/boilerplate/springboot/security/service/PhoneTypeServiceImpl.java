package design.boilerplate.springboot.security.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import design.boilerplate.springboot.model.PhoneType;
import design.boilerplate.springboot.repository.PhoneTypeRepository;
import design.boilerplate.springboot.security.dto.PhoneTypeDto;

@Service
public class PhoneTypeServiceImpl implements PhoneTypeService {

	@Autowired
	PhoneTypeRepository phoneTypeRepository;

	@Override
	public PhoneTypeDto createPhoneType(PhoneTypeDto phoneTypeDto) {

		PhoneType phoneType = convertToPhoneType(phoneTypeDto);

		return convertToPhoneTypeDto(phoneTypeRepository.save(phoneType));
	}

	@Override
	public PhoneTypeDto getPhoneType(Long id) {
		return convertToPhoneTypeDto(phoneTypeRepository.findById(id).get());
	}

	@Override
	public PhoneType getPhoneTypeByName(String phoneTypeName) {
		return phoneTypeRepository.findByPhoneTypeName(phoneTypeName);
	}

	@Override
	public PhoneTypeDto getPhoneTypeByPhoneTypeName(String phoneTypeName) {
		return convertToPhoneTypeDto(phoneTypeRepository.findByPhoneTypeName(phoneTypeName));
	}

	@Override
	public List<PhoneTypeDto> getPhoneTypesByStatus(String status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PhoneTypeDto updatePhoneType(PhoneTypeDto phoneTypeDto) {

		if (phoneTypeRepository.existsById(phoneTypeDto.getId())) {

			PhoneType phoneType = convertToPhoneType(phoneTypeDto);

			return convertToPhoneTypeDto(phoneTypeRepository.save(phoneType));
		} else {

			return createPhoneType(phoneTypeDto);
		}
	}

	@Override
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
