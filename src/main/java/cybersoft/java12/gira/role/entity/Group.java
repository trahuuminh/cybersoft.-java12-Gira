package cybersoft.java12.gira.role.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import cybersoft.java12.gira.common.entity.BaseEntity;

@Entity
@Table(name = "gira_group")
public class Group extends BaseEntity {

	private String name;
	private String description;
	
	@OneToMany(mappedBy = "group")
	private List<Role>roles =new ArrayList<Role>();
	
	@ManyToMany
	private List<Program>groupPrograms=new ArrayList<Program>();
}
