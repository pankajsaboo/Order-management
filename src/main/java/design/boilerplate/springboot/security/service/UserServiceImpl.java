package design.boilerplate.springboot.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import design.boilerplate.springboot.model.Roles;
import design.boilerplate.springboot.model.User;
import design.boilerplate.springboot.model.UserType;
import design.boilerplate.springboot.repository.UserRepository;
import design.boilerplate.springboot.security.dto.AuthenticatedUserDto;
import design.boilerplate.springboot.security.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;

/**
 * Created on Ağustos, 2020
 *
 * @author Faruk
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserTypeService userTypeService;
	
	@Autowired
	RolesService rolesService;
	
	@Override
	public User findByUsername(String username) {

		return userRepository.findByUsername(username);
	}

	@Override
	public AuthenticatedUserDto findAuthenticatedUserByUsername(String username) {

		final User user = findByUsername(username);

		return convertUserToUserDto(user);
	}

	@Override
	public User createUser(AuthenticatedUserDto userDto) {
		
		User user = convertUserDtoToUser(userDto);

		UserType userTypeId = userTypeService.getUserTypeByName(user.getUserTypeId().getUserTypeName());

		Roles userRoleId = rolesService.getRolesByTitle(user.getUserRole().getTitle());

		user.setUserTypeId(userTypeId);

		user.setUserRole(userRoleId);

		return userRepository.save(user);
	}

	@Override
	public User convertUserDtoToUser(AuthenticatedUserDto userDto) {

		return UserMapper.INSTANCE.convertToUser(userDto);
	}

	@Override
	public AuthenticatedUserDto convertUserToUserDto(User user) {
	
		return UserMapper.INSTANCE.convertToAuthenticatedUserDto(user);
	}	
	
}
