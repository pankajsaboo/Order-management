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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import design.boilerplate.springboot.model.AddressType;
import design.boilerplate.springboot.security.dto.AddressTypeDto;
import design.boilerplate.springboot.security.dto.CityDto;
import design.boilerplate.springboot.security.service.CityService;

@CrossOrigin
@RestController
@RequestMapping("/city")
public class CityController {
	
	@Autowired
	CityService cityService;
	
	@PostMapping("/add")
	public ResponseEntity<CityDto> addNewCityType(@RequestBody CityDto cityDto) {	
		
		return ResponseEntity.ok(cityService.createCity(cityDto));
	}
	
	@GetMapping("/name")
	public ResponseEntity<CityDto> getCityByName(@RequestParam(name = "id") String cityName) {
		
		return ResponseEntity.ok(cityService.getCityByCityName(cityName));
	}

	@GetMapping("/code")
	public ResponseEntity<CityDto> getCityByCode(@RequestParam(name = "id") String cityCode) {
		
		return ResponseEntity.ok(cityService.getCityByCityCode(cityCode));
	}
	
	@PutMapping("/updateStatus")
	public ResponseEntity<CityDto> updateCity(@RequestBody CityDto cityDto) {
		
		return ResponseEntity.ok(cityService.updateCity(cityDto));
	}
	
	@DeleteMapping("/remove")
	public ResponseEntity<String> deleteCity(@RequestBody CityDto cityDto) {
		 
		return ResponseEntity.ok(!cityService.deleteCity(cityDto) ? "Deleted" : "Something went wrong!");
	}
}
