package cybersoft.java12.gira.role.service.itf;

import java.util.List;

import cybersoft.java12.gira.role.dto.CreateGroupDto;
import cybersoft.java12.gira.role.entity.Group;

public interface GroupService {
	List<Group>findAll();
	Group addNewGroup(CreateGroupDto dto);
}
