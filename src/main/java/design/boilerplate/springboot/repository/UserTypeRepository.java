package design.boilerplate.springboot.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import design.boilerplate.springboot.model.UserType;

public interface UserTypeRepository extends CrudRepository<UserType, Long> {
	
	UserType findByUserTypeName(String userTypeName);

	List<UserType> findByStatus(String status);

	boolean existsByUserTypeName(String userTypeName);

}
