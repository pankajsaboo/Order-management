package increpe.order.mgmt.security.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import increpe.order.mgmt.model.Roles;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

/**
 * 
 *
 * 
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

	@JsonProperty(value = "userRole")
	RolesDto userRole;

}
