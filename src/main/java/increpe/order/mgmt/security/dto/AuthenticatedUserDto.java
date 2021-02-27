package increpe.order.mgmt.security.dto;

import increpe.order.mgmt.model.Roles;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AuthenticatedUserDto {
	
	private Long id;

	private String name;

	private String username;

	private String password;

	private RolesDto userRole;
	
	private UserTypeDto userTypeId;
	
	private String profilePicture;

}
