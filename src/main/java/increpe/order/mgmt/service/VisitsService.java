package increpe.order.mgmt.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import increpe.order.mgmt.model.Visits;
import increpe.order.mgmt.repository.VisitsRepository;
import increpe.order.mgmt.security.dto.RegistrationResponse;
import increpe.order.mgmt.security.dto.RequestObject;
import increpe.order.mgmt.security.mapper.CompanyMapper;
import increpe.order.mgmt.sp.dto.PageResultObject;
import increpe.order.mgmt.sp.dto.VisitsDto;
import increpe.order.mgmt.sp.dto.VisitsReportsDTO;

@Service
public class VisitsService {

	@Autowired
	VisitsRepository visitsRepository;
	
	public VisitsDto getVisitById(Long visitId) {
		
		return CompanyMapper.INSTANCE.convertToVisitsDto(visitsRepository.findById(visitId).get());
	}

	public RegistrationResponse createNewVisit(VisitsDto visitsDto) {

		visitsRepository.save(CompanyMapper.INSTANCE.convertToVisits(visitsDto));

		return new RegistrationResponse("Visit reported successfully");
	}

//	public List<VisitsDto> getAllVisitsForSalesPerson(Long salesPersonId) {
//
//		List<Visits> visitsList = visitsRepository.findByCustomerSalesPersonRelationId_SalesPersonId_id(salesPersonId);
//
//		return CompanyMapper.INSTANCE.convertToVisitsDtoList(visitsList);
//	}
//
//	public List<VisitsDto> getVisitsByDateAndSalesPersonId(String visitDate, Long id) {
//
//		List<Visits> visitsList = visitsRepository
//				.findByVisitDateAndCustomerSalesPersonRelationId_SalesPersonId_id(LocalDate.parse(visitDate), id);
//
//		return CompanyMapper.INSTANCE.convertToVisitsDtoList(visitsList);
//	}

	public RegistrationResponse updateVisit(VisitsDto visitsDto) {

		visitsRepository.save(CompanyMapper.INSTANCE.convertToVisits(visitsDto));

		return new RegistrationResponse("Visit Updated successfully");
	}
	
	public boolean deleteVisit(Long visitId) {
		
		visitsRepository.deleteById(visitId);
		
		return visitsRepository.existsById(visitId);
	}
	
	public PageResultObject<VisitsReportsDTO> findVisitReportsByUser(RequestObject req) {

		Pageable pageFilter = PageRequest.of(req.getPage(), req.getSize());

		Page resultPage = visitsRepository.findVisitsReportByUser(req.getCompanyId(), req.getUserId(), pageFilter);

		@SuppressWarnings("unchecked")
		List<Object[]> recordList = resultPage.getContent();

		List<VisitsReportsDTO> resultList = recordList.stream()
				.map(t -> new VisitsReportsDTO(t[0], t[1], t[2], t[3], t[4], t[5], t[6], t[7], t[8], t[9], t[10], t[11]))
				.collect(Collectors.toList());

		return new PageResultObject<VisitsReportsDTO>(resultList, resultPage.getPageable(),
				resultPage.getTotalElements(), resultPage.getTotalPages());

	}

	public PageResultObject<VisitsReportsDTO> findVisitReportsByDate(RequestObject req) {

		Pageable pageFilter = PageRequest.of(req.getPage(), req.getSize());

		Page resultPage = visitsRepository.findVisitsReportByDate(req.getCompanyId(), req.getDate(), pageFilter);

		@SuppressWarnings("unchecked")
		List<Object[]> recordList = resultPage.getContent();

		List<VisitsReportsDTO> resultList = recordList.stream()
				.map(t -> new VisitsReportsDTO(t[0], t[1], t[2], t[3], t[4], t[5], t[6], t[7], t[8], t[9], t[10], t[11]))
				.collect(Collectors.toList());

		return new PageResultObject<VisitsReportsDTO>(resultList, resultPage.getPageable(),
				resultPage.getTotalElements(), resultPage.getTotalPages());

	}

	public PageResultObject<VisitsReportsDTO> findVisitReportsByMonthYear(RequestObject req) {

		Pageable pageFilter = PageRequest.of(req.getPage(), req.getSize());

		String formattedMonthYear = req.getMonthYear().split("-")[0].toUpperCase() + "%" + req.getMonthYear().split("-")[1];
		Page resultPage = visitsRepository.findVisitsReportByMonthYear(req.getCompanyId(), formattedMonthYear, pageFilter);

		@SuppressWarnings("unchecked")
		List<Object[]> recordList = resultPage.getContent();

		List<VisitsReportsDTO> resultList = recordList.stream()
				.map(t -> new VisitsReportsDTO(t[0], t[1], t[2], t[3], t[4], t[5], t[6], t[7], t[8], t[9], t[10], t[11]))
				.collect(Collectors.toList());

		return new PageResultObject<VisitsReportsDTO>(resultList, resultPage.getPageable(),
				resultPage.getTotalElements(), resultPage.getTotalPages());

	}
	
	public PageResultObject<VisitsReportsDTO> findVisitReportsByUserAndDate(RequestObject req) {

		Pageable pageFilter = PageRequest.of(req.getPage(), req.getSize());

		Page resultPage = visitsRepository.findVisitsReportByUserAndDate(req.getCompanyId(), req.getUserId(), req.getDate(), pageFilter);

		@SuppressWarnings("unchecked")
		List<Object[]> recordList = resultPage.getContent();

		List<VisitsReportsDTO> resultList = recordList.stream()
				.map(t -> new VisitsReportsDTO(t[0], t[1], t[2], t[3], t[4], t[5], t[6], t[7], t[8], t[9], t[10], t[11]))
				.collect(Collectors.toList());

		return new PageResultObject<VisitsReportsDTO>(resultList, resultPage.getPageable(),
				resultPage.getTotalElements(), resultPage.getTotalPages());

	}


}
