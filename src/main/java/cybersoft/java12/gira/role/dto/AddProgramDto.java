package cybersoft.java12.gira.role.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import cybersoft.java12.gira.role.validation.annotation.ExistProgramId;
import cybersoft.java12.gira.role.validation.annotation.ExistRoleId;

public class AddProgramDto {
	@ExistRoleId
	@NotNull
	@Min(value = 1)
	private Long roleId;
	
	@ExistProgramId
	@NotNull
	@Min(value = 1)
	private Long programId;

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getProgramId() {
		return programId;
	}

	public void setProgramId(Long programId) {
		this.programId = programId;
	}
	
}
