package increpe.order.mgmt.security.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import increpe.order.mgmt.model.Roles;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AuthenticatedUserDto {
	
	@JsonProperty(value = "_id")
	private Long id;

	private String name;

	private String username;

	private String password;

	private RolesDto userRole;
	
	private UserTypeDto userTypeId;
	
	private String profilePicture;
	
	private String refreshToken;

}
