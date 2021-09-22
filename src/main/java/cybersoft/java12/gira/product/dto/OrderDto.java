package cybersoft.java12.gira.product.dto;

import java.util.Set;

import cybersoft.java12.gira.product.entity.OrderDetails;
import cybersoft.java12.gira.product.entity.Product;
import cybersoft.java12.gira.user.entity.User;

public interface OrderDto {
	public User getUser();
	
	public OrderDetails getOrderDetails();
	
	public Set<Product> getProducts();
}
