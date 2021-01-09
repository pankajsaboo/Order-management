package design.boilerplate.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Entity(name = "company_type")
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class CompanyType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "company_type_seq")
	@SequenceGenerator(name = "COMPANY_TYPE_SEQ", sequenceName = "company_type_seq")
	Long id;
	
	@Column(name = "company_type_name")
	String companyTypeName;
	
	@Column(name = "status")
	String status;

}
