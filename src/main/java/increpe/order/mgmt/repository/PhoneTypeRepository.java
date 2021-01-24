package increpe.order.mgmt.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import increpe.order.mgmt.model.PhoneType;

public interface PhoneTypeRepository extends CrudRepository<PhoneType, Long> {
	
	PhoneType findByPhoneTypeName(String phoneTypeName);

	List<PhoneType> findByStatus(String status);

	boolean existsByPhoneTypeName(String phoneTypeName);

}
