package design.boilerplate.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import design.boilerplate.springboot.security.dto.CountryDto;
import design.boilerplate.springboot.security.service.CountryService;

@CrossOrigin
@RestController
@RequestMapping("/country")
public class CountryController {
	
	@Autowired
	CountryService countryService;
	
	@GetMapping("/{countryId}")
	public ResponseEntity<CountryDto> getCountryById(@PathVariable(name = "countryId") Long id) {
		return ResponseEntity.ok(countryService.getCountryById(id));
	}

}
