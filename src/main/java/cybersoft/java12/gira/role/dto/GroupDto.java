package cybersoft.java12.gira.role.dto;

import java.util.Set;

import cybersoft.java12.gira.role.entity.Role;
import cybersoft.java12.gira.user.entity.User;

public interface GroupDto {
	public Long getId();
	public String getName();
	public String getDescription();
	public Set<Role> getRoles();
	public Set<User> getUsers();
}
