package design.boilerplate.springboot.security.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import design.boilerplate.springboot.model.Roles;
import design.boilerplate.springboot.repository.RolesRepository;
import design.boilerplate.springboot.security.dto.RolesDto;

@Service
public class RolesServiceImpl implements RolesService {

	@Autowired
	RolesRepository rolesRepository;

	@Override
	public RolesDto createRoles(RolesDto rolesDto) {

		Roles roles = convertToRoles(rolesDto);

		return convertToRolesDto(rolesRepository.save(roles));
	}

	@Override
	public RolesDto getRoles(Long id) {

		return convertToRolesDto(rolesRepository.findById(id).get());
	}

	@Override
	public Roles getRolesByTitle(String rolesTitle) {

		return rolesRepository.findByTitle(rolesTitle);
	}

	@Override
	public RolesDto getRolesByRolesTitle(String rolesTitle) {

		return convertToRolesDto(rolesRepository.findByTitle(rolesTitle));
	}

	@Override
	public List<RolesDto> getRolessByStatus(String status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RolesDto updateRoles(RolesDto rolesDto) {

		if (rolesRepository.existsById(rolesDto.getId())) {

			Roles roles = convertToRoles(rolesDto);

			return convertToRolesDto(rolesRepository.save(roles));

		}

		return createRoles(rolesDto);

	}

	@Override
	public boolean deleteRoles(RolesDto rolesDto) {

		if (rolesRepository.existsById(rolesDto.getId())) {

			rolesRepository.deleteById(rolesDto.getId());

			return rolesRepository.existsById(rolesDto.getId());
		}

		return false;

	}

	private RolesDto convertToRolesDto(Roles roles) {

		RolesDto dto = new RolesDto();

		BeanUtils.copyProperties(roles, dto);

		return dto;
	}

	private Roles convertToRoles(RolesDto dto) {

		Roles roles = new Roles();

		BeanUtils.copyProperties(dto, roles);

		return roles;
	}

}
