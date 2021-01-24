package increpe.order.mgmt.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import increpe.order.mgmt.model.Permission;
import increpe.order.mgmt.repository.PermissionRepository;
import increpe.order.mgmt.security.dto.PermissionDto;

@Service
public class PermissionService {

	@Autowired
	PermissionRepository permissionRepository;

	
	public PermissionDto createPermission(PermissionDto permissionDto) {

		Permission permission = convertToPermission(permissionDto);

		return convertToPermissionDto(permissionRepository.save(permission));
	}

	
	public PermissionDto getPermission(Long id) {

		return convertToPermissionDto(permissionRepository.findById(id).get());
	}

	
	public Permission getPermissionByTitle(String permissionTitle) {

		return permissionRepository.findByTitle(permissionTitle);
	}

	
	public PermissionDto getPermissionByPermissionTitle(String permissionTitle) {

		return convertToPermissionDto(permissionRepository.findByTitle(permissionTitle));
	}

	
	public List<PermissionDto> getPermissionsByStatus(String status) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public PermissionDto updatePermission(PermissionDto permissionDto) {

		if (permissionRepository.existsById(permissionDto.getId())) {

			Permission permission = convertToPermission(permissionDto);

			return convertToPermissionDto(permissionRepository.save(permission));

		}

		return createPermission(permissionDto);

	}

	
	public boolean deletePermission(PermissionDto permissionDto) {

		if (permissionRepository.existsById(permissionDto.getId())) {

			permissionRepository.deleteById(permissionDto.getId());

			return permissionRepository.existsById(permissionDto.getId());
		}

		return false;

	}

	private PermissionDto convertToPermissionDto(Permission permission) {

		PermissionDto dto = new PermissionDto();

		BeanUtils.copyProperties(permission, dto);

		return dto;
	}

	private Permission convertToPermission(PermissionDto dto) {

		Permission permission = new Permission();

		BeanUtils.copyProperties(dto, permission);

		return permission;
	}

}
