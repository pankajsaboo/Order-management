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
@Table(name = "users")
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "user_seq")
	@SequenceGenerator(name = "USER_SEQ", sequenceName = "user_seq")
	Long id;

	String name;

	@Column(unique = true)
	String username;

	String password;
	
	@ManyToOne
	@JoinColumn(name = "company_id")
	Company companyId;
	
	@OneToOne
	@JoinColumn(name = "user_type_id")
	UserType userTypeId;
	
	@OneToOne
	@JoinColumn(name = "roles_id")
	Roles userRole;

	

}
