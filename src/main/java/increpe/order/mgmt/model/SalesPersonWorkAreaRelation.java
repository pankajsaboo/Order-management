package increpe.order.mgmt.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Entity(name = "sales_person_work_area_relation")
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class SalesPersonWorkAreaRelation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sales_person_work_area_relation_seq")
	@SequenceGenerator(name = "SALES_PERSON_WORK_AREA_RELATION_SEQ", sequenceName = "sales_person_area_relation_seq")
	Long id;
	
	@OneToOne
    @JoinColumn(name = "work_area_master_id")
    WorkAreaMaster workAreaMasterId;

    @OneToOne
    @JoinColumn(name = "sales_person_id")
    SalesPerson salesPersonId;
	
	
}
