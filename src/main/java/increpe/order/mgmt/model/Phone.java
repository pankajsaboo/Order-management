package increpe.order.mgmt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@Entity(name = "phone")
@NoArgsConstructor
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class Phone {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "phone_seq")
	@SequenceGenerator(name = "PHONE_SEQ", sequenceName = "phone_seq")
	Long id;
	
	@OneToOne
	@JoinColumn(name = "phone_type_id")
	PhoneType phoneTypeId;
	
	@Column(name = "phone_number")
	String phone;
	
	@ManyToOne
	@JoinColumn(name = "company_id")
	Company companyId;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	User userId;
	
	@Column(name = "status")
	String status;
	
	

}
