package design.boilerplate.springboot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/company")
public class CompanyController {
	
	@GetMapping("/details")
	public ResponseEntity<String> getCompanyDetails(@RequestBody Long companyId) {
		
		return ResponseEntity.ok("Reply from server!");
	}

}
