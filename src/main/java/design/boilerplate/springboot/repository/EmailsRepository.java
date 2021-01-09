package design.boilerplate.springboot.repository;

import org.springframework.data.repository.CrudRepository;

import design.boilerplate.springboot.model.Emails;

public interface EmailsRepository extends CrudRepository<Emails, Long> {
	
	boolean existsByEmailId(String emailId);

}
