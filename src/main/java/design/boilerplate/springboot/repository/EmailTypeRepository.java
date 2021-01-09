package design.boilerplate.springboot.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import design.boilerplate.springboot.model.EmailType;

public interface EmailTypeRepository extends CrudRepository<EmailType, Long> {
	
	EmailType findByEmailTypeName(String emailTypeName);

	List<EmailType> findByStatus(String status);

	boolean existsByEmailTypeName(String emailTypeName);

}
