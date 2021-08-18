package cybersoft.java12.gira.role.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class DeleteProgramDto {
	@NotNull
	@Min(value = 1)
	private Long programId;

	public Long getProgramId() {
		return programId;
	}

	public void setProgramId(Long programId) {
		this.programId = programId;
	}
	
	
}
