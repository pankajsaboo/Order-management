package increpe.order.mgmt.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import increpe.order.mgmt.model.WorkAreaMaster;

public interface WorkAreaMasterRepository extends CrudRepository<WorkAreaMaster, Long> {
	
	List<WorkAreaMaster> findByCompanyId_id(Long id);
}
