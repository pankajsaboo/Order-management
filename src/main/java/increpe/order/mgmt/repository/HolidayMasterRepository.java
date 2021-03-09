package increpe.order.mgmt.repository;

import org.springframework.data.repository.CrudRepository;

import increpe.order.mgmt.model.HolidayMaster;

public interface HolidayMasterRepository extends CrudRepository<HolidayMaster, Long> {
	
	HolidayMaster findByCompanyId_idAndMonthYear(Long companyId, String monthYear);

}
