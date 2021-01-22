package design.boilerplate.springboot.controller;

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

import design.boilerplate.springboot.security.dto.CompanyDto;
import design.boilerplate.springboot.security.dto.CompanyTypeRelationDto;
import design.boilerplate.springboot.security.service.CompanyService;
import design.boilerplate.springboot.security.service.CompanyTypeRelationService;

@CrossOrigin
@RestController
@RequestMapping("/company")
public class CompanyController {
	
	@Autowired
	CompanyService companyService;
	
	@Autowired
	CompanyTypeRelationService companyTypeRelationService;

	@PostMapping("/add")
	public ResponseEntity<CompanyDto> addNewCompany(@RequestBody CompanyDto companyDto) {	
		
		return ResponseEntity.ok(companyService.createCompany(companyDto));
	}
	
	@PostMapping("/relate")
	public ResponseEntity<CompanyTypeRelationDto> addNewCompanyRelation(@RequestBody CompanyTypeRelationDto companyTypeRelationDto) {	
		
		return ResponseEntity.ok(companyTypeRelationService.createCompanyToCompanyTypeRelation(companyTypeRelationDto));
	}
	
	@GetMapping("/{companyName}")
	public ResponseEntity<CompanyDto> getCompanyByName(@PathVariable(name = "companyName") String companyName) {
		
		return ResponseEntity.ok(companyService.getCompanyByCompanyName(companyName));
	}
	
	@PutMapping("/update")
	public ResponseEntity<CompanyDto> updateCompany(@RequestBody CompanyDto companyDto) {
		return ResponseEntity.ok(companyService.updateCompany(companyDto));
	}
	
	@DeleteMapping("/remove")
	public ResponseEntity<String> deleteCompany(@RequestBody CompanyDto companyDto) {
		 
		return ResponseEntity.ok(!companyService.deleteCompany(companyDto) ? "Deleted" : "Something went wrong!");
	}

}
