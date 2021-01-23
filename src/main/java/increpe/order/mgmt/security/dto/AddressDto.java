package increpe.order.mgmt.security.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import increpe.order.mgmt.model.City;
import increpe.order.mgmt.model.Company;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class AddressDto {
	
	@JsonProperty(value = "_id")
	Long id;
	
	@JsonProperty(value = "addressLine1")
	String addressLine1;
	
	@JsonProperty(value = "addressLine2")
	String addressLine2;
	
	@JsonProperty(value = "addressLine3")
	String addressLine3;
	
	@JsonProperty(value = "companyId")
	CompanyDto companyId;
	
	@JsonProperty(value = "userId")
	AuthenticatedUserDto userId;
	
	@JsonProperty(value = "addressType")
	AddressTypeDto addressType;
	
	@JsonProperty(value = "city")
	CityDto city;

}
