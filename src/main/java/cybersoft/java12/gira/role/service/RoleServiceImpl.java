package cybersoft.java12.gira.role.service;

import java.util.List;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cybersoft.java12.gira.role.dto.AddProgramDto;
import cybersoft.java12.gira.role.dto.CreateRoleDto;
import cybersoft.java12.gira.role.dto.RoleDto;
import cybersoft.java12.gira.role.dto.UpdateRoleDto;
import cybersoft.java12.gira.role.entity.Program;
import cybersoft.java12.gira.role.entity.Role;
import cybersoft.java12.gira.role.repository.ProgramRepository;
import cybersoft.java12.gira.role.repository.RoleRepository;
import cybersoft.java12.gira.role.service.itf.RoleService;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
	private RoleRepository repository;
	private ProgramRepository Prepository;
	
	public RoleServiceImpl(RoleRepository roleRepository, ProgramRepository programRepository) {
		repository = roleRepository;
		Prepository=programRepository;
	}
	
	@Override
	public List<RoleDto> findAll() {
		return repository.findAllDto();
	}

	@Override
	public Role addNewRole(CreateRoleDto dto) {
		Role newRole = new Role();
		
		newRole.setName(dto.getName().toUpperCase());
		newRole.setDescription(dto.getDescription());
		
		return repository.save(newRole);
	}

	@Override
	public Role addProgram(AddProgramDto dto) {
		Role role =repository.getById(dto.getRoleId());
		Program program=Prepository.getById(dto.getProgramId());
		
		role.addProgram(program);
		
		return repository.save(role);
	}

	@Override
	public Role deleteProgram(AddProgramDto dto) {
		Role role=repository.getById(dto.getRoleId());
		Program program=Prepository.getById(dto.getProgramId());
		role.removeProgram(program);
		return repository.save(role);
	}

	@Override
	public boolean isTakenName(String roleName) {		
		return repository.countByName(roleName.toUpperCase())>= 1;
	}

	@Override
	public boolean isExisted(Long roleId) {		
		return repository.existsById(roleId);
	}

	@Override
	public void deleteById(Long roleId) {
		repository.deleteById(roleId);;
	}

	@Override
	public Role updateRole(UpdateRoleDto dto) {
		Role role=repository.getById(dto.getId());
		
		role.setName(dto.getName());
		role.setDescription(dto.getDescription());
		return repository.save(role);
	}
	

	

	

	


	

	

	

	

}
