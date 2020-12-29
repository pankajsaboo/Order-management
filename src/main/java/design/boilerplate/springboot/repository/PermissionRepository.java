package design.boilerplate.springboot.repository;

import org.springframework.data.repository.CrudRepository;

import design.boilerplate.springboot.model.Permission;

public interface PermissionRepository extends CrudRepository<Permission, Long> {

}
