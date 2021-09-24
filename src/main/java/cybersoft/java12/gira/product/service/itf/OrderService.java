package cybersoft.java12.gira.product.service.itf;

import java.util.List;
import java.util.Set;

import cybersoft.java12.gira.product.dto.CreateOrderDto;
import cybersoft.java12.gira.product.dto.OrderDto;
import cybersoft.java12.gira.product.entity.Order;
import cybersoft.java12.gira.product.entity.Product;

public interface OrderService {
	Order CreateOrder(CreateOrderDto dto);
	
	List<OrderDto> findAllOrderDto();
	
	Set<Product> getUserRecentCart(Long id);
	
	void deleteOrder(Long id);
}
