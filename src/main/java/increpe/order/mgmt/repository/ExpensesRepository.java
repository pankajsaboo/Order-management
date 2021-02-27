package increpe.order.mgmt.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import increpe.order.mgmt.model.Expenses;
import increpe.order.mgmt.model.SalesPerson;

public interface ExpensesRepository extends CrudRepository<Expenses, Long> {
	
	List<Expenses> findByExpenseDateBetweenAndSalesPersonId_id(LocalDate startDate, LocalDate endDate, Long salesPersonId);
	
	List<Expenses> findBySalesPersonId_id(Long salesPersonId);
	
	@Query("SELECT TO_CHAR(e.expenseDate, 'MONTH-YYYY') as monthYear, SUM(e.expenseAmount) as monthlySummary"
			+" FROM expenses e WHERE e.salesPersonId = :salesPersonId GROUP BY TO_CHAR(e.expenseDate, 'MONTH-YYYY')"
	)
	List<ExpensesSummary> findExpenseSummaryByMonthYear(@Param("salesPersonId") SalesPerson salesPersonId);

}
