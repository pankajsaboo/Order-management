package design.boilerplate.springboot.repository;

import org.springframework.data.repository.CrudRepository;

import design.boilerplate.springboot.model.AddressType;

public interface AddressTypeRepository extends CrudRepository<AddressType, Long>{

}
