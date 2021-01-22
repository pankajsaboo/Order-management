package design.boilerplate.springboot.security.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class SalesPersonDto {

	@JsonProperty(value = "_id")
	Long id;
	
	@JsonProperty(value = "employeeId")
	String employeeId;
	
	@JsonProperty(value = "fullName")
	String name;

	@JsonProperty(value = "username")
	String username;

	@JsonProperty(value = "password")
	String password;
	
	@JsonProperty(value = "designation")
	String designation;
	
	@JsonProperty(value = "headquarter")
	AddressDto cityName;
	
	@JsonProperty(value = "workArea")
	String workAreaId;
	
	@JsonProperty(value = "phone")
	PhonesDto phone;
	
	@JsonProperty(value = "usertype")
	UserTypeDto userTypeId;
	
	@JsonProperty(value = "role")
	RolesDto userRole;
}
