package design.boilerplate.springboot.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import design.boilerplate.springboot.model.UserWorkAreaRelation;

public interface UserWorkAreaRelationRepository extends CrudRepository<UserWorkAreaRelation, Long>{

	List<UserWorkAreaRelation> findByUserId_id(Long id);
}
