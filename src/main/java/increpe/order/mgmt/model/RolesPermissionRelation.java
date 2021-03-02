package increpe.order.mgmt.model;

import javax.persistence.Entity;
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
@Entity(name = "roles_permission_relation")
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class RolesPermissionRelation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "roles_permission_relation_seq")
	@SequenceGenerator(name = "ROLES_PERMISSION_RELATION_SEQ", sequenceName = "roles_permission_relation_seq")
	Long id;
	
	@OneToOne
	@JoinColumn(name = "roles_id")
	Roles rolesId;
	
	@OneToOne
	@JoinColumn(name = "permission_id")
	Permission permissionId;
}
