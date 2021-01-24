package increpe.order.mgmt.security.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class CityDto {
	
	@JsonProperty(value = "_id")
	Long id;
	
	@JsonProperty(value = "state")
	StateDto state;
	
	@JsonProperty(value = "cityName")
	String cityName;
	
	@JsonProperty(value = "cityCode")
	String cityCode;
	
	@JsonProperty(value = "status")
	String status;
	

}
