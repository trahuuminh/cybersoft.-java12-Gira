package cybersoft.java12.gira.product.entity;


import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


import cybersoft.java12.gira.common.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "gira_orderDetails")
public class OrderDetails extends BaseEntity {
	
	private String postalCode;
	
	private Long totalCost;
	
	@NotNull
	@OneToOne
	@JoinColumn(name = "order_id")
	private Order order;


}
