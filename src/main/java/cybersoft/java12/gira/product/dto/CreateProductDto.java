package cybersoft.java12.gira.product.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;


@Data
public class CreateProductDto {

	@NotBlank(message = "{product.productname.not-blank}")
	private String name;
	
	private String description;
	
	@NotNull
	private Long price;
	
	@NotNull
	private int quantity;

	
	
}
