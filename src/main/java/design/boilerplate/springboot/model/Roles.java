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
@Entity(name = "roles")
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class Roles {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "roles_seq")
	@SequenceGenerator(name = "ROLES_SEQ", sequenceName = "roles_seq")
	Long id;
	
	@Column(name = "title")
	String title;
	
	@Column(name = "description")
	String description;
	
	@Column(name = "status")
	String status;

}
