package increpe.order.mgmt.sp.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import increpe.order.mgmt.security.dto.SalesPersonDto;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class AttendanceDto {

	@JsonProperty(value = "_id")
	Long id;
	
	SalesPersonDto salesPersonId;
	
	LocalDateTime startTime;
	
	LocalDateTime endTime;
	
	String fieldLocation;
	
	String liveLocation;
	
	@JsonProperty(value = "isHoliday")
	boolean isHoliday;
	
	@JsonProperty(value = "isWeekend")
	boolean isWeekend;
	
	@JsonProperty(value = "onLeave")
	boolean onLeave;
}
