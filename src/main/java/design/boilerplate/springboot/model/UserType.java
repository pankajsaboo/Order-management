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
@Entity(name = "user_type")
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class UserType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "user_type_seq")
	@SequenceGenerator(name = "USER_TYPE_SEQ", sequenceName = "user_type_seq")
	Long id;
	
	@Column(name = "user_type_name")
	String userTypeName;
	
	@Column(name = "status")
	String status;
}
