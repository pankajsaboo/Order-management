package increpe.order.mgmt.repository;

import org.springframework.data.repository.CrudRepository;

import increpe.order.mgmt.model.OrderDetails;

public interface OrderDetailsRepository extends CrudRepository<OrderDetails, Long>{

}
