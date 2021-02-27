package increpe.order.mgmt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Entity(name = "company_product")
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class CompanyProduct{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "company_product_seq")
	@SequenceGenerator(name = "COMPANY_PRODUCT_SEQ", sequenceName = "company_product_seq")
	Long id;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "company_id")
	Company buyerCompanyId;
	
	//correct the spelling
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_master_id")
	ProductMaster productId;
	
	@Column(name = "price")
	Double price;
	
	@Column(name = "targetted_quantity")
	int targettedQuantity;	
	
	@Column(name = "status")
	String status;

}
