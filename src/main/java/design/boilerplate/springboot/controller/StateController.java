package design.boilerplate.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import design.boilerplate.springboot.security.dto.StateDto;
import design.boilerplate.springboot.security.service.StateService;


@CrossOrigin
@RestController
@RequestMapping("/state")
public class StateController {
	
	@Autowired
	StateService stateService;
	
	@GetMapping("/{stateId}")
	public ResponseEntity<StateDto> getStateById(@PathVariable(name = "stateId") Long id) {
		return ResponseEntity.ok(stateService.getStateById(id));
	}

}

