package cybersoft.java12.gira.product.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cybersoft.java12.gira.common.ResponseHandler;
import cybersoft.java12.gira.product.dto.CreateOrderDto;
import cybersoft.java12.gira.product.entity.Order;
import cybersoft.java12.gira.product.service.itf.OrderService;

@RestController
@RequestMapping("/api/order")
public class OrderController {

	private OrderService orderService;
	
	public OrderController(OrderService oService) {
		orderService=oService;
	}
	
	@GetMapping
	public Object findAllOrder() {
		List<Order> orders=orderService.findAllOrderDto();
		
		return ResponseHandler.getResponse(orders,HttpStatus.OK);
	}
	
	@PostMapping
	public Object CreateNewOrder(@Valid @RequestBody CreateOrderDto dto, BindingResult errors) {
		if(errors.hasErrors())
			return ResponseHandler.getResponse(errors,HttpStatus.BAD_REQUEST);
		
		Order order=orderService.CreateOrder(dto);
		
		return ResponseHandler.getResponse(order,HttpStatus.OK);
	}
}
