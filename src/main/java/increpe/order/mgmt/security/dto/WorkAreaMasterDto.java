package increpe.order.mgmt.security.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class WorkAreaMasterDto {

	@JsonProperty(value = "_id")
	Long id;
	
	@JsonProperty(value = "companyId")
	CompanyDto companyId;
	
	@JsonProperty(value = "workArea")
	String workArea;
}
