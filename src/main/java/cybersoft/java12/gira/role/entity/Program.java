package cybersoft.java12.gira.role.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import cybersoft.java12.gira.common.entity.BaseEntity;
import cybersoft.java12.gira.role.util.HttpMethods;

@Entity
@Table(name = "gira_program")
public class Program extends BaseEntity {
	private String name;
	private HttpMethods method;
	private String path;
	
	@ManyToMany(mappedBy = "programs")
	private Set<Role>roles=new HashSet<>();
	
}
