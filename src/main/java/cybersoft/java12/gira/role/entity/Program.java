package cybersoft.java12.gira.role.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import cybersoft.java12.gira.common.entity.BaseEntity;

@Entity
@Table(name = "gira_program")
public class Program extends BaseEntity{
	private String name;
	private String description;
	
	@ManyToMany(mappedBy = "rolePrograms")
	private	List<Role>roles=new ArrayList<Role>();
	
	@ManyToMany(mappedBy = "groupPrograms")
	private List<Group>groups=new ArrayList<Group>();
	
	
}
