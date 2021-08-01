package cybersoft.java12.gira.role.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cybersoft.java12.gira.common.entity.BaseEntity;

@Entity
@Table(name = "gira_role")
public class Role extends BaseEntity {
	
	private String name;
	private String description;
	
	@ManyToOne
	private Group group;
	
}
