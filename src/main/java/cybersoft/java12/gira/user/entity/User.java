package cybersoft.java12.gira.user.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import cybersoft.java12.gira.common.entity.BaseEntity;
import cybersoft.java12.gira.product.entity.Order;
import cybersoft.java12.gira.product.entity.Product;
import cybersoft.java12.gira.role.entity.Group;
import cybersoft.java12.gira.user.util.UserStatus;
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
@ToString(exclude = {"groups"})
@EqualsAndHashCode(exclude = {"groups"},callSuper = false)
@Entity
@Table(name = "gira_user")
public class User extends BaseEntity {
	
	@NotNull
	@Column(unique = true)
	@Size(min = 3, max = 50, message = "{user.name.size}")
	private String username;
	
	@NotNull
	private String password;
	

	private String fullname;
	private String displayname;	
	private String avatar;
	
	@NotNull
	@Column(unique = true)
	@Email
	private String email;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private UserStatus status;
	
	private String facebook;	
	private String job;	
	private String deparment;	
	private String hobby;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "users")
	@Builder.Default
	private Set<Group>groups=new HashSet<>();

	@JsonIgnore
	@Builder.Default
	@OneToMany(mappedBy = "user")
	private Set<Order> orders=new HashSet<>();
	
	@JsonIgnore
	@Builder.Default
	@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE}, fetch = FetchType.LAZY)
	@JoinTable(name = "gira_user_product",
	joinColumns = @JoinColumn(name ="user_id"),
	inverseJoinColumns = @JoinColumn(name="product_id"))
	private Set<Product> recentCart=new HashSet<>();
	
	public User addOrder(Order order) {
		orders.add(order);
		order.setUser(this);
		return this;
	}
}
