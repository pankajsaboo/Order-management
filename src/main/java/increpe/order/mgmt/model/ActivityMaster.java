package increpe.order.mgmt.model;

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
@Entity(name = "activity_master")
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class ActivityMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "activity_master_seq")
	@SequenceGenerator(name = "ACTIVITY_MASTER_SEQ", sequenceName = "activity_master_seq")
	Long id;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "company_id")
	Company companyId;
	
	@Column(name = "activity_type_name")
	String activityTypeName;
	
	@Column(name = "activity_description")
	String activityDescription;
	
	@Column(name = "amount")
	Double amount;
}
