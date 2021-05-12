package increpe.order.mgmt.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import increpe.order.mgmt.repository.TourRepository;
import increpe.order.mgmt.security.dto.RegistrationResponse;
import increpe.order.mgmt.security.dto.RequestObject;
import increpe.order.mgmt.security.mapper.CompanyMapper;
import increpe.order.mgmt.sp.dto.TourReportsDTO;
import increpe.order.mgmt.sp.dto.PageResultObject;
import increpe.order.mgmt.sp.dto.TourDto;

@Service
public class TourService {
	
	@Autowired
	TourRepository tourRepository;
	
	public RegistrationResponse createNewTour(TourDto tourDto) {
		
		tourRepository.save(CompanyMapper.INSTANCE.convertToTour(tourDto));
		
		return new RegistrationResponse("Tour added successfully!");
	}
	
	public List<TourDto> getTourListBySalesPersonId(Long id){
		
		return CompanyMapper.INSTANCE.convertToTourDtoList(tourRepository.findBySalesPersonId_id(id));
	}
	
	public TourDto getTourById(Long id) {
		return CompanyMapper.INSTANCE.convertToTourDto(tourRepository.findById(id).get());
	}

	public RegistrationResponse updateTour(TourDto tourDto) {
		
		tourRepository.save(CompanyMapper.INSTANCE.convertToTour(tourDto));
		
		return new RegistrationResponse("Tour updated successfully!");
	}
	
	public boolean deleteTour(Long id) {
		
		tourRepository.deleteById(id);
		
		return tourRepository.existsById(id);	
	}
	
	
	public PageResultObject<TourReportsDTO> findTourReportsByUser(RequestObject req) {

		Pageable pageFilter = PageRequest.of(req.getPage(), req.getSize());

		Page resultPage = tourRepository.findTourReportByUser(req.getCompanyId(), req.getUserId(), pageFilter);

		@SuppressWarnings("unchecked")
		List<Object[]> recordList = resultPage.getContent();

		List<TourReportsDTO> resultList = recordList.stream()
				.map(t -> new TourReportsDTO(t[0], t[1], t[2], t[3], t[4], t[5], t[6], t[7], t[8], t[9], t[10], t[11]))
				.collect(Collectors.toList());

		return new PageResultObject<TourReportsDTO>(resultList, resultPage.getPageable(),
				resultPage.getTotalElements(), resultPage.getTotalPages());

	}

	public PageResultObject<TourReportsDTO> findTourReportsByDate(RequestObject req) {

		Pageable pageFilter = PageRequest.of(req.getPage(), req.getSize());

		Page resultPage = tourRepository.findTourReportByDate(req.getCompanyId(), req.getDate(), pageFilter);

		@SuppressWarnings("unchecked")
		List<Object[]> recordList = resultPage.getContent();

		List<TourReportsDTO> resultList = recordList.stream()
				.map(t -> new TourReportsDTO(t[0], t[1], t[2], t[3], t[4], t[5], t[6], t[7], t[8], t[9], t[10], t[11]))
				.collect(Collectors.toList());

		return new PageResultObject<TourReportsDTO>(resultList, resultPage.getPageable(),
				resultPage.getTotalElements(), resultPage.getTotalPages());

	}

	public PageResultObject<TourReportsDTO> findTourReportsByMonthYear(RequestObject req) {

		Pageable pageFilter = PageRequest.of(req.getPage(), req.getSize());

		String formattedMonthYear = req.getMonthYear().split("-")[0].toUpperCase() + "%" + req.getMonthYear().split("-")[1];
		Page resultPage = tourRepository.findTourReportByMonthYear(req.getCompanyId(), formattedMonthYear, pageFilter);

		@SuppressWarnings("unchecked")
		List<Object[]> recordList = resultPage.getContent();

		List<TourReportsDTO> resultList = recordList.stream()
				.map(t -> new TourReportsDTO(t[0], t[1], t[2], t[3], t[4], t[5], t[6], t[7], t[8], t[9], t[10], t[11]))
				.collect(Collectors.toList());

		return new PageResultObject<TourReportsDTO>(resultList, resultPage.getPageable(),
				resultPage.getTotalElements(), resultPage.getTotalPages());

	}

}
