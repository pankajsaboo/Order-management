package design.boilerplate.springboot.repository;

import org.springframework.data.repository.CrudRepository;

import design.boilerplate.springboot.model.RolesPermissionRelation;

public interface RolesPermissionRelationRepository extends CrudRepository<RolesPermissionRelation, Long> {

}
