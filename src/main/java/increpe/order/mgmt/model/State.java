package increpe.order.mgmt.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Entity(name = "state")
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class State {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "state_seq")
	@SequenceGenerator(name = "STATE_SEQ", sequenceName = "state_seq")
	Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "country_id")
	Country countryId;
	
	
	@Column(name = "state_name")
	String stateName;
	
	@Column(name = "state_code")
	String stateCode;
	
	@Column(name = "status")
	String status;

}
