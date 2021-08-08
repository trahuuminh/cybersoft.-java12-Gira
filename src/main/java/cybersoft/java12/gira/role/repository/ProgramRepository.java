package cybersoft.java12.gira.role.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cybersoft.java12.gira.role.entity.Program;



@Repository
public interface ProgramRepository extends JpaRepository<Program, Long> {
	
}
