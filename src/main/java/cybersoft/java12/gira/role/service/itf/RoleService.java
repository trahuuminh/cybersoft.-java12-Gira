package cybersoft.java12.gira.role.service.itf;

import java.util.List;



import cybersoft.java12.gira.role.dto.AddProgramDto;
import cybersoft.java12.gira.role.dto.CreateRoleDto;
import cybersoft.java12.gira.role.dto.RoleDto;
import cybersoft.java12.gira.role.dto.UpdateRoleDto;
import cybersoft.java12.gira.role.entity.Role;

public interface RoleService {
	// contract
	List<RoleDto> findAll();

	Role addNewRole(CreateRoleDto dto);

	Role addProgram(AddProgramDto dto);
	
	Role deleteProgram(AddProgramDto dto);
	
	boolean isTakenName(String roleName);

	boolean isExisted(Long roleId);

	void deleteById(Long roleId);

	Role updateRole(UpdateRoleDto dto);

	

	
	
	
}
