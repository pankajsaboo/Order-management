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
@Entity(name = "seller_buyer_relation")
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class SellerBuyerRelation{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seller_buyer_relation_seq")
	@SequenceGenerator(name = "SELLER_BUYER_RELATION_SEQ", sequenceName = "seller_buyer_relation_seq")
	Long id;
	
//	@Column(name = "seller_company_id")
//	Long sellerCompanyId;
//	
//	@Column(name = "buyer_company_id")
//	Long buyerCompanyId;
	
	@OneToOne
	@JoinColumn(name = "seller_company_id", referencedColumnName = "id")
	Company sellerCompanyId;
	
	@OneToOne
	@JoinColumn(name = "buyer_company_id", referencedColumnName = "id")
	Company buyerCompanyId;
	
	@Column(name = "status")
	String status;
}
