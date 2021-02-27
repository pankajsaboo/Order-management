package increpe.order.mgmt.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import increpe.order.mgmt.security.dto.CompanyDto;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@Entity(name = "tour")
@NoArgsConstructor
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class Tour {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "tour_seq")
	@SequenceGenerator(name = "TOUR_SEQ", sequenceName = "tour_seq")
	Long id;
	
	@OneToOne
	@JoinColumn(name = "sales_person_id")
	SalesPerson salesPersonId;
	
	@Column(name = "location")
	String location;
	
	@Column(name = "start_date")
	LocalDate startDate;
	
	@Column(name = "end_date")
	LocalDate endDate;
	
	@Column(name = "tour_details", columnDefinition = "TEXT")
	String tourDetails;
}
