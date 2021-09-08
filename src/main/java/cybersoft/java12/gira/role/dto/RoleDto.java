package cybersoft.java12.gira.role.dto;

import java.util.Set;

import cybersoft.java12.gira.role.entity.Group;
import cybersoft.java12.gira.role.entity.Program;

public interface RoleDto {
	//projection
	public Long getId();
	public String getName();
	public String getDescription();
	public Set<Program> getPrograms();
	public Set<Group> getGroups();
}
