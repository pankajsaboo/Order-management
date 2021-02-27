package increpe.order.mgmt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Entity(name = "product_master")
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class ProductMaster{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "product_master_seq")
	@SequenceGenerator(name = "PRODUCT_MASTER_SEQ", sequenceName = "product_master_seq")
	Long id;
	
	@ManyToOne
	@JoinColumn(name = "company_id")
	Company companyId;
	
	@Column(name = "product_name")
	String productName;
	
	@Column(name = "product_code")
	String productCode;
	
	@Column(name = "product_description")
	String productDescription;
	
	@Column(name = "product_brand")
	String productBrand;
	
	@Column(name = "product_image", columnDefinition = "TEXT")
	String productImage;
	
	@Column(name = "status")
	String status;
}
