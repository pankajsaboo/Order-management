package design.boilerplate.springboot.repository;

import org.springframework.data.repository.CrudRepository;

import design.boilerplate.springboot.model.SalesPerson;

public interface SalesPoersonRepository extends CrudRepository<SalesPerson, Long> {

}
