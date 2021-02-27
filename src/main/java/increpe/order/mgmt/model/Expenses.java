package increpe.order.mgmt.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@Entity(name = "expenses")
@NoArgsConstructor
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class Expenses {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "expenses_seq")
	@SequenceGenerator(name = "EXPENSES_SEQ", sequenceName = "expenses_seq")
	Long id;
	
	@OneToOne
	@JoinColumn(name = "sales_person_id")
	SalesPerson salesPersonId;
	
	@Column(name = "expense_date")
	LocalDate expenseDate;
	
	@Column(name = "area_worked")
	String areaWorked;
	
	@Column(name = "expense_category")
	String expenseCategory;
	
	@Column(name = "expense_amount")
	Double expenseAmount;
	
	@Column(name = "bill_photos", columnDefinition = "TEXT")
	String billPhotos;
	
	@Column(name = "remark")
	String remark;

}
