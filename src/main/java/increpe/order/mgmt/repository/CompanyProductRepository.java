package increpe.order.mgmt.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import increpe.order.mgmt.model.CompanyProduct;

public interface CompanyProductRepository extends CrudRepository<CompanyProduct, Long> {

	List<CompanyProduct> findByBuyerCompanyId_id(Long id);
	
	List<CompanyProduct> findByProductId_id(Long id);
	
	List<CompanyProduct> findByProductId_CompanyId_Id(Long id);
	
}
