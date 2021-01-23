package increpe.order.mgmt.model;

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
@Entity(name = "email_type")
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class EmailType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "email_type_seq")
	@SequenceGenerator(name = "EMAIL_TYPE_SEQ", sequenceName = "email_type_seq")
	Long id;
	
	@Column(name = "email_type_name")
	String emailTypeName;
	
	@Column(name = "status")
	String status;

}
