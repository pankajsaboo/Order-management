package design.boilerplate.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import design.boilerplate.springboot.security.dto.CompanyTypeDto;
import design.boilerplate.springboot.security.service.CompanyTypeService;

@CrossOrigin
@RestController
@RequestMapping("/companyType")
public class CompanyTypeController {
	
	@Autowired
	CompanyTypeService companyTypeService;

	@PostMapping("/add")
	public ResponseEntity<CompanyTypeDto> addNewCompanyType(@RequestBody CompanyTypeDto companyTypeDto) {	
		
		return ResponseEntity.ok(companyTypeService.createCompanyType(companyTypeDto));
	}
	
	@GetMapping("/{companyTypeName}")
	public ResponseEntity<CompanyTypeDto> getCompanyTypeByName(@PathVariable(name = "companyTypeName") String companyTypeName) {
		return ResponseEntity.ok(companyTypeService.getCompanyTypeByCompanyTypeName(companyTypeName));
	}
	
	@GetMapping("/all/{status}")
	public ResponseEntity<List<CompanyTypeDto>> getAllByStatus(@PathVariable(name = "status") String status){
		return ResponseEntity.ok(companyTypeService.getCompanyTypesByStatus(status));
	}
	
	@PutMapping("/updateStatus")
	public ResponseEntity<CompanyTypeDto> updateCompanyType(@RequestBody CompanyTypeDto companyTypeDto) {
		return ResponseEntity.ok(companyTypeService.updateCompanyType(companyTypeDto));
	}
	
	@DeleteMapping("/remove")
	public ResponseEntity<String> deleteCompanyType(@RequestBody CompanyTypeDto companyTypeDto) {
		 
		return ResponseEntity.ok(!companyTypeService.deleteCompanyType(companyTypeDto) ? "Deleted" : "Something went wrong!");
	}

}
