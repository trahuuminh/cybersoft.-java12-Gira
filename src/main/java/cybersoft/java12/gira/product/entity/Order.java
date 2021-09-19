package cybersoft.java12.gira.product.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import cybersoft.java12.gira.common.entity.BaseEntity;
import cybersoft.java12.gira.user.entity.User;
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
@ToString(exclude = {"user"})
@EqualsAndHashCode(exclude = {"user"},callSuper = false)
@Entity
@Table(name = "gira_order")
public class Order extends BaseEntity {
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "orderdetails_id")
	private OrderDetails orderdetails;
	
	@JsonIgnore
	@Builder.Default
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
	@JoinTable(name = "gira_order_product",
	joinColumns = @JoinColumn(name = "order_id"),
	inverseJoinColumns = @JoinColumn(name = "product_id"))
	private Set<Product>products=new HashSet<>();
}
