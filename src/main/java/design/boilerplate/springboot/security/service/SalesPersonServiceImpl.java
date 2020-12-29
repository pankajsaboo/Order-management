package design.boilerplate.springboot.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import design.boilerplate.springboot.repository.SalesPoersonRepository;

@Service
public class SalesPersonServiceImpl implements SalesPersonService {

	@Autowired
	SalesPoersonRepository salesPersonRepository;
	
	@Override
	public String getSalesPoersonName(Long id) {
		
		return salesPersonRepository.findById(id).get().getName();
	}

}
