package increpe.order.mgmt.security.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import increpe.order.mgmt.model.Company;
import increpe.order.mgmt.model.CompanyType;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class CompanyTypeRelationDto {
	
	@JsonProperty(value = "_id")
	Long id;

	@JsonProperty(value = "companyId")
	CompanyDto companyId;
	
	@JsonProperty(value = "companyTypeId")
	CompanyTypeDto companyTypeId;
	
	@JsonProperty(value = "status")
	String status;
}
