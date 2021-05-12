package increpe.order.mgmt.security.dto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.fasterxml.jackson.annotation.JsonProperty;

import increpe.order.mgmt.sp.dto.ActivityMasterDto;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class RequestObject {
	
	//String mY;
	
	String monthYear;
	
	String date;
	
	Long userId;
	
	Long companyId;
	
	Long productId;
	
	int page;
	
	int size;
	
	// date | monthYear | user
	String filterBy;
	
	// individual record id
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
	
	String refreshToken;

}
