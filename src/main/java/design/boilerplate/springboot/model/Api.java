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
@Entity(name = "api")
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class Api {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "api_seq")
	@SequenceGenerator(name = "API_SEQ", sequenceName = "api_seq")
	Long id;
	
	@Column(name = "api_name")
	String apiName;
	
	@Column(name = "uri")
	String uri;
	
	@Column(name = "type")
	String type;
}
