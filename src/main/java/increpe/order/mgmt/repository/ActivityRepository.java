package increpe.order.mgmt.repository;

import java.util.List;

import javax.persistence.Tuple;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Page;
import increpe.order.mgmt.sp.dto.ActivityReportsDTO;

import increpe.order.mgmt.model.Activity;

public interface ActivityRepository extends CrudRepository<Activity, Long> {
	
	String QUERY_STRING = "select sp.employee_id as employeeId, u.\"name\" as fullName, sp.headquarters as headquarters, "
							+ "sp.designation as designation, am.activity_type_name as activityTypeName,\r\n"
							+ "a.id as activityId, a.quantity as quantity, a.activity_date as activityDate, a.note as note, a.status as status,"
							+ "a.status_remark as statusRemark \r\n"
							+ "from activity a \r\n"
							+ "join activity_master am on a.activity_master_id = am.id\r\n"
							+ "join sales_person sp on sp.id = a.sales_person_id \r\n"
							+ "join users u on sp.user_id = u.id \r\n"
							+ "join company_user_relation cur on cur.user_id = u.id \r\n"
							+ "join company c on c.id = cur.company_id \r\n"
							+ "where c.id = ?1";
	
	String COUNT_STRING = "select count(sp.employee_id) as pageTotal\r\n"
							+ "from activity a\r\n"
							+ "join activity_master am on a.activity_master_id = am.id\r\n"
							+ "join sales_person sp on sp.id = a.sales_person_id\r\n"
							+ "join users u on sp.user_id = u.id\r\n"
							+ "join company_user_relation cur on cur.user_id = u.id\r\n"
							+ "join company c on c.id = cur.company_id\r\n"
							+ "where c.id = ?1";
	
	String USER_QUERY = QUERY_STRING + " and sp.id = ?2 order by a.activity_date desc";
	String USER_COUNT = COUNT_STRING + " and sp.id = ?2";
	
	String DATE_QUERY = QUERY_STRING + " and to_char(a.activity_date, 'YYYY-MM-DD') = ?2";
	String DATE_COUNT = COUNT_STRING + " and to_char(a.activity_date, 'YYYY-MM-DD') = ?2";
	
	String MONTH_QUERY =  QUERY_STRING + " and to_char(a.activity_date, 'MONTH YYYY') like ?2 order by a.activity_date desc";
	String MONTH_COUNT =  COUNT_STRING + " and to_char(a.activity_date, 'MONTH YYYY') like ?2";
	
	
	List<Activity> findBySalesPersonId_id(Long salesPersonId);
	
	@Query(value = "select sp.employee_id as employeeId, u.\"name\" as fullName, sp.headquarters as headquarters, "
			+ "am.activity_type_name as activityTypeName,\r\n"
			+ "a.quantity as quantity, a.activity_date as activityDate, a.note as note, a.status as status,"
			+ "a.status_remark as statusRemark \r\n"
			+ "from activity a \r\n"
			+ "join activity_master am on a.activity_master_id = am.id\r\n"
			+ "join sales_person sp on sp.id = a.sales_person_id \r\n"
			+ "join users u on sp.user_id = u.id \r\n"
			+ "join company_user_relation cur on cur.user_id = u.id \r\n"
			+ "join company c on c.id = cur.company_id \r\n"
			+ "where c.id = ?1",nativeQuery = true,countQuery = "select count(sp.employee_id) as pageTotal\r\n"
							+ "from activity a\r\n"
							+ "join activity_master am on a.activity_master_id = am.id\r\n"
							+ "join sales_person sp on sp.id = a.sales_person_id\r\n"
							+ "join users u on sp.user_id = u.id\r\n"
							+ "join company_user_relation cur on cur.user_id = u.id\r\n"
							+ "join company c on c.id = cur.company_id\r\n"
							+ "where c.id = ?1")
	Page<Object[]> findActivityReport(Long companyId, Pageable page);
	
	@Query(value = USER_QUERY, nativeQuery = true, countQuery = USER_COUNT)
	Page<Object[]> findActivityReportByUser(Long companyId, Long spId, Pageable page);
	
	@Query(value = DATE_QUERY, nativeQuery = true, countQuery = DATE_COUNT)
	Page<Object[]> findActivityReportByDate(Long companyId, String date, Pageable page);
	
	@Query(value = MONTH_QUERY, nativeQuery = true, countQuery = MONTH_COUNT)
	Page<Object[]> findActivityReportByMonthYear(Long companyId, String monthYear, Pageable page);
}
