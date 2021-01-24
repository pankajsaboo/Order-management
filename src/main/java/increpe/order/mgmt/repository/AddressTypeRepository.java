package increpe.order.mgmt.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import increpe.order.mgmt.model.AddressType;
import increpe.order.mgmt.security.dto.AddressTypeDto;

public interface AddressTypeRepository extends CrudRepository<AddressType, Long>{

	AddressType findByAddressTypeName(String addressTypeName);
	
	List<AddressType> findByStatus(String status);
	
	boolean existsByAddressTypeName(String addressTypeName);
}
