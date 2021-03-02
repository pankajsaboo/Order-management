package increpe.order.mgmt.security.jwt;

import static increpe.order.mgmt.security.utils.SecurityConstants.HEADER_STRING;
import static increpe.order.mgmt.security.utils.SecurityConstants.LOGIN_REQUEST_URI;
import static increpe.order.mgmt.security.utils.SecurityConstants.REGISTRATION_REQUEST_URI;
import static increpe.order.mgmt.security.utils.SecurityConstants.SUPER_ADMIN_URI;
import static increpe.order.mgmt.security.utils.SecurityConstants.TOKEN_PREFIX;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import increpe.order.mgmt.model.CompanyUserRelation;
import increpe.order.mgmt.security.service.UserService;
import increpe.order.mgmt.service.CompanyUserRelationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Created on Ağustos, 2020
 *
 * @author Faruk
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	private final JwtTokenManager jwtTokenManager;

	private final UserDetailsService userDetailsService;
	
	private final CompanyUserRelationService userRelationService;
	
	private final UserService userService;

	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {

		final String requestURI = req.getRequestURI();

		if (requestURI.contains(LOGIN_REQUEST_URI) || 
				requestURI.contains(REGISTRATION_REQUEST_URI) || requestURI.contains(SUPER_ADMIN_URI)) {
			chain.doFilter(req, res);
			return;
		}
		

		final String header = req.getHeader(HEADER_STRING);
		String username = null;
		String authToken = null;
		if (Objects.nonNull(header) && header.startsWith(TOKEN_PREFIX)) {

			authToken = header.replace(TOKEN_PREFIX, StringUtils.EMPTY);
			try {
				username = jwtTokenManager.getUsernameFromToken(authToken);
			}
			catch (Exception e) {
				log.error("Authentication Exception : {}", e.getMessage());
			}
		}

		final SecurityContext securityContext = SecurityContextHolder.getContext();

		if (Objects.nonNull(username) && Objects.isNull(securityContext.getAuthentication())) {

			UserDetails userDetails = userDetailsService.loadUserByUsername(username);
			
			CompanyUserRelation userRelationDetails = userRelationService.getRelationByUser(userService.findByUsername(username));

			if (jwtTokenManager.validateToken(authToken, userDetails.getUsername())) {

				final UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null,userDetails.getAuthorities());
				authentication.setDetails(userRelationDetails);
				log.info("Authentication successful. Logged in username : {} ", username);
				securityContext.setAuthentication(authentication);
			}
		}

		chain.doFilter(req, res);
	}
}
