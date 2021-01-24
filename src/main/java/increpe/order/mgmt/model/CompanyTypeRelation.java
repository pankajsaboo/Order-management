package increpe.order.mgmt.model;

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
@Entity(name = "company_type_relation")
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class CompanyTypeRelation extends Base{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "company_type_relation_seq")
	@SequenceGenerator(name = "COMPANY_TYPE_RELATION_SEQ", sequenceName = "company_type_relation_seq")
	Long id;
	
	@OneToOne
	@JoinColumn(name = "company_id")
	Company companyId;
	
	@OneToOne
	@JoinColumn(name = "company_type_id")
	CompanyType companyTypeId;
	
	@Column(name = "status")
	String status;

}
