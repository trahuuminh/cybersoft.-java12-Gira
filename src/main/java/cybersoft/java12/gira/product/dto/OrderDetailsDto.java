package cybersoft.java12.gira.product.dto;

import cybersoft.java12.gira.product.entity.Order;

public interface OrderDetailsDto {
	public String getPostalCode();
	
	public Long getTotalCost();
	
	public Order getOrder();
}
