package design.boilerplate.springboot.security.service;

import design.boilerplate.springboot.security.dto.AuthenticatedUserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Objects;

/**
 * Created on Ağustos, 2020
 *
 * @author Faruk
 */
@Slf4j
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private static final String USERNAME_OR_PASSWORD_INVALID = "Invalid username or password.";

	@Autowired
	private UserService userService;


	@Override
	public UserDetails loadUserByUsername(String username) {

		final AuthenticatedUserDto authenticatedUser = userService.findAuthenticatedUserByUsername(username);

		if (Objects.isNull(authenticatedUser)) {
			throw new UsernameNotFoundException(USERNAME_OR_PASSWORD_INVALID);
		}

		final String authenticatedUsername = authenticatedUser.getUsername();
		final String authenticatedPassword = authenticatedUser.getPassword();
		final String userRole = authenticatedUser.getUserRole().getTitle();
		final SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(userRole);

		return new User(authenticatedUsername, authenticatedPassword, Collections.singletonList(grantedAuthority));
	}
}
