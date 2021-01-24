package increpe.order.mgmt.security.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class EmailsDto {
	
	@JsonProperty(value = "_id")
	Long id;
	
	@JsonProperty(value = "emailId")
	String emailId;
	
	@JsonProperty(value = "emailType")
	EmailTypeDto emailTypeId;

	@JsonProperty(value = "company")
	CompanyDto companyId;
	
	@JsonProperty(value = "user")
	AuthenticatedUserDto userId;
}
