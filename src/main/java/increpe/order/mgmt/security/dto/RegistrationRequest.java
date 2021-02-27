package increpe.order.mgmt.security.dto;

import lombok.experimental.FieldDefaults;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

@Getter
@Setter
@ToString
@NoArgsConstructor
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class RegistrationRequest {

	
	@JsonProperty(value = "userId")
	AuthenticatedUserDto userId;
	
	@JsonProperty(value = "companyTypeRelationId")
	CompanyTypeRelationDto companyTypeRelationId;
	
	@JsonProperty(value = "emailId")
	EmailsDto emailId;
	
	@JsonProperty(value = "phoneId")
	PhonesDto phoneId;
	
	@JsonProperty(value = "addressId")
	AddressDto addressId;
	
	@JsonProperty(value = "salesPersonId", required = false)
	SalesPersonDto salesPersonId;

}