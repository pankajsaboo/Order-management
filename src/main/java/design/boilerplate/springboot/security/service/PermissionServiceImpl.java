package design.boilerplate.springboot.security.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import design.boilerplate.springboot.model.Permission;
import design.boilerplate.springboot.repository.PermissionRepository;
import design.boilerplate.springboot.security.dto.PermissionDto;

@Service
public class PermissionServiceImpl implements PermissionService {

	@Autowired
	PermissionRepository permissionRepository;

	@Override
	public PermissionDto createPermission(PermissionDto permissionDto) {

		Permission permission = convertToPermission(permissionDto);

		return convertToPermissionDto(permissionRepository.save(permission));
	}

	@Override
	public PermissionDto getPermission(Long id) {

		return convertToPermissionDto(permissionRepository.findById(id).get());
	}

	@Override
	public Permission getPermissionByTitle(String permissionTitle) {

		return permissionRepository.findByTitle(permissionTitle);
	}

	@Override
	public PermissionDto getPermissionByPermissionTitle(String permissionTitle) {

		return convertToPermissionDto(permissionRepository.findByTitle(permissionTitle));
	}

	@Override
	public List<PermissionDto> getPermissionsByStatus(String status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PermissionDto updatePermission(PermissionDto permissionDto) {

		if (permissionRepository.existsById(permissionDto.getId())) {

			Permission permission = convertToPermission(permissionDto);

			return convertToPermissionDto(permissionRepository.save(permission));

		}

		return createPermission(permissionDto);

	}

	@Override
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
