package cybersoft.java12.gira.role.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cybersoft.java12.gira.role.dto.RoleDto;
import cybersoft.java12.gira.role.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	
	@Transactional(readOnly = true)
	@Query("SELECT r FROM Role r")
	List<RoleDto> findAllDto();

	
	int countByName(String roleName);


	

	
}
