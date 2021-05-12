package increpe.order.mgmt.sp.dto;

import java.time.LocalDate;
import java.time.LocalTime;


import com.fasterxml.jackson.annotation.JsonProperty;

import increpe.order.mgmt.security.dto.CompanyDto;
import increpe.order.mgmt.security.dto.CustomerSalesPersonRelationDto;
import increpe.order.mgmt.security.dto.SalesPersonDto;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class VisitsDto {
	
	@JsonProperty(value = "_id")
	Long id;

//	@JsonProperty(value = "relationId")
//	CustomerSalesPersonRelationDto customerSalesPersonRelationId;
	
	@JsonProperty(value = "customerId")
	CompanyDto customerId;
	
	@JsonProperty(value = "salesPersonId")
	SalesPersonDto salesPersonId;
	
	@JsonProperty(value = "dealer")
	String dealer;
	
	@JsonProperty(value = "address")
	String address;
	
	@JsonProperty(value = "liveLocation")
	String liveLocation;
	
	@JsonProperty(value = "visitDate")
	LocalDate visitDate;
	
	@JsonProperty(value = "visitTime")
	LocalTime visitTime;

	@JsonProperty(value = "comment")
	String comment;
	
	@JsonProperty(value = "selfie")
	String selfie;
	
	@JsonProperty(value = "status")
	String status;
}
