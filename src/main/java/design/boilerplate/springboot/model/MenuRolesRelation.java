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
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Entity(name = "menu_roles_relation")
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class MenuRolesRelation extends Base{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "menu_roles_relation_seq")
	@SequenceGenerator(name = "MENU_ROLES_RELATION_SEQ", sequenceName = "menu_roles_relation_seq")
	Long id;
	
	@OneToOne
	@JoinColumn(name = "menu_id")
	Menu menuId;
	
	@OneToOne
	@JoinColumn(name = "roles_id")
	Roles rolesId;
	
	@Column(name = "status")
	String status;
}
