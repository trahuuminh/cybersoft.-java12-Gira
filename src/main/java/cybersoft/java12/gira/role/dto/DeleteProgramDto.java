package cybersoft.java12.gira.role.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeleteProgramDto {
	@NotNull
	@Min(value = 1)
	private Long programId;

	
	
}
