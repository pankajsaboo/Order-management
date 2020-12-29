package design.boilerplate.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@Entity(name = "country")
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class Country {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "country_seq")
	@SequenceGenerator(name = "COUNTRY_SEQ", sequenceName = "country_seq")
	Long id;
	
	@Column(name = "country_name")
	String countryName;
	
	@Column(name = "country_code")
	String countryCode;
	
	@Column(name = "status")
	String status;

}
