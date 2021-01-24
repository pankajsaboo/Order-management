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
@Entity(name = "company")
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class Company extends Base{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "company_seq")
	@SequenceGenerator(name = "COMPANY_SEQ", sequenceName = "company_seq")
	Long id;
	
	@Column(name = "gst_number")
	String gstNumber;
	
	@Column(name = "company_name")
	String companyName;
	
}
