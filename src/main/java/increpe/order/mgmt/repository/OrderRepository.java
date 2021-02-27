package increpe.order.mgmt.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import increpe.order.mgmt.model.Order;
import increpe.order.mgmt.model.SalesPerson;

public interface OrderRepository extends CrudRepository<Order, Long> {
	
	List<Order> findBySalesPersonId_id(Long salesPersonId);
	
	List<Order> findBySalesPersonId_UserId_idIn(List<Long> userIdList);

}
