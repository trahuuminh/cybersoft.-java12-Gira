package cybersoft.java12.gira.product.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@ToString(exclude = {"order"})
@EqualsAndHashCode(exclude = {"order"},callSuper = false)
@Entity
@Table(name = "gira_orderdetails")
public class OrderDetails extends BaseEntity {
	
	@NotBlank
	private int quantity;
	
	@NotNull
	private Long totalCost;
	
	@NotNull
	private String postalCode;
	
	@NotNull
	private String ShipCountry;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name ="order_id")
	private Order order;
}
