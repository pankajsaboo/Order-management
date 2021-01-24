package design.boilerplate.springboot.security.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import design.boilerplate.springboot.model.Country;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class StateDto {
	
	@JsonProperty(value = "_id")
	Long id;
	
	@JsonProperty(value = "countryId")
	CountryDto countryId;
	
	@JsonProperty(value = "stateName")
	String stateName;
	
	@JsonProperty(value = "stateCode")
	String stateCode;
	
	@JsonProperty(value = "status")
	String status;

}
