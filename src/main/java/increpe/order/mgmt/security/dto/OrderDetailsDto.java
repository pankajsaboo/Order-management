package increpe.order.mgmt.security.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class OrderDetailsDto {

	@JsonProperty(value = "_id")
	Long id;
	
	CompanyProductDto companyProductId;
	
	int quantity;
	
	Double decidedPrice;
	
	Double subTotal;
}
