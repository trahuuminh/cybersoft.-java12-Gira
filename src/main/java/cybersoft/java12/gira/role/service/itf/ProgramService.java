package cybersoft.java12.gira.role.service.itf;

import java.util.List;

import cybersoft.java12.gira.role.dto.CreateProgramDto;
import cybersoft.java12.gira.role.dto.ProgramDto;
import cybersoft.java12.gira.role.entity.Program;


public interface ProgramService {
	List<ProgramDto> findAll();

	Program addNewProgram(CreateProgramDto dto);
}
