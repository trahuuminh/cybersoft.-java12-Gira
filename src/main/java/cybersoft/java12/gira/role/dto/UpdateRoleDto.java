package cybersoft.java12.gira.role.dto;

import cybersoft.java12.gira.role.validation.annotation.ValidNewRoleName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ValidNewRoleName
public class UpdateRoleDto {
	private Long id;
	private String name;
	private String oldName;
	private String description;
	
	
	
}
