package increpe.order.mgmt.security.dto;

import org.springframework.data.domain.Pageable;

import lombok.Data;

@Data
public class RequestObject {
	
	String mY;
	
	Long id;
	
	Long uId;
	
	Long cId;
	
	Long pId;
	
	int pageBegin;
	
	int pageLength;
	
	//Column name
	String sortBy;
	
	//Sorting direction desc | asc
	String dir;

}
