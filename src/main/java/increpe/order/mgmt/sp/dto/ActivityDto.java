package increpe.order.mgmt.sp.dto;

import java.time.LocalDate;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonProperty;

import increpe.order.mgmt.security.dto.SalesPersonDto;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class ActivityDto {

	@JsonProperty(value = "_id")
	Long id;
	
	SalesPersonDto salesPersonId;
	
	LocalDate activityDate;
	
	ActivityMasterDto activityTypeId;
	
	int quantity;
	
	String note;
	
	String photo_1;
	
	String photo_2;
	
	String photo_3;
	
	String status;
	
	String statusRemark;
	
	LocalDate updatedDate;
}
