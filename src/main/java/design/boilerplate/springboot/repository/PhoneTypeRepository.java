package design.boilerplate.springboot.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import design.boilerplate.springboot.model.PhoneType;

public interface PhoneTypeRepository extends CrudRepository<PhoneType, Long> {
	
	PhoneType findByPhoneTypeName(String phoneTypeName);

	List<PhoneType> findByStatus(String status);

	boolean existsByPhoneTypeName(String phoneTypeName);

}
