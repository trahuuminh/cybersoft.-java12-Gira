package cybersoft.java12.gira.product.service.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import cybersoft.java12.gira.product.dto.CreateOrderDetailsDto;
import cybersoft.java12.gira.product.entity.Order;
import cybersoft.java12.gira.product.entity.OrderDetails;
import cybersoft.java12.gira.product.repository.OrderDetailsRepository;
import cybersoft.java12.gira.product.repository.OrderRepository;
import cybersoft.java12.gira.product.service.itf.OrderDetailsService;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService{

	private OrderDetailsRepository orderDetailsRepo;
	private OrderRepository orderRepo;
	
	public OrderDetailsServiceImpl(OrderDetailsRepository orderDetailsRepository, OrderRepository orderRepository) {
		orderDetailsRepo=orderDetailsRepository;
		orderRepo=orderRepository;
	}
	
	@Override
	public List<OrderDetails> findAllOrderDetailsDto() {
		return orderDetailsRepo.findAllOrderDetailsDto();
	}

	@Override
	public OrderDetails createOrderDetails(CreateOrderDetailsDto dto) {
		OrderDetails orderDetails=new OrderDetails();
		Order order=orderRepo.getById(dto.getOrderId());
		
		orderDetails.setPostalCode(dto.getPostalCode());
		orderDetails.setTotalCost(dto.getTotalCost());
		orderDetails.setOrder(order);
		
		return orderDetailsRepo.save(orderDetails);
	}
	
}
