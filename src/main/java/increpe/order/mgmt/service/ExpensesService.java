package increpe.order.mgmt.service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import increpe.order.mgmt.model.Company;
import increpe.order.mgmt.model.SalesPerson;
import increpe.order.mgmt.repository.ExpensesRepository;
import increpe.order.mgmt.repository.ExpensesSummary;
import increpe.order.mgmt.security.dto.RegistrationResponse;
import increpe.order.mgmt.security.dto.SalesPersonDto;
import increpe.order.mgmt.security.mapper.CompanyMapper;
import increpe.order.mgmt.sp.dto.ExpensesDto;

@Service
public class ExpensesService {
	
	@Autowired
	ExpensesRepository expensesRepository;
	
	public RegistrationResponse createNewExpense(ExpensesDto eDto) {
		
		expensesRepository.save(CompanyMapper.INSTANCE.convertToExpenses(eDto));
		
		return new RegistrationResponse("Expense added successfully!");
	}
	
	public List<ExpensesSummary> getExpenseSummary(Long salesPersonId) {
		
		SalesPerson salesPerson = new SalesPerson();
		salesPerson.setId(salesPersonId);
		
		return expensesRepository.findExpenseSummaryByMonthYear(salesPerson);
	}
	
	public List<ExpensesDto> getExpensesForMonth(String monthYear, Long salesPersonId) {
		
		int year = Integer.parseInt(monthYear.split("-")[1].trim());
		
		Month month = Month.valueOf(monthYear.split("-")[0].trim());
		
		LocalDate startDate = LocalDate.of(year,month,1);
		
		LocalDate endDate = LocalDate.of(year,month,startDate.lengthOfMonth());
		
		return CompanyMapper.INSTANCE.convertToExpensesDtoList(
					expensesRepository.findByExpenseDateBetweenAndSalesPersonId_id(startDate, endDate, salesPersonId));
	}
	
	public ExpensesDto getExpense(Long expenseId) {
		
		return CompanyMapper.INSTANCE.convertToExpensesDto(expensesRepository.findById(expenseId).get());
	}
	
	public RegistrationResponse updateExpense(ExpensesDto eDto) {
		
		expensesRepository.save(CompanyMapper.INSTANCE.convertToExpenses(eDto));
		
		return new RegistrationResponse("Expense Updated successfully!");
	}

}
