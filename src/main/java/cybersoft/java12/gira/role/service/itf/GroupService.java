package cybersoft.java12.gira.role.service.itf;

import java.util.List;

import cybersoft.java12.gira.role.dto.CreateGroupDto;
import cybersoft.java12.gira.role.dto.GroupDto;
import cybersoft.java12.gira.role.entity.Group;

public interface GroupService {
	List<GroupDto>findAll();
	Group add(CreateGroupDto dto);
	boolean isExisted(Long groupId);
	boolean isTakenName(String groupName);
}
