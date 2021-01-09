package design.boilerplate.springboot.repository;

import org.springframework.data.repository.CrudRepository;

import design.boilerplate.springboot.model.Delivery;

public interface DeliveryRepository extends CrudRepository<Delivery, Long> {

}
