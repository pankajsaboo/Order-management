package increpe.order.mgmt.repository;

import org.springframework.data.repository.CrudRepository;

import increpe.order.mgmt.model.City;

public interface CityRepository extends CrudRepository<City, Long> {

	public City findByStateId_id(Long id);
	
	public City findByCityCode(String cityCode);
	
	public City findByCityName(String cityName);
	
	public boolean existsByCityName(String cityName);
}
