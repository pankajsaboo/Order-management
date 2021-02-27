package increpe.order.mgmt.security.dto;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import increpe.order.mgmt.model.OrderDetails;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class OrderDto {

	@JsonProperty(value = "_id")
	Long id;
	
	SalesPersonDto salesPersonId;
	
	LocalDate orderDate;
	
	Double totalValue;
	
	List<OrderDetailsDto> orderDetailsList;
	
	String status;
}
