package cybersoft.java12.gira.user.dto;

import lombok.Data;

@Data
public class UpdateUserDto {
	private Long id;
	
	private String fullname;
	
	private String displayname;
	
	private String avatar;
	
	private String email;
	
	private String facebook;
	
	private String job;
	
	private String deparment;
	
	private String hobby;
}
