package cybersoft.java12.gira.product.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class UpdateProductDto {
	
	@NotNull
	private Long id;
	
	private String description;
	
	@NotNull
	private String name;
	
	@NotNull
	private int quantity;
	
	@NotNull
	private Long price;
	
	
}
