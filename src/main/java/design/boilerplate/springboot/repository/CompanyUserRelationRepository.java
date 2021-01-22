package design.boilerplate.springboot.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import design.boilerplate.springboot.model.CompanyUserRelation;

public interface CompanyUserRelationRepository extends CrudRepository<CompanyUserRelation, Long> {
	
	List<CompanyUserRelation> findByCompanyId_id(Long id);

}
