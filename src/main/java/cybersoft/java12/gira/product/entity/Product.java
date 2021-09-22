package cybersoft.java12.gira.product.entity;


import javax.persistence.Entity;
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
@Table(name = "gira_product")
public class Product extends BaseEntity{
	
	
	@NotNull
	private String Name;
	
	private String Description;
	
	@NotNull
	private Long price;
	
	@NotNull
	private int quantity;
	
	
}
