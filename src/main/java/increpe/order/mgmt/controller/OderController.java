package increpe.order.mgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import increpe.order.mgmt.security.dto.OrderDto;
import increpe.order.mgmt.security.dto.RegistrationResponse;
import increpe.order.mgmt.service.OrdersService;

@CrossOrigin
@RestController
@RequestMapping("/orders")
public class OderController {
	
	@Autowired
	OrdersService ordersService;
	
	@PostMapping("/add")
	public ResponseEntity<RegistrationResponse> createNewOrder(@RequestBody OrderDto orderDto) {

		return ResponseEntity.ok(ordersService.createNewOrder(orderDto));
	}

	@GetMapping("")
	public ResponseEntity<List<OrderDto>> getOrders(@RequestParam(name = "uId") Long id) {

		return ResponseEntity.ok(ordersService.getAllOrdersForSalesPerson(id));
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<OrderDto>> getAllOrdersByCompanyId(@RequestParam(name = "cId") Long id) {

		return ResponseEntity.ok(ordersService.getAllOrdersForCompany(id));
	}

	@PutMapping("/update")
	public ResponseEntity<RegistrationResponse> updateOrder(@RequestBody OrderDto orderDto) {

		return ResponseEntity.ok(ordersService.updateOrder(orderDto));
	}
	
	@DeleteMapping("/delete/single")
	public ResponseEntity<Boolean> deleteOrderDetailById(@RequestParam(name = "pId") Long id){
		
		return ResponseEntity.ok(ordersService.deleteOrderDetail(id));
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<Boolean> deleteOrderById(@RequestParam(name = "oId") Long id){
		
		return ResponseEntity.ok(ordersService.deleteOrder(id));
	}
}
