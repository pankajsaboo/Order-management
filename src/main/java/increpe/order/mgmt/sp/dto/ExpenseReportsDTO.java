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
public class ExpenseReportsDTO {

	public ExpenseReportsDTO(Object employeeId, Object fullName, Object designation, Object headquarters, 
			Object expenseId, Object areaWorked, Object expenseDate, Object expenseType, Object expenseAmount,
			Object remark) {
		
		this.employeeId = (String) employeeId;
		this.fullName = (String) fullName;
		this.headquarters = (String) headquarters;
		this.designation = (String) designation;
		this.expenseId = ((BigInteger)expenseId).longValue();
		this.areaWorked = (String) areaWorked;
		this.expenseDate = (Date) expenseDate;
		this.expenseType = (String) expenseType;
		this.expenseAmount = (Double) expenseAmount;
		this.remark = (String) remark;
	}

	String employeeId;

	String fullName;

	String headquarters;

	String designation;
	
	Long expenseId;
	
	String areaWorked;
	
	Date expenseDate;
	
	String expenseType;
	
	Double expenseAmount;
	
	String remark;
}
