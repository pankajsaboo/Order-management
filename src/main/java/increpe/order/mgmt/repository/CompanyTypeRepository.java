package increpe.order.mgmt.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import increpe.order.mgmt.model.CompanyType;

public interface CompanyTypeRepository extends CrudRepository<CompanyType, Long> {

	CompanyType findByCompanyTypeName(String companyTypeName);

	List<CompanyType> findByStatus(String status);

	boolean existsByCompanyTypeName(String companyTypeName);
}
