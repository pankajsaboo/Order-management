package increpe.order.mgmt.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import increpe.order.mgmt.model.Expenses;
import increpe.order.mgmt.model.SalesPerson;

public interface ExpensesRepository extends CrudRepository<Expenses, Long> {
	
	List<Expenses> findByExpenseDateBetweenAndSalesPersonId_id(LocalDate startDate, LocalDate endDate, Long salesPersonId);
	
	List<Expenses> findBySalesPersonId_id(Long salesPersonId);
	
	List<Expenses> findByExpenseDate(LocalDate expenseDate);
	
	String QUERY_STRING = "select sp.employee_id  as employeeId, u.\"name\" fullName, sp.designation as designation, \r\n"
			+ "sp.headquarters as headquarters, e.id as expenseId, \r\n"
			+ "e.area_worked as areaWorked, e.expense_date as expenseDate, e.expense_category as expenseType,\r\n"
			+ "e.expense_amount as expenseAmount, e.remark as remark\r\n"
			+ "from expenses e \r\n"
			+ "join sales_person sp on sp.id = e.sales_person_id\r\n"
			+ "join users u on sp.user_id = u.id \r\n"
			+ "join company_user_relation cur on cur.user_id = u.id \r\n"
			+ "join company c on c.id = cur.company_id \r\n"
			+ "where c.id = ?1";

	String COUNT_STRING = "select count(sp.employee_id) as pageTotal\r\n"
			+ "from expenses e \r\n"
			+ "join sales_person sp on sp.id = e.sales_person_id\r\n"
			+ "join users u on sp.user_id = u.id \r\n"
			+ "join company_user_relation cur on cur.user_id = u.id \r\n"
			+ "join company c on c.id = cur.company_id \r\n"
			+ "where c.id = ?1";
	
	String USER_QUERY = QUERY_STRING + " and sp.id = ?2 order by e.expense_date desc";
	String USER_COUNT = COUNT_STRING + " and sp.id = ?2";

	String DATE_QUERY = QUERY_STRING + " and to_char(e.expense_date, 'YYYY-MM-DD') = ?2";
	String DATE_COUNT = COUNT_STRING + " and to_char(e.expense_date, 'YYYY-MM-DD') = ?2";
	
	String USER_AND_MONTH_QUERY = QUERY_STRING + " and sp.id = ?2 and to_char(e.expense_date, 'MONTH YYYY') like ?3";
	String USER_AND_MONTH_COUNT = COUNT_STRING + " and sp.id = ?2 and to_char(e.expense_date, 'MONTH YYYY') like ?3";

	String MONTH_QUERY = QUERY_STRING + " and to_char(e.expense_date, 'MONTH YYYY') like ?2 order by e.expense_date desc";
	String MONTH_COUNT = COUNT_STRING + " and to_char(e.expense_date, 'MONTH YYYY') like ?2";
	
	@Query(value = USER_QUERY, nativeQuery = true, countQuery = USER_COUNT)
	Page<Record> findExpenseReportByUser(Long companyId, Long spId, Pageable page);
	
	@Query(value = DATE_QUERY, nativeQuery = true, countQuery = DATE_COUNT)
	Page<Record> findExpenseReportByDate(Long companyId, String date, Pageable page);
	
	@Query(value = USER_AND_MONTH_QUERY, nativeQuery = true, countQuery = USER_AND_MONTH_COUNT)
	Page<Record> findExpenseReportByUserAndMonthYear(Long companyId, Long spId, String monthYear, Pageable page);
	
	@Query(value = MONTH_QUERY, nativeQuery = true, countQuery = MONTH_COUNT)
	Page<Record> findExpenseReportByMonthYear(Long companyId, String monthYear, Pageable page);
		
	@Query("SELECT TO_CHAR(e.expenseDate, 'MONTH-YYYY') as monthYear, SUM(e.expenseAmount) as monthlySummary,"
			+" e.salesPersonId.employeeId as employeeId, e.salesPersonId.userId.name as fullName,"
			+" e.salesPersonId.designation as designation, e.salesPersonId.headquarters as headquarters"
			+" FROM expenses e WHERE e.salesPersonId = :salesPersonId "
			+"GROUP BY TO_CHAR(e.expenseDate, 'MONTH-YYYY'), e.salesPersonId.employeeId, e.salesPersonId.userId.name,"
			+"e.salesPersonId.designation, e.salesPersonId.headquarters")
	List<ExpensesSummary> findExpenseSummaryByMonthYear(@Param("salesPersonId") SalesPerson salesPersonId);

}
