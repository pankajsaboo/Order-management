package increpe.order.mgmt.model;


import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
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

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Entity(name = "orders")
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class Order{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "orders_seq")
	@SequenceGenerator(name = "ORDERS_SEQ", sequenceName = "orders_seq")
	Long id;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sales_person_id")
	SalesPerson salesPersonId;
	
	@Column(name = "order_date")
	LocalDate orderDate;
	
	@Column(name = "total_value")
	Double totalValue;
	
	@OneToMany(mappedBy = "orderId", cascade = CascadeType.REMOVE)
	@JsonProperty(access = Access.READ_ONLY)
	List<OrderDetails> orderDetailsList;
	
	@Column(name = "status")
	String status;

}
