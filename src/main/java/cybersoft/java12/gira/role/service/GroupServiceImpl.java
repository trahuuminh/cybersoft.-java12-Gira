package cybersoft.java12.gira.role.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cybersoft.java12.gira.role.dto.AddRoleDto;
import cybersoft.java12.gira.role.dto.AddUserDto;
import cybersoft.java12.gira.role.dto.CreateGroupDto;
import cybersoft.java12.gira.role.dto.GroupDto;
import cybersoft.java12.gira.role.entity.Group;
import cybersoft.java12.gira.role.entity.Role;
import cybersoft.java12.gira.role.repository.GroupRepository;
import cybersoft.java12.gira.role.repository.RoleRepository;
import cybersoft.java12.gira.role.service.itf.GroupService;
import cybersoft.java12.gira.user.entity.User;
import cybersoft.java12.gira.user.repository.UserRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
@Transactional(readOnly = true)
public class GroupServiceImpl implements GroupService {
	private GroupRepository repository;
	private final RoleRepository roleRepository;
	private final UserRepository userRepository;

	/*public GroupServiceImpl(GroupRepository groupRepository,RoleRepository RRepository) {
		repository = groupRepository;
		roleRepository=RRepository;
	}*/
	
	@Override
	public boolean isTakenName(String groupName) {
		return repository.countByName(groupName) >= 1;
	}

	@Override
	public List<GroupDto> findAll() {
		return repository.findAllDto();
	}

	@Override
	public Group add(CreateGroupDto dto) {
		Group group = new Group();
		group.setName(dto.getName());
		group.setDescription(dto.getDescription());
		
		return repository.save(group);
	}

	@Override
	public boolean isExisted(Long groupId) {
		return repository.existsById(groupId);
	}

	@Override
	@Transactional
	public Group addRole(AddRoleDto dto) {
		Group group = repository.getById(dto.getGroupId());
		Role role = roleRepository.getById(dto.getRoleId());
		return group.addRole(role);
	}

	@Override
	@Transactional
	public Group addUser(AddUserDto dto) {
		Group group=repository.getById(dto.getGroupId());
		User user= userRepository.getById(dto.getUserId());
		
		
		return group.addUser(user);
	}

	@Override
	@Transactional
	public Group removeRole(AddRoleDto dto) {
		Group group=repository.getById(dto.getGroupId());
		Role role=roleRepository.getById(dto.getRoleId());
		return group.deleteRole(role);
	}
	
	
	
	
	
}
