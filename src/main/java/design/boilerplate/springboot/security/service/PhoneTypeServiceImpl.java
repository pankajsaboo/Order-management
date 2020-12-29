package design.boilerplate.springboot.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import design.boilerplate.springboot.repository.PhoneTypeRepository;

@Service
public class PhoneTypeServiceImpl implements PhoneTypeService {
	
	@Autowired
	PhoneTypeRepository phoneTypeRepository;

	@Override
	public String getPhoneTypeName(Long id) {
		
		return phoneTypeRepository.findById(id).get().getPhoneTypeName();
	}

}
