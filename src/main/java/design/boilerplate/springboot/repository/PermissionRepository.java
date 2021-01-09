package design.boilerplate.springboot.repository;

import org.springframework.data.repository.CrudRepository;

import design.boilerplate.springboot.model.Permission;
import design.boilerplate.springboot.model.Roles;

public interface PermissionRepository extends CrudRepository<Permission, Long> {

	boolean existsByTitle(String title);

	Permission findByTitle(String permissionTitle);
}
