package increpe.order.mgmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import increpe.order.mgmt.repository.TourRepository;
import increpe.order.mgmt.security.dto.RegistrationResponse;
import increpe.order.mgmt.security.mapper.CompanyMapper;
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
}
