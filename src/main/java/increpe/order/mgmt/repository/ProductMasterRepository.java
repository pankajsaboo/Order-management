package increpe.order.mgmt.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import increpe.order.mgmt.model.Company;
import increpe.order.mgmt.model.ProductMaster;
import increpe.order.mgmt.security.dto.ProductMasterDto;

public interface ProductMasterRepository extends CrudRepository<ProductMaster, Long> {
	
	ProductMaster findByProductCode(String productCode);
	
	List<ProductMaster> findByProductBrand(String productBrand);
	
	List<ProductMaster> findByCompanyId_id(Long companyId);
	
	ProductMaster findByIdAndCompanyId_id(Long id, Long companyId);

}
