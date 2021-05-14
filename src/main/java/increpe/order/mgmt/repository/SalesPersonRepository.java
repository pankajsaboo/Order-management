package increpe.order.mgmt.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import increpe.order.mgmt.model.SalesPerson;

public interface SalesPersonRepository extends CrudRepository<SalesPerson, Long>{

	 SalesPerson findByUserId_id(Long id);
	 
	 boolean existsByEmployeeId(String empId);
	 
	 @Query(value = "select sp.id, u.name from sales_person sp\r\n"
	 		+ "join users u on sp.user_id = u.id \r\n"
	 		+ "join company_user_relation cur on cur.user_id = u.id \r\n"
	 		+ "join company c on c.id = cur.company_id \r\n"
	 		+ "where c.id = ?1", nativeQuery = true)
	 Page<Object[]> findSalesPersonIdListByCompanyId(Long companyId, Pageable page);
}
