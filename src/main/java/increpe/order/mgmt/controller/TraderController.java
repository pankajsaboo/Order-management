package increpe.order.mgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import increpe.order.mgmt.model.UserWorkAreaRelation;
import increpe.order.mgmt.security.dto.CompanyUserRelationDto;
import increpe.order.mgmt.security.dto.RegistrationRequest;
import increpe.order.mgmt.security.dto.RegistrationResponse;
import increpe.order.mgmt.security.dto.WorkAreaMasterDto;
import increpe.order.mgmt.service.TraderService;
import increpe.order.mgmt.service.WorkAreaMasterService;

@CrossOrigin
@RestController
@RequestMapping("/trader")
public class TraderController {

	@Autowired
	TraderService traderService;
	
	@Autowired
	WorkAreaMasterService masterService;
	
	@PostMapping("/sales-person/add")
	public ResponseEntity<RegistrationResponse> addNewCompany(@RequestBody RegistrationRequest request) {	
		
		return ResponseEntity.ok(traderService.createNewSalesPersonAccount(request));
	}
	
	@GetMapping("/sales-person/{companyId}")
	public ResponseEntity<List<CompanyUserRelationDto>> getAllSalsePersonAccountList(@PathVariable(name = "companyId") Long id) {
		
		return ResponseEntity.ok(traderService.getAllSalesPersonAccountList(id));
	}
	
	@PostMapping("/masters/add")
	public ResponseEntity<WorkAreaMasterDto> addNewWorkAreaMasters(@RequestBody WorkAreaMasterDto listDto) {	
		
		return ResponseEntity.ok(masterService.createWorkAreaMaster(listDto));
	}
	
	@GetMapping("/masters/{companyId}")
	public ResponseEntity<List<WorkAreaMasterDto>> getWorkAreaMasterList(@PathVariable(name = "companyId") Long id) {
		
		return ResponseEntity.ok(masterService.getWorkAreaMasterByCompany(id));
	}
	
	@GetMapping("/getMapping/{userId}")
	public ResponseEntity<List<UserWorkAreaRelation>> getWorkAreaMappingList(@PathVariable(name = "userId") Long id) {
		
		return ResponseEntity.ok(traderService.getMapping(id));
	}
}
