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
	
	public AuthenticatedUserDto findAuthenticatedUser(Long userId) {
		return convertUserToUserDto(userRepository.findById(userId).get());
	}

	
	public AuthenticatedUserDto findAuthenticatedUserByUsername(String username) {

		final User user = findByUsername(username);

		return convertUserToUserDto(user);
	}

	
	public User createUser(AuthenticatedUserDto userDto) {
		
		User user = convertUserDtoToUser(userDto);

		UserType userTypeId = userTypeService.getUserType(user.getUserTypeId().getId());

		Roles userRoleId = rolesService.getRoles(user.getUserRole().getId());

		user.setUserTypeId(userTypeId);

		user.setUserRole(userRoleId);

		return userRepository.save(user);
	}
	
	public AuthenticatedUserDto updateUserData(AuthenticatedUserDto userDto) {
		
		User user = convertUserDtoToUser(userDto);
		
		return convertUserToUserDto(userRepository.save(user));
	}

	
	public User convertUserDtoToUser(AuthenticatedUserDto userDto) {

		return UserMapper.INSTANCE.convertToUser(userDto);
	}

	
	public AuthenticatedUserDto convertUserToUserDto(User user) {
	
		return UserMapper.INSTANCE.convertToAuthenticatedUserDto(user);
	}	
	
}
