package increpe.order.mgmt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Entity(name = "holiday_master")
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class HolidayMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "holiday_seq")
	@SequenceGenerator(name = "HOLIDAY_SEQ", sequenceName = "holiday_seq")
	Long id;
	
	@OneToOne
	@JoinColumn(name = "company_id")
	Company companyId;
	
	String monthYear;
	
	@JsonIgnore
	@Column(columnDefinition = "TEXT")
	String holidayList;
}
