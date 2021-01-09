package design.boilerplate.springboot.repository;

import org.springframework.data.repository.CrudRepository;

import design.boilerplate.springboot.model.ApiRolesRelation;

public interface ApiRolesRepository extends CrudRepository<ApiRolesRelation, Long> {

}
