package increpe.order.mgmt.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import increpe.order.mgmt.model.Attendance;

public interface AttendanceRepository extends CrudRepository<Attendance, Long> {

	List<Attendance> findBySalesPersonId_idAndStartTimeBetween(Long salesPersonId ,LocalDateTime start, LocalDateTime end);
}
