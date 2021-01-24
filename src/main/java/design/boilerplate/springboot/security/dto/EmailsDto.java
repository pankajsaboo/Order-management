package design.boilerplate.springboot.security.dto;

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
	
	@JsonProperty(value = "emailTypeId")
	EmailTypeDto emailTypeId;

	@JsonProperty(value = "companyId")
	CompanyDto companyId;
	
	@JsonProperty(value = "userId")
	AuthenticatedUserDto userId;
}
