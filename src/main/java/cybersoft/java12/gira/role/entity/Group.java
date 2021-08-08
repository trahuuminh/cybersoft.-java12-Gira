package cybersoft.java12.gira.role.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import cybersoft.java12.gira.common.entity.BaseEntity;

@Entity
@Table(name = "gira_group")
public class Group extends BaseEntity {

	private String name;
	private String description;
	

}
