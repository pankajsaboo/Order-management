package design.boilerplate.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.springframework.beans.factory.annotation.Value;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Entity(name = "address_type")
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class AddressType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "address_type_seq")
	@SequenceGenerator(name = "ADDRESS_TYPE_SEQ", sequenceName = "address_type_seq")
	Long id;
	
	@Column(name = "address_type_name", unique = true)
	String addressTypeName;
	
	@Column(name = "status")
	String status;

}
