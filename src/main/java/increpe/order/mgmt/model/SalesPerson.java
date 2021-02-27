package increpe.order.mgmt.model;

import java.util.ArrayList;
import java.util.List;

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

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Entity(name = "sales_person")
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class SalesPerson {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "sales_person_seq")
	@SequenceGenerator(name = "SALES_PERSON_SEQ", sequenceName = "sales_person_seq")
	Long id;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	User userId;
	
	@Column(name = "employeeId", unique = true)
	String employeeId;
	
	@Column(name = "designation")
	String designation;
	
	@Column(name = "headquarters")
	String headquarters;
}
