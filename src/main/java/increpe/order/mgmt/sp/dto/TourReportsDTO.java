package increpe.order.mgmt.sp.dto;

import java.math.BigInteger;
import java.sql.Date;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class TourReportsDTO {
	
	

	public TourReportsDTO(Object employeeId, Object fullName, Object designation, Object headquarters, 
				Object tourId, Object fromLocation, Object toLocation, Object startDate, 
				Object endDate, Object tourDetails, Object status, Object statusRemark) {
		
		this.employeeId = (String) employeeId;
		this.fullName = (String) fullName;
		this.headquarters = (String) headquarters;
		this.designation = (String) designation;
		this.fromLocation = (String) fromLocation;
		this.toLocation = (String) toLocation;
		this.startDate = (Date) startDate;
		this.endDate = (Date) endDate;
		this.status = (String) status;
		this.statusRemark = (String) statusRemark;
		this.tourDetails = (String) tourDetails;
		this.tourId = ((BigInteger) tourId).longValue();
	}

	String employeeId;

	String fullName;

	String headquarters;

	String designation;
	
	Long tourId;
	
	String fromLocation;
	
	String toLocation;
	
	Date startDate;
	
	Date endDate;
	
	String status;
	 
	String statusRemark;
	
	String tourDetails;
}
