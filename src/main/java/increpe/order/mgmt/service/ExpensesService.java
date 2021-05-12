package increpe.order.mgmt.service;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import increpe.order.mgmt.model.Company;
import increpe.order.mgmt.model.Expenses;
import increpe.order.mgmt.model.SalesPerson;
import increpe.order.mgmt.repository.ExpensesRepository;
import increpe.order.mgmt.repository.ExpensesSummary;
import increpe.order.mgmt.security.dto.RegistrationResponse;
import increpe.order.mgmt.security.dto.RequestObject;
import increpe.order.mgmt.security.dto.SalesPersonDto;
import increpe.order.mgmt.security.mapper.CompanyMapper;
import increpe.order.mgmt.sp.dto.ExpenseReportsDTO;
import increpe.order.mgmt.sp.dto.ExpensesDto;
import increpe.order.mgmt.sp.dto.PageResultObject;
import increpe.order.mgmt.sp.dto.VisitsReportsDTO;
import net.bytebuddy.build.Plugin.Engine.Summary;

@Service
public class ExpensesService {

	@Autowired
	ExpensesRepository expensesRepository;
	
	@Autowired
	SalesPersonService salesPersonService;
	
	public ExpensesDto getExpense(Long expenseId) {

		return CompanyMapper.INSTANCE.convertToExpensesDto(expensesRepository.findById(expenseId).get());
	}

	public RegistrationResponse createNewExpense(ExpensesDto eDto) {

		expensesRepository.save(CompanyMapper.INSTANCE.convertToExpenses(eDto));

		return new RegistrationResponse("Expense added successfully!");
	}

	public List<ExpensesSummary> findExpenseSummaryByCompany(Long companyId) {
		
		List<Object[]> objList = salesPersonService.getSalesPersonIdList(companyId);
		
		List<ExpensesSummary> resultList = new ArrayList<>();
		
		for (Iterator iterator = objList.iterator(); iterator.hasNext();) {
			
			Object[] objects = (Object[]) iterator.next();
			resultList.addAll(findExpenseSummaryByUser(((BigInteger)objects[0]).longValue()));
		}
		
		return resultList;
		
	}
	
	public List<ExpensesSummary> findExpenseSummaryByUser(Long salesPersonId) {
		SalesPerson sp = new SalesPerson();
		sp.setId(salesPersonId);
		return expensesRepository.findExpenseSummaryByMonthYear(sp);
	}
	
	public RegistrationResponse updateExpense(ExpensesDto eDto) {

		expensesRepository.save(CompanyMapper.INSTANCE.convertToExpenses(eDto));

		return new RegistrationResponse("Expense Updated successfully!");
	}

	public boolean deleteExpense(Long expenseId) {

		expensesRepository.deleteById(expenseId);

		return expensesRepository.existsById(expenseId);
	}

	//Will be removed...
	public List<ExpensesDto> getExpensesForMonth(String monthYear, Long salesPersonId) {

		int year = Integer.parseInt(monthYear.split("-")[1].trim());

		Month month = Month.valueOf(monthYear.split("-")[0].trim().toUpperCase());

		LocalDate startDate = LocalDate.of(year, month, 1);

		LocalDate endDate = LocalDate.of(year, month, startDate.lengthOfMonth());

		return CompanyMapper.INSTANCE.convertToExpensesDtoList(
				expensesRepository.findByExpenseDateBetweenAndSalesPersonId_id(startDate, endDate, salesPersonId));
	}
	
	
	public PageResultObject<ExpenseReportsDTO> findExpenseReportsByUserAndMonthYear(RequestObject req) {

		Pageable pageFilter = PageRequest.of(req.getPage(), req.getSize());

		String formattedMonthYear = req.getMonthYear().split("-")[0].toUpperCase() + "%" + req.getMonthYear().split("-")[1];
		Page resultPage = expensesRepository.findExpenseReportByUserAndMonthYear(req.getCompanyId(), req.getUserId(), formattedMonthYear, pageFilter);

		@SuppressWarnings("unchecked")
		List<Object[]> recordList = resultPage.getContent();

		List<ExpenseReportsDTO> resultList = recordList.stream()
				.map(t -> new ExpenseReportsDTO(t[0], t[1], t[2], t[3], t[4], t[5], t[6], t[7], t[8], t[9]))
				.collect(Collectors.toList());

		return new PageResultObject<ExpenseReportsDTO>(resultList, resultPage.getPageable(),
				resultPage.getTotalElements(), resultPage.getTotalPages());

	}
}
