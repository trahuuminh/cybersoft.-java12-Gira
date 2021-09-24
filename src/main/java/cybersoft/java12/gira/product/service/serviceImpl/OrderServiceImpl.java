package cybersoft.java12.gira.product.service.serviceImpl;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cybersoft.java12.gira.product.dto.CreateOrderDto;
import cybersoft.java12.gira.product.dto.OrderDto;
import cybersoft.java12.gira.product.entity.Order;
import cybersoft.java12.gira.product.entity.Product;
import cybersoft.java12.gira.product.repository.OrderRepository;
import cybersoft.java12.gira.product.service.itf.OrderService;
import cybersoft.java12.gira.user.entity.User;
import cybersoft.java12.gira.user.repository.UserRepository;

@Service
public class OrderServiceImpl implements OrderService {

	private OrderRepository orderRepo;
	private UserRepository userRepo;
	
	public OrderServiceImpl(OrderRepository orderRepository, UserRepository userRepository) {
		orderRepo=orderRepository;
		userRepo=userRepository;
	}

	@Override
	public List<OrderDto> findAllOrderDto() {
		return orderRepo.findAllOrderDto();
	}
	
	@Override
	public Set<Product> getUserRecentCart(Long id) {
		User user=userRepo.getById(id);
		
		return user.getRecentCart();
	}
	
	
	@Transactional
	public Order CreateOrder(CreateOrderDto dto) {
		User user=userRepo.getById(dto.getUserId());
		
		Order order=new Order();
		
		order.setUser(user);

		
		return orderRepo.save(order);
	}

	@Override
	public void deleteOrder(Long id) {
		orderRepo.deleteById(id);
	}

	
	
}
