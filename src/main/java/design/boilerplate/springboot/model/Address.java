package design.boilerplate.springboot.model;

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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Entity(name = "address")
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class Address extends Base {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "address_seq")
	@SequenceGenerator(name = "ADDRESS__SEQ", sequenceName = "address_seq")
	Long id;
	
	@ManyToOne
	@JoinColumn(name = "address_type_id")
	AddressType addressTypeId;
	
	@OneToOne
	@JoinColumn(name = "company_id")
	Company companyId;
	
	@ManyToOne 
	@JoinColumn(name = "city_id")
	City cityId;
	
	@Column(name = "addressLine1")
	String addressLine1; 
	
	@Column(name = "addressLine2")
	String addressLine2;

	@Column(name = "addressLine3")
	String addressLine3;
	
}
