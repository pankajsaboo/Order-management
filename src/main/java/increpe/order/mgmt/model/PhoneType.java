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
@Entity(name = "phone_type")
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class PhoneType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "phone_type_seq")
	@SequenceGenerator(name = "PHONE_TYPE_SEQ", sequenceName = "phone_type_seq")
	Long id;
	
	@Column(name = "phone_type_name")
	String phoneTypeName;
	
	@Column(name = "status")
	String status;
}
