package increpe.order.mgmt.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import increpe.order.mgmt.model.Roles;
import increpe.order.mgmt.repository.RolesRepository;
import increpe.order.mgmt.security.dto.RolesDto;

@Service
public class RolesService {

	@Autowired
	RolesRepository rolesRepository;

	
	public RolesDto createRoles(RolesDto rolesDto) {

		Roles roles = convertToRoles(rolesDto);

		return convertToRolesDto(rolesRepository.save(roles));
	}

	
	public Roles getRoles(Long id) {

		return rolesRepository.findById(id).get();
	}

	
	public Roles getRolesByTitle(String rolesTitle) {

		return rolesRepository.findByTitle(rolesTitle);
	}

	
	public RolesDto getRolesByRolesTitle(String rolesTitle) {

		return convertToRolesDto(rolesRepository.findByTitle(rolesTitle));
	}

	
	public List<RolesDto> getRolessByStatus(String status) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public RolesDto updateRoles(RolesDto rolesDto) {

		if (rolesRepository.existsById(rolesDto.getId())) {

			Roles roles = convertToRoles(rolesDto);

			return convertToRolesDto(rolesRepository.save(roles));

		}

		return createRoles(rolesDto);

	}

	
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
