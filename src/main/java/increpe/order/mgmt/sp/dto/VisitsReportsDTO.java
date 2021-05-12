package increpe.order.mgmt.sp.dto;

import java.math.BigInteger;
import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class VisitsReportsDTO {
	
	public VisitsReportsDTO(Object distributor, Object employeeId, Object fullName, Object headquarters,
			Object designation, Object visitId, Object visitDate, Object visitTime, Object dealer, Object address,
			Object liveLocation, Object visitComment) {
		
		this.distributor = Objects.isNull(dealer) ? (String) distributor : null;
		this.employeeId = (String) employeeId;
		this.fullName = (String) fullName;
		this.headquarters = (String) headquarters;
		this.designation = (String) designation;
		this.visitId = ((BigInteger)visitId).longValue();
		this.visitDate = (Date) visitDate;
		this.visitTime = (Time) visitTime;
		this.dealer = Objects.isNull(dealer) ? null : (String) dealer;
		this.address = (String) address;
		this.liveLocation = (String) liveLocation;
		this.visitComment = (String) visitComment;
	}

	String distributor;
	
	String employeeId;

	String fullName;

	String headquarters;

	String designation;
	
	Long visitId;
	
	Date visitDate;
	
	Time visitTime;
	
	String dealer;
	
	String address;
	
	String liveLocation;
	
	String visitComment;

}
