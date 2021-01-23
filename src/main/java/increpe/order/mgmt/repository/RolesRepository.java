package increpe.order.mgmt.repository;

import org.springframework.data.repository.CrudRepository;

import increpe.order.mgmt.model.Roles;

public interface RolesRepository extends CrudRepository<Roles, Long> {
	
	boolean existsByTitle(String title);

	Roles findByTitle(String rolesTitle);

}
