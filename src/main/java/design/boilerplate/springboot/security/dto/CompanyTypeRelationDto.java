package design.boilerplate.springboot.security.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import design.boilerplate.springboot.model.Company;
import design.boilerplate.springboot.model.CompanyType;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class CompanyTypeRelationDto {

	@JsonProperty(value = "companyId")
	Company companyId;
	
	@JsonProperty(value = "companyTypeId")
	CompanyType companyTypeId;
	
	@JsonProperty(value = "status")
	String status;
}
