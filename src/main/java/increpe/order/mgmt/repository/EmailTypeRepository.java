package increpe.order.mgmt.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import increpe.order.mgmt.model.EmailType;

public interface EmailTypeRepository extends CrudRepository<EmailType, Long> {
	
	EmailType findByEmailTypeName(String emailTypeName);

	List<EmailType> findByStatus(String status);

	boolean existsByEmailTypeName(String emailTypeName);

}
