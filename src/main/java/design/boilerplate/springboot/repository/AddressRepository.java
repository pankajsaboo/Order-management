package design.boilerplate.springboot.repository;

import org.springframework.data.repository.CrudRepository;

import design.boilerplate.springboot.model.Address;

public interface AddressRepository extends CrudRepository<Address, Long> {

}
