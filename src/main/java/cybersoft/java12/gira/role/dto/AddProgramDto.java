package cybersoft.java12.gira.role.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import cybersoft.java12.gira.role.validation.annotation.ExistProgramId;
import cybersoft.java12.gira.role.validation.annotation.ExistRoleId;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddProgramDto {
	@ExistRoleId
	@NotNull
	@Min(value = 1)
	private Long roleId;
	
	@ExistProgramId
	@NotNull
	@Min(value = 1)
	private Long programId;

	
}
