package increpe.order.mgmt.security.jwt;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import increpe.order.mgmt.model.User;
import increpe.order.mgmt.security.dto.AuthenticatedUserDto;
import increpe.order.mgmt.security.dto.LoginRequest;
import increpe.order.mgmt.security.dto.LoginResponse;
import increpe.order.mgmt.security.mapper.UserMapper;
import increpe.order.mgmt.security.service.UserService;

/**
 * 
 *
 * 
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class JwtTokenService {

	private final UserService userService;

	private final JwtTokenManager jwtTokenManager;

	private final AuthenticationManager authenticationManager;

	public LoginResponse getLoginResponse(LoginRequest loginRequest) {

		final String username = loginRequest.getUsername();
		final String password = loginRequest.getPassword();

//		final UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(username, password);
//		authenticationManager.authenticate(usernamePasswordAuthenticationToken);

		final AuthenticatedUserDto authenticatedUserDto = userService.findAuthenticatedUserByUsername(username);
		
		if(authenticatedUserDto == null) {
			throw new BadCredentialsException("User does not exists");
		}
		if(!authenticatedUserDto.getPassword().equalsIgnoreCase(password)) {
			throw new BadCredentialsException("Invalid password");
		}

		final String token = jwtTokenManager.generateToken(authenticatedUserDto);

		log.info(" {} has successfully logged in!", authenticatedUserDto.getUsername());

		return new LoginResponse(token, "login successful", HttpStatus.ACCEPTED);
	}

}
