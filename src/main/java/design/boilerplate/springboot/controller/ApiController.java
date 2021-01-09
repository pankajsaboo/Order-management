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

import design.boilerplate.springboot.security.dto.ApiDto;
import design.boilerplate.springboot.security.service.ApiService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ApiController {
	
	@Autowired
	ApiService apiService;

	@PostMapping("/add")
	public ResponseEntity<ApiDto> addNewApi(@RequestBody ApiDto apiDto) {	
		
		return ResponseEntity.ok(apiService.createApi(apiDto));
	}
	
	@GetMapping("/{apiName}")
	public ResponseEntity<ApiDto> getApiByName(@PathVariable(name = "apiName") String apiName) {
		
		return ResponseEntity.ok(apiService.getApiByApiName(apiName));
	}
	
	@PutMapping("/update")
	public ResponseEntity<ApiDto> updateApi(@RequestBody ApiDto apiDto) {
		return ResponseEntity.ok(apiService.updateApi(apiDto));
	}
	
	@DeleteMapping("/remove")
	public ResponseEntity<String> deleteApi(@RequestBody ApiDto apiDto) {
		 
		return ResponseEntity.ok(!apiService.deleteApi(apiDto) ? "Deleted" : "Something went wrong!");
	}

}
