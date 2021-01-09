package design.boilerplate.springboot.repository;

import org.springframework.data.repository.CrudRepository;

import design.boilerplate.springboot.model.CompanyUserRelation;

public interface CompanyUserRelationRepository extends CrudRepository<CompanyUserRelation, Long> {

}
