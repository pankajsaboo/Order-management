package design.boilerplate.springboot.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.constraints.UniqueElements;

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
	
	@Column(name = "country_name", unique = true)
	String countryName;
	
	@Column(name = "country_code")
	String countryCode;
	
	@OneToMany(mappedBy = "countryId", fetch = FetchType.LAZY)
	Set<State> states = new HashSet<State>();
	
	@Column(name = "status")
	String status;

}
