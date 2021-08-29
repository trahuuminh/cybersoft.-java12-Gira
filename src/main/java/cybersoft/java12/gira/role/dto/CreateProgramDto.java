package cybersoft.java12.gira.role.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import cybersoft.java12.gira.role.util.HttpMethods;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProgramDto {
	@NotBlank(message = "{role.name.not-blank}")
	@Size(min = 3, max = 50, message = "{role.name.size}")
	private String name;
	private HttpMethods method;
	private String path;
	private Long Id;
	
	
	
}
