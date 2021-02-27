package increpe.order.mgmt.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import increpe.order.mgmt.model.Order;
import increpe.order.mgmt.model.OrderDetails;
import increpe.order.mgmt.repository.OrderDetailsRepository;
import increpe.order.mgmt.repository.OrderRepository;
import increpe.order.mgmt.security.dto.OrderDto;
import increpe.order.mgmt.security.dto.RegistrationResponse;
import increpe.order.mgmt.security.dto.SalesPersonDto;
import increpe.order.mgmt.security.mapper.CompanyMapper;

@Service
public class OrdersService {

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	OrderDetailsRepository orderDetailsRepository;
	
	@Autowired
	TraderService traderService;
	
	@Autowired
	SalesPersonService salesPersonService;

	public RegistrationResponse createNewOrder(OrderDto orderDto) {

		save(orderDto);

		return new RegistrationResponse("Order added successfully");
	}

	public List<OrderDto> getAllOrdersForSalesPerson(Long salesPersonId) {

		List<Order> orderList = orderRepository.findBySalesPersonId_id(salesPersonId);

		return CompanyMapper.INSTANCE.convertToOrderDtoList(orderList);
	}
	
	public List<OrderDto> getAllOrdersForCompany(Long companyId) {
		
		List<Long> userIdList = traderService.getAllUserIdByCompanyId(companyId);
		
		List<Order> orderList = orderRepository.findBySalesPersonId_UserId_idIn(userIdList);
		
		return CompanyMapper.INSTANCE.convertToOrderDtoList(orderList);
		
	}
	
	public boolean deleteOrder(Long orderId) {
		
		orderRepository.deleteById(orderId);
		return orderRepository.existsById(orderId);
	}
	
	public boolean deleteOrderDetail(Long id) {
		
		orderDetailsRepository.deleteById(id);
		
		return orderDetailsRepository.existsById(id);
	}

	public RegistrationResponse updateOrder(OrderDto orderDto) {

		save(orderDto);
		
		return new RegistrationResponse("Order updated successfully!");
	}

	protected void save(OrderDto orderDto) {
		
		Order order = orderRepository.save(CompanyMapper.INSTANCE.convertToOrder(orderDto));

		orderDto.getOrderDetailsList().stream().forEach(orderDetailsDto -> {

			OrderDetails orderDetails = CompanyMapper.INSTANCE.convertToOrderDetails(orderDetailsDto);

			orderDetails.setOrderId(order);

			orderDetailsRepository.save(orderDetails);
		});
	}
}
