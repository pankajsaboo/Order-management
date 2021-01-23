package increpe.order.mgmt.repository;

import org.springframework.data.repository.CrudRepository;

import increpe.order.mgmt.model.Api;

public interface ApiRepository extends CrudRepository<Api, Long> {

	Api findByApiName(String ApiName);

	boolean existsByApiName(String apiName);

}
