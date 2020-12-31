package design.boilerplate.springboot.security.service;

import java.util.List;

import design.boilerplate.springboot.security.dto.TraderDto;

public interface SuperAdminService {
	
	public String createNewTraderAccount(TraderDto traderDto);
	
	public List<TraderDto> findAllTraders();
	
	public String updateTraderAccount(TraderDto traderDto);
	
	public String removeTraderAccount(Long traderId);

}
