package design.boilerplate.springboot.security.service;

import design.boilerplate.springboot.model.Company;
import design.boilerplate.springboot.model.User;
import design.boilerplate.springboot.security.dto.AuthenticatedUserDto;
import design.boilerplate.springboot.security.dto.CompanyTypeRelationDto;
import design.boilerplate.springboot.security.dto.RegistrationRequest;
import design.boilerplate.springboot.security.dto.RegistrationResponse;

/**
 * Created on Ağustos, 2020
 *
 * @author Faruk
 */
public interface UserService {
	
	User createUser(AuthenticatedUserDto userDto);

	User findByUsername(String username);

	AuthenticatedUserDto findAuthenticatedUserByUsername(String username);
	
	User convertUserDtoToUser(AuthenticatedUserDto userDto);
	
	AuthenticatedUserDto convertUserToUserDto(User user);

}
