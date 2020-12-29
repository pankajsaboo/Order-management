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
@Entity(name = "permission")
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class Permission {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "permission_seq")
	@SequenceGenerator(name = "PERMISSION_SEQ", sequenceName = "permission_seq")
	Long id;
	
	@Column(name = "title")
	String title;
	
	@Column(name = "description")
	String description;
	
	@Column(name = "status")
	String status;

}
