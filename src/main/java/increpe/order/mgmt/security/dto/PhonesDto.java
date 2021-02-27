package increpe.order.mgmt.security.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class PhonesDto {

	@JsonProperty(value = "_id")
	Long id;
	
	String phone;
	
	PhoneTypeDto phoneTypeId;

	CompanyDto companyId;
	
	AuthenticatedUserDto userId;
	
	String status;
}
