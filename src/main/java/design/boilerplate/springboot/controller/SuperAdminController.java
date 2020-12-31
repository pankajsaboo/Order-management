package design.boilerplate.springboot.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import design.boilerplate.springboot.security.dto.TraderDto;

@CrossOrigin
@RestController
@RequestMapping("/sa")
public class SuperAdminController {
	
	@GetMapping("/trader/view")
	public ResponseEntity<String> getAllTraders(){
		
		return ResponseEntity.ok("List of all traders");
	}
	
	@PostMapping("/trader/create")
	public ResponseEntity<TraderDto> addNewTrader(@RequestBody TraderDto traderDto){
		return ResponseEntity.ok(new TraderDto());
	}
	
	@PutMapping("/trader/update")
	public ResponseEntity<TraderDto> updateTrader(@RequestBody TraderDto traderDto) {
		return ResponseEntity.ok(new TraderDto());
	}

}
