package increpe.order.mgmt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Entity(name = "city")
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class City {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "city_seq")
	@SequenceGenerator(name = "CITY_SEQ", sequenceName = "city_seq")
	Long id;
	
	@ManyToOne
	@JoinColumn(name = "state_id")
	State stateId;
	
	
	@Column(name = "city_name", unique = true)
	String cityName;
	
	@Column(name = "city_code")
	String cityCode;
	
	@Column(name = "status")
	String status;

}
