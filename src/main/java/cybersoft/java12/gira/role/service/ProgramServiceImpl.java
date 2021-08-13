package cybersoft.java12.gira.role.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cybersoft.java12.gira.role.dto.CreateProgramDto;
import cybersoft.java12.gira.role.entity.Program;
import cybersoft.java12.gira.role.repository.ProgramRepository;
import cybersoft.java12.gira.role.service.itf.ProgramService;

@Service
public class ProgramServiceImpl implements ProgramService {
	private ProgramRepository repository;
	
	public ProgramServiceImpl(ProgramRepository programRepository) {
		repository=programRepository;
	}
	
	@Override
	public List<Program> findAll() {
		return repository.findAll();
		
	}

	@Override
	public Program addNewProgram(CreateProgramDto dto) {
		Program program=new Program();
		program.setName(dto.getName());
		
		return repository.save(program);
	}

}
