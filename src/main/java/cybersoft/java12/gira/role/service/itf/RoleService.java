package cybersoft.java12.gira.role.service.itf;

import java.util.List;

import cybersoft.java12.gira.role.dto.CreateRoleDto;
import cybersoft.java12.gira.role.entity.Role;

public interface RoleService {
	// contract
	List<Role> findAll();

	Role addNewRole(CreateRoleDto dto);
	
	
}
