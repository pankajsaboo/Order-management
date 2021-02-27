package increpe.order.mgmt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Entity(name = "order_details")
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class OrderDetails{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "order_details_seq")
	@SequenceGenerator(name = "ORDER_DETAILS_SEQ", sequenceName = "order_details_seq")
	Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "orders_id", nullable = false)
	@JsonProperty(access = Access.WRITE_ONLY)
	Order orderId;
	
	@OneToOne(fetch = FetchType.LAZY)
	CompanyProduct companyProductId;
	
	@Column(name = "quantity")
	int quantity;
	
	@Column(name = "decided_price")
	Double decidedPrice;
	
	@Column(name = "subTotal")
	Double subTotal;

}
