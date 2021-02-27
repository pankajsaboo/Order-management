package increpe.order.mgmt.security.dto;

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
public class ProductMasterDto {
	
	@JsonProperty(value = "_id")
	Long id;

	CompanyDto companyId;
	
	String productName;
	
	String productCode;
	
	String productDescription;
	
	String productBrand;
	
	String productImage;
	
	String status;
}
