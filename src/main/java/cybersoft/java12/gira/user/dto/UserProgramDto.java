package cybersoft.java12.gira.user.dto;

import cybersoft.java12.gira.role.util.HttpMethods;

public interface UserProgramDto {
	public String getName();
	public HttpMethods getMethod();
	public String getPath();
}
