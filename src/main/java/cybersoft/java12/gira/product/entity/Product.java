package cybersoft.java12.gira.product.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
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
@ToString
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "gira_product")
public class Product extends BaseEntity {
	
	@NotNull
	private String name;
	
	private String description;
	
	@NotNull
	private Long price;
	
	
	private String status;
	
	
	private String producer;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "products")
	@Builder.Default
	private Set<Order>order=new HashSet<>();
}
