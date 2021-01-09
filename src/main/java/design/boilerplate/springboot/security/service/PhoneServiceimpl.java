package design.boilerplate.springboot.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import design.boilerplate.springboot.model.Company;
import design.boilerplate.springboot.model.Phone;
import design.boilerplate.springboot.model.PhoneType;
import design.boilerplate.springboot.model.User;
import design.boilerplate.springboot.repository.PhoneRepository;

@Service
public class PhoneServiceimpl implements PhoneService {

	@Autowired
	PhoneTypeService phoneTypeService;

	@Autowired
	PhoneRepository phoneRepository;

	@Override
	public void createPhone(Company companyId, User userId, String phoneNumber, Long phoneTypeId) {

//		PhoneType phoneType = phoneTypeService.getPhoneType(phoneTypeId);
//
//		Phone phone = new Phone();
//
//		phone.setCompanyId(companyId);
//		phone.setPhone(phoneNumber);
//		phone.setPhoneTypeId(phoneType);
//		phone.setUserId(userId);
//
//		phoneRepository.save(phone);

	}

}
