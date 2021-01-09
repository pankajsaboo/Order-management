package design.boilerplate.springboot.security.service;

import java.util.List;

import design.boilerplate.springboot.model.Permission;
import design.boilerplate.springboot.security.dto.PermissionDto;

public interface PermissionService {
	
	PermissionDto createPermission(PermissionDto permissionDto);

	PermissionDto getPermission(Long id);
	
	Permission getPermissionByTitle(String permissionTitle);
	
	PermissionDto getPermissionByPermissionTitle(String permissionTitle);
	
	List<PermissionDto> getPermissionsByStatus(String status);
	
	PermissionDto updatePermission(PermissionDto permissionDto);
	
	boolean deletePermission(PermissionDto permissionDto);

}
