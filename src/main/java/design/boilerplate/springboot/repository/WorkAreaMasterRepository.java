package design.boilerplate.springboot.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import design.boilerplate.springboot.model.WorkAreaMaster;

public interface WorkAreaMasterRepository extends CrudRepository<WorkAreaMaster, Long> {
	
	List<WorkAreaMaster> findByCompanyId_id(Long id);
}
