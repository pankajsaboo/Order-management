package design.boilerplate.springboot.model;

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
@Entity(name = "sales_person")
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class SalesPerson {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sales_person_seq")
	@SequenceGenerator(name = "SALES_PERSON_SEQ", sequenceName = "sales_person_seq")
	Long id;
	
	@Column(name = "sales_person_name")
	String name;
}
