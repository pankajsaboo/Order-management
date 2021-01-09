package design.boilerplate.springboot.repository;

import org.springframework.data.repository.CrudRepository;

import design.boilerplate.springboot.model.MenuRolesRelation;

public interface MenuRolesRelationRepository extends CrudRepository<MenuRolesRelation, Long> {

}
