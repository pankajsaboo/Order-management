package increpe.order.mgmt.service;

import java.util.Objects;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import increpe.order.mgmt.model.Phone;
import increpe.order.mgmt.model.PhoneType;
import increpe.order.mgmt.repository.PhoneRepository;
import increpe.order.mgmt.security.dto.PhoneTypeDto;
import increpe.order.mgmt.security.dto.PhonesDto;
import increpe.order.mgmt.security.mapper.CompanyMapper;

@Service
public class PhoneService {

	@Autowired
	PhoneTypeService phoneTypeService;

	@Autowired
	PhoneRepository phoneRepository;

	
	public PhonesDto createPhone(PhonesDto pDto) {
		
		Phone phone = convertToPhone(pDto);
		
		PhoneType type = phoneTypeService.getPhoneTypeByName(phone.getPhoneTypeId().getPhoneTypeName());
		phone.setPhoneTypeId(type);
		
		return convertToPhoneDto(phoneRepository.save(phone));
	}
	
	public PhonesDto getPhoneByUserId(Long id) {
		
		return convertToPhoneDto(phoneRepository.findByUserId_id(id));
	}
	
	public PhonesDto updatePhone(PhonesDto dto) {
		
		if(Objects.isNull(dto.getId())) {			
			return createPhone(dto);
		}
		
		return convertToPhoneDto(phoneRepository.save(convertToPhone(dto)));
	}
	
	public PhonesDto convertToPhoneDto(Phone phone) {
		
		if(Objects.isNull(phone))
			return null;

		return CompanyMapper.INSTANCE.convertToPhonesDto(phone);
	}

	
	public Phone convertToPhone(PhonesDto dto) {
		
		if(Objects.isNull(dto))
			return null;

		return CompanyMapper.INSTANCE.convertToPhone(dto);
	}
	
	

}
