package cybersoft.java12.gira.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cybersoft.java12.gira.product.dto.OrderDto;
import cybersoft.java12.gira.product.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
	
	@Query("SELECT o FROM Order o")
	List<OrderDto> findAllOrderDto();
}
