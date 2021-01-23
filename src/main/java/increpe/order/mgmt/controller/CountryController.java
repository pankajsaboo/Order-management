package increpe.order.mgmt.controller;

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

import increpe.order.mgmt.security.dto.CountryDto;
import increpe.order.mgmt.service.CountryService;

@CrossOrigin
@RestController
@RequestMapping("/country")
public class CountryController {
	
	@Autowired
	CountryService countryService;
	
	@PostMapping("/add")
	public ResponseEntity<CountryDto> addNewCountryType(@RequestBody CountryDto countryDto) {	
		
		return ResponseEntity.ok(countryService.createCountry(countryDto));
	}
	
	@GetMapping("/name")
	public ResponseEntity<CountryDto> getCountryByName(@RequestParam(name = "id") String countryName) {
		
		return ResponseEntity.ok(countryService.getCountryByCountryName(countryName));
	}

	@GetMapping("/code")
	public ResponseEntity<CountryDto> getCountryByCode(@RequestParam(name = "id") String countryCode) {
		
		return ResponseEntity.ok(countryService.getCountryByCountryCode(countryCode));
	}
	
	@PutMapping("/updateStatus")
	public ResponseEntity<CountryDto> updateCountry(@RequestBody CountryDto countryDto) {
		
		return ResponseEntity.ok(countryService.updateCountry(countryDto));
	}
	
	@DeleteMapping("/remove")
	public ResponseEntity<String> deleteCountry(@RequestBody CountryDto countryDto) {
		 
		return ResponseEntity.ok(!countryService.deleteCountry(countryDto) ? "Deleted" : "Something went wrong!");
	}

}
