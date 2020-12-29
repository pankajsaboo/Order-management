package design.boilerplate.springboot.repository;

import org.springframework.data.repository.CrudRepository;

import design.boilerplate.springboot.model.EmailType;

public interface EmailTypeRepository extends CrudRepository<EmailType, Long> {

}
