package increpe.order.mgmt.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import increpe.order.mgmt.model.Visits;
import increpe.order.mgmt.repository.VisitsRepository;
import increpe.order.mgmt.security.dto.RegistrationResponse;
import increpe.order.mgmt.security.mapper.CompanyMapper;
import increpe.order.mgmt.sp.dto.VisitsDto;

@Service
public class VisitsService {

	@Autowired
	VisitsRepository visitsRepository;

	public RegistrationResponse createNewVisit(VisitsDto visitsDto) {

		visitsRepository.save(CompanyMapper.INSTANCE.convertToVisits(visitsDto));

		return new RegistrationResponse("Visit reported successfully");
	}

	public List<VisitsDto> getAllVisitsForSalesPerson(Long salesPersonId) {

		List<Visits> visitsList = visitsRepository.findByCustomerSalesPersonRelationId_SalesPersonId_id(salesPersonId);

		return CompanyMapper.INSTANCE.convertToVisitsDtoList(visitsList);
	}

	public List<VisitsDto> getVisitsByDateAndSalesPersonId(String visitDate, Long id) {

		List<Visits> visitsList = visitsRepository
				.findByVisitDateAndCustomerSalesPersonRelationId_SalesPersonId_id(LocalDate.parse(visitDate), id);

		return CompanyMapper.INSTANCE.convertToVisitsDtoList(visitsList);
	}

	public RegistrationResponse updateVisit(VisitsDto visitsDto) {

		visitsRepository.save(CompanyMapper.INSTANCE.convertToVisits(visitsDto));

		return new RegistrationResponse("Visit Updated successfully");
	}
	
	public boolean deleteVisit(Long visitId) {
		
		visitsRepository.deleteById(visitId);
		
		return visitsRepository.existsById(visitId);
	}

}
