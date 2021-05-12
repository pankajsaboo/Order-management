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
@Entity(name = "visits")
@NoArgsConstructor
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class Visits {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "visits_seq")
	@SequenceGenerator(name = "VISITS_SEQ", sequenceName = "visits_seq")
	Long id;
	
//	@OneToOne
//	@JoinColumn(name = "customer_sales_person_relation_id")
//	CustomerSalesPersonRelation customerSalesPersonRelationId;
	
	@OneToOne
	@JoinColumn(name = "sales_person_id")
	SalesPerson salesPersonId;
	
	@OneToOne
	@JoinColumn(name = "company_id")
	Company customerId;
	
	@Column(name = "dealer")
	String dealer;
	
	@Column(name = "address", columnDefinition = "TEXT")
	String address;
	
	@Column(name = "live_location")
	String liveLocation;
	
	@Column(name = "date")
	LocalDate visitDate;
	
	@Column(name = "time")
	LocalTime visitTime;
	
	@Column(name = "comment", columnDefinition = "TEXT")
	String comment;
	
	@Column(name = "selfie", columnDefinition = "TEXT")
	String selfie;
	
	@Column(name  = "satatus")
	String status;
}
