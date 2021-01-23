package increpe.order.mgmt.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import increpe.order.mgmt.model.CompanyUserRelation;

public interface CompanyUserRelationRepository extends CrudRepository<CompanyUserRelation, Long> {
	
	List<CompanyUserRelation> findByCompanyId_id(Long id);

}
