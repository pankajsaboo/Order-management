package design.boilerplate.springboot.model;

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
@Entity(name = "api_roles_relation")
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class ApiRolesRelation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "api_roles_relation_seq")
	@SequenceGenerator(name = "API_ROLES_RELATION_SEQ", sequenceName = "api_roles_relation_seq")
	Long id;
	
	@OneToOne
	@JoinColumn(name = "api_id")
	Api apiId;
	
	@OneToOne
	@JoinColumn(name = "roles_id")
	Roles roleId;

	@Column(name = "status")
	String status;
}
