package design.boilerplate.springboot.controller;

import design.boilerplate.springboot.security.dto.RegistrationRequest;
import design.boilerplate.springboot.security.dto.RegistrationResponse;
import design.boilerplate.springboot.security.service.RegistrationService;
import design.boilerplate.springboot.security.service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created on Ağustos, 2020
 *
 * @author Faruk
 */
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/register")
public class RegistrationController {

	@Autowired
	RegistrationService registrationService;

	@PostMapping("/customer")
	public ResponseEntity<RegistrationResponse> registerCustomer(@RequestBody RegistrationRequest registrationRequest) {

		final RegistrationResponse registrationResponse = registrationService.registerCustomer(registrationRequest);

		return ResponseEntity.status(HttpStatus.CREATED).body(registrationResponse);
	}
	
	@PostMapping("/trader")
	public ResponseEntity<RegistrationResponse> registerBuyer(@RequestBody RegistrationRequest registrationRequest) {

		final RegistrationResponse registrationResponse = registrationService.registerBuyer(registrationRequest);

		return ResponseEntity.status(HttpStatus.CREATED).body(registrationResponse);
	}

}
