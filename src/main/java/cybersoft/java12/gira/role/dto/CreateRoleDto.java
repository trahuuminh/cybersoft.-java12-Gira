package cybersoft.java12.gira.role.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import cybersoft.java12.gira.role.validation.annotation.UniqueRoleName;
import cybersoft.java12.gira.role.validation.annotation.ValidDescription;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CreateRoleDto {
	@NotBlank(message = "{role.name.not-blank}")
	@Size(min = 3, max = 50, message = "{role.name.size}")
	@UniqueRoleName(message = "{role.name.used}")
	private String name;
	
	
	@ValidDescription
	private String description;
	
	
	
	
}