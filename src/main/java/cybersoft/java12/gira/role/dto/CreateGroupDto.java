package cybersoft.java12.gira.role.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import cybersoft.java12.gira.role.validation.annotation.UniqueGroupName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateGroupDto {
	@NotBlank(message = "{role.name.not-blank}")
	@Size(min = 3, max = 50, message = "{role.name.size}")
	@UniqueGroupName(message = "{group.name.used}")
	private String name;
	
	@NotBlank
	private String description;
	
	
}
