package increpe.order.mgmt.sp.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import increpe.order.mgmt.security.dto.SalesPersonDto;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class ExpensesDto {

	@JsonProperty(value = "_id")
	Long id;
	
	SalesPersonDto salesPersonId;
	
	LocalDate expenseDate;
	
	String areaWorked;
	
	String expenseCategory;
	
	Double expenseAmount;
	
	String billPhotos;
	
	String remark;
}
