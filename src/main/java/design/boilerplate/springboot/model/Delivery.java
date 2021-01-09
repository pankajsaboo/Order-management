package design.boilerplate.springboot.model;

import java.util.Date;

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
@Entity(name = "delivery")
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class Delivery extends Base{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "delivery_seq")
	@SequenceGenerator(name = "DELIVERY_SEQ", sequenceName = "delivery_seq")
	Long id;

	@OneToOne
	@JoinColumn(name = "order_details_id")
	OrderDetails orderDetailsId;
	
	@Column(name = "delivered_quantity")
	int deliveredQuantity;
	
	@Column(name = "deliveryDate")
	Date deliveryDate;
}
