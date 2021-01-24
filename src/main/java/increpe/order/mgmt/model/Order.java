package increpe.order.mgmt.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Entity(name = "orders")
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class Order extends Base{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "orders_seq")
	@SequenceGenerator(name = "ORDERS_SEQ", sequenceName = "orders_seq")
	Long id;
	
	@Column(name = "order_date")
	Date orderDate;
	
	@Column(name = "total_value")
	Double totalValue;
	
	@Column(name = "status")
	String status;

}
