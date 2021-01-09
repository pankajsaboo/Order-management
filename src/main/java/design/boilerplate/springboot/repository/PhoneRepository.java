package design.boilerplate.springboot.repository;

import org.springframework.data.repository.CrudRepository;

import design.boilerplate.springboot.model.Phone;

public interface PhoneRepository extends CrudRepository<Phone, Long> {

}
