package design.boilerplate.springboot.controller;

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

import design.boilerplate.springboot.model.UserWorkAreaRelation;
import design.boilerplate.springboot.security.dto.CompanyDto;
import design.boilerplate.springboot.security.dto.CompanyUserRelationDto;
import design.boilerplate.springboot.security.dto.RegistrationRequest;
import design.boilerplate.springboot.security.dto.RegistrationResponse;
import design.boilerplate.springboot.security.dto.SalesPersonDto;
import design.boilerplate.springboot.security.dto.WorkAreaMasterDto;
import design.boilerplate.springboot.security.service.TraderService;
import design.boilerplate.springboot.security.service.WorkAreaMasterService;

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
	public ResponseEntity<List<WorkAreaMasterDto>> addNewWorkAreaMasters(@RequestBody List<WorkAreaMasterDto> DtoList) {	
		
		return ResponseEntity.ok(masterService.createWorkAreaMaster(DtoList));
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
