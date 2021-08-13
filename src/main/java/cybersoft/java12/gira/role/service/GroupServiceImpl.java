package cybersoft.java12.gira.role.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cybersoft.java12.gira.role.dto.CreateGroupDto;
import cybersoft.java12.gira.role.entity.Group;
import cybersoft.java12.gira.role.repository.GroupRepository;
import cybersoft.java12.gira.role.service.itf.GroupService;

@Service
public class GroupServiceImpl implements GroupService {
	private GroupRepository repository;
	
	public GroupServiceImpl(GroupRepository groupRepository) {
		repository=groupRepository;
	}
	
	@Override
	public List<Group> findAll() {
			return repository.findAll(); 
	}

	@Override
	public Group addNewGroup(CreateGroupDto dto) {
		Group group=new Group();
		group.setName(dto.getName());
		group.setDescription(dto.getDescription());
		
		return repository.save(group);
	}
	
}
