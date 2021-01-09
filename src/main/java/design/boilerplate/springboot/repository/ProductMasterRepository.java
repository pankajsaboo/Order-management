package design.boilerplate.springboot.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import design.boilerplate.springboot.model.Company;
import design.boilerplate.springboot.model.ProductMaster;

public interface ProductMasterRepository extends CrudRepository<ProductMaster, Long> {
	
	ProductMaster findByProductCode(String productCode);
	
	List<ProductMaster> findByProductBrand(String productBrand);
	
	List<ProductMaster> findByCompanyId_id(Company companyId);

}
