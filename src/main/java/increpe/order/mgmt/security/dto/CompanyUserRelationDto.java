package increpe.order.mgmt.security.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class CompanyUserRelationDto {

	@JsonProperty(value = "_id")
	Long id;

	@JsonProperty(value = "companyId")
	CompanyDto companyId;
	
	@JsonProperty(value = "userId")
	AuthenticatedUserDto userId;
	
	@JsonProperty(value = "status")
	String status;
}
