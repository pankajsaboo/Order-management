package increpe.order.mgmt.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import increpe.order.mgmt.security.dto.AuthenticatedUserDto;
import increpe.order.mgmt.security.service.UserService;
import increpe.order.mgmt.service.CompanyUserRelationService;

import static increpe.order.mgmt.security.utils.SecurityConstants.*;

import java.util.Date;

/**
 * 
 *
 * 
 */
@Component
public class JwtTokenManager {

	// FIXME : Customize JWT token management for your application
	@Autowired
	CompanyUserRelationService companyUSerRelationService;
	
	@Autowired
	UserService userService;
	

	public String generateToken(AuthenticatedUserDto user) {

		final String username = user.getUsername();
		final String userRole = user.getUserRole().getTitle();
		final Claims claims = Jwts.claims().setSubject(username);
		user.setProfilePicture(null);
		claims.put("role", userRole);
		claims.put("userId", user);
		claims.put("companyId", getCompanyId(user));

		final long currentTimeMillis = System.currentTimeMillis();

		return Jwts.builder()
				.setClaims(claims)
				.setIssuer(ISSUER)
				.setIssuedAt(new Date(currentTimeMillis))
				.setExpiration(new Date(currentTimeMillis + EXPIRATION_TIME))
				.signWith(SignatureAlgorithm.HS256, SECRET_KEY)
				.compact();
	}
	
	public String getUsernameFromToken(String token) {

		final Claims claims = getAllClaimsFromToken(token);
		return claims.getSubject();
	}

	public boolean validateToken(String token, String authenticatedUsername) {

		final String usernameFromToken = getUsernameFromToken(token);

		final boolean equalsUsername = usernameFromToken.equals(authenticatedUsername);
		final boolean tokenExpired = isTokenExpired(token);

		return equalsUsername && !tokenExpired;
	}

	private boolean isTokenExpired(String token) {

		final Date expirationDateFromToken = getExpirationDateFromToken(token);
		return expirationDateFromToken.before(new Date());
	}

	private Date getExpirationDateFromToken(String token) {

		final Claims claims = getAllClaimsFromToken(token);
		return claims.getExpiration();
	}

	private Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
	}
	
	private Long getCompanyId(AuthenticatedUserDto userId) {
		
		return companyUSerRelationService
				.getRelationByUser(userService.findByUsername(userId.getUsername())).getCompanyId().getId();
	}

}
