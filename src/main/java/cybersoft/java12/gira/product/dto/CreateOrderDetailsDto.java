package cybersoft.java12.gira.product.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class CreateOrderDetailsDto {

	private String postalCode;
	
	private Long totalCost;
	
	@NotNull
	private Long orderId;
}
