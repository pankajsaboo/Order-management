package design.boilerplate.springboot.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

/**
 * Created on Ağustos, 2020
 *
 * @author Faruk
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
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "user_seq")
	@SequenceGenerator(name = "USER_SEQ", sequenceName = "user_seq")
	Long id;

	String name;

	@NonNull
	@Column(unique = true)
	String username;

	@NonNull
	String password;
	
	@Column(name = "designation")
	String designation;
	
	@Column(name = "employee_id")
	String employeeId;
	
	@OneToOne
	@JoinColumn(name = "user_type_id")
	UserType userTypeId;
	
	@NonNull
	@OneToOne
	@JoinColumn(name = "roles_id")
	Roles userRoleId;
	
}
