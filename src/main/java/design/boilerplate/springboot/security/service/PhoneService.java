package design.boilerplate.springboot.security.service;

import design.boilerplate.springboot.model.Phone;
import design.boilerplate.springboot.security.dto.PhonesDto;

public interface PhoneService {
	
	//void createPhone(Company companyId, User userId, String phoneNumber, Long phoneTypeId);
	
	Phone createPhone(Phone phone);

	PhonesDto convertToPhoneDto(Phone phone);

	Phone convertToPhone(PhonesDto dto);

}
