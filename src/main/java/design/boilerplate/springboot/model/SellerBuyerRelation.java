package design.boilerplate.springboot.model;

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
public class SellerBuyerRelation extends Base{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "seller_buyer_relation_seq")
	@SequenceGenerator(name = "SELLER_BUYER_RELATION_SEQ", sequenceName = "seller_buyer_relation_seq")
	Long id;
	
	@OneToOne
	@JoinColumn(name = "company_id", insertable = false, updatable = false)
	Company sellerCompanyId;
	
	@OneToOne
	@JoinColumn(name = "company_id", insertable = false, updatable = false)
	Company buyerCompanyId;
	
	@Column(name = "status")
	String status;

}
