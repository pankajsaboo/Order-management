package increpe.order.mgmt.security.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class CountryDto {
	
	@JsonProperty(value = "_id")
	Long id;
	
	@JsonProperty(value = "countryName")
	String countryName;
	
	@JsonProperty(value = "countryCode")
	String countryCode;
	
	@JsonProperty(value = "status")
	String status;
}
