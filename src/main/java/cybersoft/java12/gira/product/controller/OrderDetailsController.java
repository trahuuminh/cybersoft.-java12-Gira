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
import cybersoft.java12.gira.product.dto.CreateOrderDetailsDto;
import cybersoft.java12.gira.product.entity.OrderDetails;
import cybersoft.java12.gira.product.service.itf.OrderDetailsService;

@RestController
@RequestMapping("/api/order-details")
public class OrderDetailsController {
	
	private OrderDetailsService orderDetailsService;
	
	public OrderDetailsController(OrderDetailsService odService) {
		orderDetailsService=odService;
	}
	
	@GetMapping("/findall-order-details")
	public Object findAllOrderDetails() {
		List<OrderDetails> listOrderDetails=orderDetailsService.findAllOrderDetailsDto();
		
		return ResponseHandler.getResponse(listOrderDetails,HttpStatus.OK);
	}
	
	@PostMapping("/create-orderdetails")
	public Object CreateNewOrderDetails(@Valid @RequestBody CreateOrderDetailsDto dto, BindingResult errors) {
		if(errors.hasErrors())
			return ResponseHandler.getResponse(errors,HttpStatus.BAD_REQUEST);
		
		OrderDetails orderDetails=orderDetailsService.createOrderDetails(dto);
		
		return ResponseHandler.getResponse(orderDetails,HttpStatus.OK);
	}
}
