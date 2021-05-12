package increpe.order.mgmt.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Entity(name = "activity")
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class Activity{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "activity_seq")
	@SequenceGenerator(name = "ACTIVITY_SEQ", sequenceName = "activity_seq")
	Long id;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sales_person_id")
	SalesPerson salesPersonId;
	
	@Column(name = "activity_date")
	LocalDate activityDate;
	
	@OneToOne
	@JoinColumn(name = "activity_master_id")
	ActivityMaster activityTypeId;
	
	@Column(name = "quantity")
	int quantity;
	
	@Column(name = "note")
	String note;
	
	@Column(name = "status")
	String status;
	
	@Column(name = "status_remark")
	String statusRemark;
	
	@Column(name = "updated_date")
	LocalDate updatedDate;
	
	@Column(name = "photo_1", columnDefinition = "TEXT")
	String photo_1;
	
	@Column(name = "photo_2", columnDefinition = "TEXT")
	String photo_2;
	
	@Column(name = "photo_3", columnDefinition = "TEXT")
	String photo_3;
	
}
