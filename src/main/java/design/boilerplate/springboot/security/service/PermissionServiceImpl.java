package design.boilerplate.springboot.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import design.boilerplate.springboot.repository.PermissionRepository;

@Service
public class PermissionServiceImpl implements PermissionService {

	
	@Autowired
	PermissionRepository permissionRepository;
	
	@Override
	public String getPermissionTitle(Long id) {
		
		return permissionRepository.findById(id).get().getTitle();
	}

}
