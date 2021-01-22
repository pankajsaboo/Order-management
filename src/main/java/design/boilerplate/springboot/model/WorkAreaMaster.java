package design.boilerplate.springboot.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Entity(name = "work_area_master")
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class WorkAreaMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "work_area_seq")
	@SequenceGenerator(name = "WORK_AREA_SEQ", sequenceName = "work_area_seq")
	Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "company_id")
	Company companyId;
	
	@Column(name = "master_list")
	String workArea;
	
	@ManyToOne()
	UserWorkAreaRelation userWorkAreaRelationId;
}
