package cybersoft.java12.gira.role.dto; 



import java.util.Set;

import cybersoft.java12.gira.role.entity.Role;
import cybersoft.java12.gira.role.util.HttpMethods;

public interface ProgramDto {
	
	public Long getId();
	public String getName();
	public String getPath();
	public HttpMethods getMethod();
	public Set<Role> getRoles();
}
