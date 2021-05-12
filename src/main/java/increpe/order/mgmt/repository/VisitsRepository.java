package increpe.order.mgmt.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import increpe.order.mgmt.model.Visits;

public interface VisitsRepository extends CrudRepository<Visits, Long> {
	
//	List<Visits> findByCustomerSalesPersonRelationId_id(Long relationId);
//	
//	List<Visits> findByCustomerSalesPersonRelationId_SalesPersonId_id(Long salesPersonId);
//	
//	List<Visits> findByVisitDateAndCustomerSalesPersonRelationId_SalesPersonId_id(LocalDate visitDate, Long salesPersonId);
	
	String QUERY_STRING = "select cust.company_name as distributor ,sp.employee_id as employeeId, u2.\"name\" as fullName, \r\n"
			+ "sp.designation as designation, sp.headquarters as headquarters,\r\n"
			+ "vi.id as visitId, vi.\"date\" as visitDate , vi.\"time\" as visitTime, vi.dealer as dealer,\r\n"
			+ "vi.address as address, vi.live_location as liveLocation, vi.\"comment\" as visitComment \r\n"
			+ "from visits vi\r\n"
			+ "join sales_person sp on sp.id = vi.sales_person_id  \r\n"
			+ "join company cust on cust.id  = vi.company_id\r\n"
			+ "join users u2 on u2.id = sp.user_id \r\n"
			+ "join company_user_relation cur on cur.user_id = u2.id \r\n"
			+ "join company c on c.id = cur.company_id \r\n"
			+ "where c.id = ?1";

	String COUNT_STRING = "select count(sp.employee_id) as pageTotal\r\n"
			+ "from visits vi\r\n"
			+ "join sales_person sp on sp.id = vi.sales_person_id  \r\n"
			+ "join company cust on cust.id  = vi.company_id\r\n"
			+ "join users u2 on u2.id = sp.user_id \r\n"
			+ "join company_user_relation cur on cur.user_id = u2.id \r\n"
			+ "join company c on c.id = cur.company_id \r\n"
			+ "where c.id = ?1";

	String USER_QUERY = QUERY_STRING + " and sp.id = ?2 order by vi.\"date\" desc";
	String USER_COUNT = COUNT_STRING + " and sp.id = ?2";

	String DATE_QUERY = QUERY_STRING + " and to_char(vi.\"date\", 'YYYY-MM-DD') = ?2";
	String DATE_COUNT = COUNT_STRING + " and to_char(vi.\"date\", 'YYYY-MM-DD') = ?2";
	
	String USER_AND_DATE_QUERY = QUERY_STRING + " and sp.id = ?2 and to_char(vi.\"date\", 'YYYY-MM-DD') = ?3";
	String USER_AND_DATE_COUNT = COUNT_STRING + " and sp.id = ?2 and to_char(vi.\"date\", 'YYYY-MM-DD') = ?3";

	String MONTH_QUERY = QUERY_STRING + " and to_char(vi.\"date\", 'MONTH YYYY') like ?2 order by vi.\"date\" desc";
	String MONTH_COUNT = COUNT_STRING + " and to_char(vi.\"date\", 'MONTH YYYY') like ?2";
	
	@Query(value = USER_QUERY, nativeQuery = true, countQuery = USER_COUNT)
	Page<Record> findVisitsReportByUser(Long companyId, Long spId, Pageable page);
	
	@Query(value = DATE_QUERY, nativeQuery = true, countQuery = DATE_COUNT)
	Page<Record> findVisitsReportByDate(Long companyId, String date, Pageable page);
	
	@Query(value = USER_AND_DATE_QUERY, nativeQuery = true, countQuery = USER_AND_DATE_COUNT)
	Page<Record> findVisitsReportByUserAndDate(Long companyId, Long spId, String date, Pageable page);
	
	@Query(value = MONTH_QUERY, nativeQuery = true, countQuery = MONTH_COUNT)
	Page<Record> findVisitsReportByMonthYear(Long companyId, String monthYear, Pageable page);

}
