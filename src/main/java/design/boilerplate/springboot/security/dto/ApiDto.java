package design.boilerplate.springboot.security.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class ApiDto {

	@JsonProperty(value = "api_name")
	String apiName;
	
	@JsonProperty(value = "uri")
	String uri;
	
	@JsonProperty(value = "type")
	String type;
}
