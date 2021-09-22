package cybersoft.java12.gira.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cybersoft.java12.gira.product.dto.ProductDto;
import cybersoft.java12.gira.product.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	@Query("SELECT p FROM Product p")
	List<ProductDto> findAllProductDto();
}
