package increpe.order.mgmt.security.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import increpe.order.mgmt.model.Company;
import increpe.order.mgmt.model.ProductMaster;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class CompanyProductDto {

	@JsonProperty(value = "_id")
	Long id;

	CompanyDto buyerCompanyId;

	ProductMasterDto productId;

	Double price;

	int targettedQuantity;

	String status;
}
