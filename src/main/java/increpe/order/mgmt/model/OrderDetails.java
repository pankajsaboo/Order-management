package increpe.order.mgmt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Entity(name = "order_details")
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class OrderDetails extends Base{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "order_details_seq")
	@SequenceGenerator(name = "ORDER_DETAILS_SEQ", sequenceName = "order_details_seq")
	Long id;
	
	@OneToOne
	@JoinColumn(name = "orders_id")
	Order orderId;
	
	@ManyToOne
	@JoinColumn(name = "product_master_id")
	ProductMaster productMasterId;
	
	@Column(name = "quantity")
	int quantity;

}
