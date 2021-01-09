package design.boilerplate.springboot.repository;

import org.springframework.data.repository.CrudRepository;

import design.boilerplate.springboot.model.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {

}
