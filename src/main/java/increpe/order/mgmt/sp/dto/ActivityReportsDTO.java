package increpe.order.mgmt.sp.dto;

import java.math.BigInteger;
import java.sql.Date;
import java.time.LocalDate;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class ActivityReportsDTO {
	
	public ActivityReportsDTO(Object employeeId, Object fullName, Object headquarters, Object designation,
			Object activityTypeName, Object activityId, Object quantity, Object activityDate, Object note, Object status,
			Object statusRemark) {
		
		this.employeeId = (String) employeeId;
		this.fullName = (String) fullName;
		this.headquarters = (String) headquarters;
		this.designation = (String) designation;
		this.activityTypeName = (String) activityTypeName;
		this.activityId = ((BigInteger)activityId).longValue();
		this.quantity = (int) quantity;
		this.activityDate = (Date) activityDate;
		this.note = (String) note;
		this.status = (String) status;
		this.statusRemark = (String) statusRemark;
	}


	String employeeId;
	
	String fullName;
	
	String headquarters;
	
	String designation;
	
	String activityTypeName;
	
	Long activityId;
	
	int quantity;
	
	Date activityDate;
	
	String note;
	 
	String status;
	 
	String statusRemark;
}
