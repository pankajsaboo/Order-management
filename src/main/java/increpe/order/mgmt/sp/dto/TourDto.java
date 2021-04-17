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
public class TourDto {

	@JsonProperty(value = "_id")
	Long id;

	SalesPersonDto salesPersonId;

	String location;

	LocalDate startDate;

	LocalDate endDate;

	String tourDetails;

	String status;

	String statusRemark;

	LocalDate updatedDate;
}
