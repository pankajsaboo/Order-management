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
import javax.validation.constraints.Email;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@Entity(name = "emails")
@NoArgsConstructor
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class Emails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "emails_seq")
	@SequenceGenerator(name = "EMAILS_SEQ", sequenceName = "emails_seq")
	Long id;
	
	@Column(name = "emailId")
	String emailId;
	
	@ManyToOne
	@JoinColumn(name = "email_type_id")
	EmailType emailTypeId;
	
	@ManyToOne
	@JoinColumn(name = "company_id")
	Company companyId;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	User userId;
	
	@Column(name = "status")
	String status;

}
