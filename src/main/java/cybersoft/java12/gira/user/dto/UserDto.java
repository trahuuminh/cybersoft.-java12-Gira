package cybersoft.java12.gira.user.dto;

import java.util.Set;

import cybersoft.java12.gira.role.entity.Group;
import cybersoft.java12.gira.user.util.UserStatus;

public interface UserDto {
	//Spring Projection
	public String getUsername() ;
	

	public String getFullname() ;

	

	public String getDisplayname() ;
	

	public String getAvatar() ;

	

	public String getEmail() ;

	

	public UserStatus getStatus();

	

	public String getFacebook() ;

	

	public String getJob() ;

	

	public String getDeparment() ;

	

	public String getHobby() ;

	

	public Set<Group> getGroups() ;

	
}
