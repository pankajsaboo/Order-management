package increpe.order.mgmt.security.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import increpe.order.mgmt.sp.dto.AttendanceDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class AttendanceReportDto {
	
	SalesPersonDto salesPersonId;
	List<AttendanceDto> attendanceList;
}
