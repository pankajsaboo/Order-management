package increpe.order.mgmt.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Entity(name = "user_work_area_relation")
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class UserWorkAreaRelation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "user_work_area_relation_seq")
	@SequenceGenerator(name = "USER_WORK_AREA_RELATION_SEQ", sequenceName = "user_work_area_relation_seq")
	Long id;
	
	@OneToOne()
	@JoinColumn(name = "user_id")
	User userId;
	
	@OneToMany(mappedBy = "userWorkAreaRelationId")
	List<WorkAreaMaster> workAreaMasterIdList = new ArrayList<>();
	
}
