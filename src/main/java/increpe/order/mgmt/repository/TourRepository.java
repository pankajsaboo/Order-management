package increpe.order.mgmt.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import increpe.order.mgmt.model.Tour;

public interface TourRepository extends CrudRepository<Tour, Long> {

	String QUERY_STRING = "select sp.employee_id as employeeId, u.\"name\" fullName, sp.designation as designation, \r\n"
			+ "sp.headquarters as headquarters, tou.id as tourId, tou.from_location as fromLocation,\r\n"
			+ "tou.\"location\" as toLocation, tou.start_date as startDate, tou.end_date as endDate,\r\n"
			+ "tou.tour_details as tourDetails, tou.status as status, tou.status_remark as statusRemark\r\n"
			+ "from tour tou\r\n"
			+ "join sales_person sp on sp.id = tou.sales_person_id\r\n"
			+ "join users u on sp.user_id = u.id \r\n"
			+ "join company_user_relation cur on cur.user_id = u.id \r\n"
			+ "join company c on c.id = cur.company_id \r\n"
			+ "where c.id = ?1";

	String COUNT_STRING = "select count(sp.employee_id) as pageTotal\r\n"
			+ "from tour tou\r\n"
			+ "join sales_person sp on sp.id = tou.sales_person_id\r\n"
			+ "join users u on sp.user_id = u.id \r\n"
			+ "join company_user_relation cur on cur.user_id = u.id \r\n"
			+ "join company c on c.id = cur.company_id \r\n"
			+ "where c.id = ?1";

	String USER_QUERY = QUERY_STRING + " and sp.id = ?2 order by tou.start_date desc";
	String USER_COUNT = COUNT_STRING + " and sp.id = ?2";

	String DATE_QUERY = QUERY_STRING + " and to_char(tou.start_date, 'YYYY-MM-DD') = ?2";
	String DATE_COUNT = COUNT_STRING + " and to_char(tou.start_date, 'YYYY-MM-DD') = ?2";

	String MONTH_QUERY = QUERY_STRING + " and to_char(tou.start_date, 'MONTH YYYY') like ?2 order by tou.start_date desc";
	String MONTH_COUNT = COUNT_STRING + " and to_char(tou.start_date, 'MONTH YYYY') like ?2";
	
	@Query(value = USER_QUERY, nativeQuery = true, countQuery = USER_COUNT)
	Page<Record> findTourReportByUser(Long companyId, Long spId, Pageable page);
	
	@Query(value = DATE_QUERY, nativeQuery = true, countQuery = DATE_COUNT)
	Page<Record> findTourReportByDate(Long companyId, String date, Pageable page);
	
	@Query(value = MONTH_QUERY, nativeQuery = true, countQuery = MONTH_COUNT)
	Page<Record> findTourReportByMonthYear(Long companyId, String monthYear, Pageable page);

	List<Tour> findBySalesPersonId_id(Long salesPersonId);
}
