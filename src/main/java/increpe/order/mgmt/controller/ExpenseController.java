package increpe.order.mgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import increpe.order.mgmt.repository.ExpensesSummary;
import increpe.order.mgmt.security.dto.RegistrationResponse;
import increpe.order.mgmt.security.dto.RequestObject;
import increpe.order.mgmt.service.ExpensesService;
import increpe.order.mgmt.sp.dto.ExpenseReportsDTO;
import increpe.order.mgmt.sp.dto.ExpensesDto;
import increpe.order.mgmt.sp.dto.PageResultObject;

@CrossOrigin
@RestController
@RequestMapping("/expense")
public class ExpenseController {
	
	@Autowired
	ExpensesService expenseService;
	
	@PostMapping("")
	public ResponseEntity<ExpensesDto> getExpenseById(@RequestBody RequestObject req) {
		
		return ResponseEntity.ok(expenseService.getExpense(req.getId()));
	}

	@GetMapping("/reports/summary")
	public ResponseEntity<List<ExpensesSummary>> getExpenseSummaryByCompany(@RequestParam(name = "id") Long companyId) {

		return ResponseEntity.ok(expenseService.findExpenseSummaryByCompany(companyId));
	}
	
	@GetMapping("/summary/user")
	public ResponseEntity<List<ExpensesSummary>> getExpenseSummaryByUser(@RequestParam(name = "id") Long salesPersonId) {

		return ResponseEntity.ok(expenseService.findExpenseSummaryByUser(salesPersonId));
	}

	@PostMapping("/reports")
	public ResponseEntity<PageResultObject<ExpenseReportsDTO>> getExpenseBetween(@RequestBody RequestObject req) {

		return ResponseEntity.ok(expenseService.findExpenseReportsByUserAndMonthYear(req));
	}
	
	@PostMapping("/add")
	public ResponseEntity<RegistrationResponse> createNewExpense(@RequestBody ExpensesDto eDto) {

		return ResponseEntity.ok(expenseService.createNewExpense(eDto));
	}

	@PutMapping("/update")
	public ResponseEntity<RegistrationResponse> updateExpenseRecord(@RequestBody ExpensesDto eDto) {

		return ResponseEntity.ok(expenseService.updateExpense(eDto));
	}

	@DeleteMapping("/delete")
	public ResponseEntity<Boolean> deleteExpenseRecord(@RequestParam(name = "eId") Long id) {

		return ResponseEntity.ok(expenseService.deleteExpense(id));
	}

}
