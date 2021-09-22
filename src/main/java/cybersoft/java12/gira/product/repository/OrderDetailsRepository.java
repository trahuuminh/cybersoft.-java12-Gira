package cybersoft.java12.gira.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cybersoft.java12.gira.product.entity.OrderDetails;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long> {

	@Query("SELECT od FROM OrderDetails od")
	public List<OrderDetails> findAllOrderDetailsDto();
}
