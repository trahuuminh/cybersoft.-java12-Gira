package cybersoft.java12.gira.product.service.itf;

import java.util.List;

import cybersoft.java12.gira.product.dto.CreateOrderDto;
import cybersoft.java12.gira.product.entity.Order;

public interface OrderService {
	Order CreateOrder(CreateOrderDto dto);
	
	List<Order> findAllOrderDto();
}
