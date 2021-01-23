package increpe.order.mgmt.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import increpe.order.mgmt.model.Roles;
import increpe.order.mgmt.model.User;
import increpe.order.mgmt.model.UserType;
import increpe.order.mgmt.repository.UserRepository;
import increpe.order.mgmt.security.dto.AuthenticatedUserDto;
import increpe.order.mgmt.security.mapper.UserMapper;
import increpe.order.mgmt.service.RolesService;
import increpe.order.mgmt.service.UserTypeService;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 *
 * 
 */
@Slf4j
@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserTypeService userTypeService;
	
	@Autowired
	RolesService rolesService;
	
	
	public User findByUsername(String username) {

		return userRepository.findByUsername(username);
	}

	
	public AuthenticatedUserDto findAuthenticatedUserByUsername(String username) {

		final User user = findByUsername(username);

		return convertUserToUserDto(user);
	}

	
	public User createUser(AuthenticatedUserDto userDto) {
		
		User user = convertUserDtoToUser(userDto);

		UserType userTypeId = userTypeService.getUserTypeByName(user.getUserTypeId().getUserTypeName());

		Roles userRoleId = rolesService.getRolesByTitle(user.getUserRole().getTitle());

		user.setUserTypeId(userTypeId);

		user.setUserRole(userRoleId);

		return userRepository.save(user);
	}

	
	public User convertUserDtoToUser(AuthenticatedUserDto userDto) {

		return UserMapper.INSTANCE.convertToUser(userDto);
	}

	
	public AuthenticatedUserDto convertUserToUserDto(User user) {
	
		return UserMapper.INSTANCE.convertToAuthenticatedUserDto(user);
	}	
	
}
