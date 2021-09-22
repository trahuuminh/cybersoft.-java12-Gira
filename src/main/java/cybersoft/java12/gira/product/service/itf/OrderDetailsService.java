package cybersoft.java12.gira.product.service.itf;

import java.util.List;

import cybersoft.java12.gira.product.dto.CreateOrderDetailsDto;
import cybersoft.java12.gira.product.entity.OrderDetails;

public interface OrderDetailsService {
	List<OrderDetails> findAllOrderDetailsDto();
	
	OrderDetails createOrderDetails(CreateOrderDetailsDto dto);
}
