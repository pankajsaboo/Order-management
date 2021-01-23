package increpe.order.mgmt.repository;

import org.springframework.data.repository.CrudRepository;

import increpe.order.mgmt.model.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {

}
