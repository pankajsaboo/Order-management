package design.boilerplate.springboot.security.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class UserTypeDto {
	
	@JsonProperty(value = "_id")
	Long id;
	
	@JsonProperty(value = "userTypeName", required = true)
	String userTypeName;
	
	@JsonProperty(value = "status")
	String status;

}
