package increpe.order.mgmt.model;

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
import lombok.experimental.FieldDefaults;

@Data
@Entity(name = "customer_sales_person_relation")
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class CustomerSalesPersonRelation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "customer_sales_person_relation_seq")
	@SequenceGenerator(name = "CUSTOMER_SALES_PERSON_RELATION_SEQ", sequenceName = "customer_sales_person_relation_seq")
	Long id;
	
	@OneToOne
	@JoinColumn(name= "sales_person_id")
	SalesPerson salesPersonId;
	
	@OneToOne
	@JoinColumn(name = "company_id")
	Company customerCompanyId;
	
	@Column(name = "status")
	String status;
}
