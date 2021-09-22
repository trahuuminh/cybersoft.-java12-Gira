package cybersoft.java12.gira.product.service.itf;

import java.util.List;

import cybersoft.java12.gira.product.dto.CreateProductDto;
import cybersoft.java12.gira.product.dto.ProductDto;
import cybersoft.java12.gira.product.dto.UpdateProductDto;
import cybersoft.java12.gira.product.entity.Product;

public interface ProductService {
	
	Product createProduct(CreateProductDto dto);
	
	List<ProductDto> findAllProductDto();
	
	Product updateProduct(UpdateProductDto dto);
	
	void deleteProductById(Long id);
}
