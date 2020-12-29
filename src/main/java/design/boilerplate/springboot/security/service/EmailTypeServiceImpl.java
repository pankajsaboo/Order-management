package design.boilerplate.springboot.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import design.boilerplate.springboot.repository.EmailTypeRepository;

@Service
public class EmailTypeServiceImpl implements EmailTypeServie {
	
	@Autowired
	EmailTypeRepository emailTypeRepository;

	@Override
	public String getEmailTypeName(Long id) {
		
		return emailTypeRepository.findById(id).get().getEmailTypeName();
	}

}
