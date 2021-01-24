package increpe.order.mgmt.repository;

import org.springframework.data.repository.CrudRepository;

import increpe.order.mgmt.model.Company;

public interface CompanyRepository extends CrudRepository<Company, Long> {
	
	boolean existsByCompanyName(String companyName);

	Company findByCompanyName(String companyName);

}
