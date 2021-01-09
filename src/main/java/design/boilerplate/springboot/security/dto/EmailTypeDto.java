package design.boilerplate.springboot.security.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class EmailTypeDto {
	
	@JsonProperty(value = "_id")
	Long id;
	
	@JsonProperty(value = "emailTypeName", required = true)
	String emailTypeName;
	
	@JsonProperty(value = "status")
	String status;

}
