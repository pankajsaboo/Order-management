package design.boilerplate.springboot.security.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import design.boilerplate.springboot.model.Roles;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

/**
 * Created on Ağustos, 2020
 *
 * @author Faruk
 */
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class AuthenticatedUserDto {

	@JsonProperty(value = "_id")
	Long id;
	
	@JsonProperty(value = "fullName")
	String name;

	@JsonProperty(value = "username")
	String username;

	@JsonProperty(value = "password")
	String password;
	
	@JsonProperty(value = "userTypeId")
	UserTypeDto userTypeId;
	
	@JsonProperty(value = "employeeId")
	String employeeId;
	
	@JsonProperty(value = "designation")
	String designation;

	@JsonProperty(value = "userRoleId")
	RolesDto userRoleId;

}
