package design.boilerplate.springboot.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import design.boilerplate.springboot.repository.RolesRepository;

@Service
public class RolesServiceImpl implements RolesService {
	
	@Autowired
	RolesRepository rolesRepository;

	@Override
	public String getRoleTile(Long id) {
		
		return rolesRepository.findById(id).get().getTitle();
	}

}
