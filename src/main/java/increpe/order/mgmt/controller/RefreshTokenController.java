package increpe.order.mgmt.controller;

import java.util.Objects;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import increpe.order.mgmt.security.dto.AuthenticatedUserDto;
import increpe.order.mgmt.security.dto.LoginResponse;
import increpe.order.mgmt.security.dto.RequestObject;
import increpe.order.mgmt.security.jwt.JwtTokenManager;
import increpe.order.mgmt.security.jwt.JwtTokenService;
import increpe.order.mgmt.security.service.UserService;
import lombok.RequiredArgsConstructor;

import static increpe.order.mgmt.security.utils.SecurityConstants.*;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/refresh")
public class RefreshTokenController {
	
	private final JwtTokenManager jwtTokenManager;
	private final JwtTokenService jwtTokenService;
	private final UserService userService;
	
	@GetMapping
	public ResponseEntity<LoginResponse> getRefreshedToken(@RequestParam Long id) {
		
		AuthenticatedUserDto userDto = userService.findAuthenticatedUser(id);
		
		if(!Objects.isNull(userDto) && userDto.getRefreshToken().equals(REFRESH_TOKEN)) {
			
			return ResponseEntity.ok(new LoginResponse(jwtTokenManager.generateToken(userDto), "Token Refreshed", HttpStatus.ACCEPTED));
		}
		
		return ResponseEntity.ok(null);
		
	}

}
