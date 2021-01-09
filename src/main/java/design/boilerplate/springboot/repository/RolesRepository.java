package design.boilerplate.springboot.repository;

import org.springframework.data.repository.CrudRepository;

import design.boilerplate.springboot.model.Roles;

public interface RolesRepository extends CrudRepository<Roles, Long> {
	
	boolean existsByTitle(String title);

	Roles findByTitle(String rolesTitle);

}
