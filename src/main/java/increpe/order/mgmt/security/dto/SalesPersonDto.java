package increpe.order.mgmt.security.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class SalesPersonDto {

	@JsonProperty(value = "_id")
	Long id;

	CompanyTypeRelationDto companyTypeRelationId;
	
	AuthenticatedUserDto userId;
	
	String employeeId;
	
	String designation;
	
	String headquarters;
	
	EmailsDto emailId;
	
	PhonesDto phoneId;
	
	AddressDto addressId;
	
	List<WorkAreaMasterDto> workAreaMasterList = new ArrayList<>();
}
