package increpe.order.mgmt.sp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import increpe.order.mgmt.security.dto.CompanyDto;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class ActivityMasterDto {

	@JsonProperty(value = "_id")
	Long id;
	
	CompanyDto companyId;
	
	String activityTypeName;
	
	String activityDescription;
	
	Double amount;
}
