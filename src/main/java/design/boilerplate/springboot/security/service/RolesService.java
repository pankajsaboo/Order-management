package design.boilerplate.springboot.security.service;

import java.util.List;

import design.boilerplate.springboot.model.Roles;
import design.boilerplate.springboot.security.dto.RolesDto;

public interface RolesService {
	
	RolesDto createRoles(RolesDto rolesDto);

	RolesDto getRoles(Long id);
	
	Roles getRolesByTitle(String rolesTitle);
	
	RolesDto getRolesByRolesTitle(String rolesTitle);
	
	List<RolesDto> getRolessByStatus(String status);
	
	RolesDto updateRoles(RolesDto rolesDto);
	
	boolean deleteRoles(RolesDto rolesDto);
}
