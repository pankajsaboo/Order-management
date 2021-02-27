package increpe.order.mgmt.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.AccessLevel;
import lombok.Builder.Default;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@Entity(name = "attendance")
@NoArgsConstructor
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class Attendance {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "attendance_seq")
	@SequenceGenerator(name = "ATTENDANCE_SEQ", sequenceName = "attendance_seq")
	Long id;
	
	@OneToOne
	@JoinColumn(name = "sales_person_id")
	SalesPerson salesPersonId;
	
	@Column(name = "end_Time")
	LocalDateTime endTime;
	
	@Column(name = "start_time")
	LocalDateTime startTime;
	
	@Column(name = "field_location")
	String fieldLocation;
	
	@Column(name = "live_location", columnDefinition = "TEXT")
	String liveLocation;
	
	@Column(name = "is_holiday")
	boolean isHoliday;
	
	@Column(name = "is_weekend")
	boolean isWeekend;
	
	@Column(name = "on_leave")
	boolean onLeave;
}
