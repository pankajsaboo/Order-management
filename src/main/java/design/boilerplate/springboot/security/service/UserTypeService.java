package design.boilerplate.springboot.security.service;

import java.util.List;

import design.boilerplate.springboot.model.UserType;
import design.boilerplate.springboot.security.dto.UserTypeDto;

public interface UserTypeService {

	UserTypeDto createUserType(UserTypeDto userTypeDto);

	UserTypeDto getUserType(Long id);
	
	UserType getUserTypeByName(String userTypeName);
	
	UserTypeDto getUserTypeByUserTypeName(String userTypeName);
	
	List<UserTypeDto> getUserTypesByStatus(String status);
	
	UserTypeDto updateUserType(UserTypeDto userTypeDto);
	
	boolean deleteUserType(UserTypeDto userTypeDto);
}
