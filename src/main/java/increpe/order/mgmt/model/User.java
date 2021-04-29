package increpe.order.mgmt.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

/**
 * 
 *
 * 
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "users")
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "usr_seq")
	@SequenceGenerator(name = "USR_SEQ", sequenceName = "usr_seq")
	Long id;

	String name;

	@NonNull
	@Column(unique = true)
	String username;

	@NonNull
	String password;
	
	@OneToOne
	@JoinColumn(name = "user_type_id")
	UserType userTypeId;
	
	@OneToOne
	@JoinColumn(name = "roles_id")
	Roles userRole;
	
	@Column(name = "profile_picture", columnDefinition = "TEXT")
	String profilePicture;
	
	@Column(name = "refresh_Token", columnDefinition = "TEXT default '832323458153C21E9685D7AB055262CA33DF061ECA55EDAB245F27E912640209'")
	String refreshToken;
	
}
