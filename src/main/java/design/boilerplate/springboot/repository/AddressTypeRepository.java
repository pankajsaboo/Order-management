package design.boilerplate.springboot.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import design.boilerplate.springboot.model.AddressType;
import design.boilerplate.springboot.security.dto.AddressTypeDto;

public interface AddressTypeRepository extends CrudRepository<AddressType, Long>{

	AddressType findByAddressTypeName(String addressTypeName);
	
	List<AddressType> findByStatus(String status);
	
	boolean existsByAddressTypeName(String addressTypeName);
}
