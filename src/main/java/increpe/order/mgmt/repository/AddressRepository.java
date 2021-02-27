package increpe.order.mgmt.repository;

import org.springframework.data.repository.CrudRepository;

import increpe.order.mgmt.model.Address;

public interface AddressRepository extends CrudRepository<Address, Long> {
	
	Address findByUserId_id(Long userId);

}
