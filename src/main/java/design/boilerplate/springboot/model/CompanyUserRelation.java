package design.boilerplate.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Entity(name = "company_user_relation")
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class CompanyUserRelation extends Base{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "company_user_relation_seq")
	@SequenceGenerator(name = "COMPANY_USER_RELATION_SEQ", sequenceName = "company_user_relation_seq")
	Long id;
	
	@OneToOne
	@JoinColumn(name = "company_id")
	Company companyId;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	User userId;

	@Column(name = "status")
	String status;
}
