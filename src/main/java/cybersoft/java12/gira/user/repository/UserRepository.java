package cybersoft.java12.gira.user.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cybersoft.java12.gira.user.dto.UserDto;
import cybersoft.java12.gira.user.dto.UserProgramDto;
import cybersoft.java12.gira.user.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	

	@Query("SELECT u FROM User u")
	List<UserDto> findAllUserDto();
	
	int countByUsername(String name);

	int countByEmail(String email);
	
	@Query("SELECT u FROM User u LEFT JOIN FETCH u.groups WHERE u.username= ?1")// nếu không có JOIN FETCH sẽ sinh ra 2 câu SQL, sẽ dư ra 1 câu SELECT groups
	Optional<User> findByUserNameWithGroups(String username);
	
	@Query("SELECT p.name AS name, p.method AS method, p.path AS path FROM User u JOIN u.groups g JOIN g.roles r JOIN r.programs p WHERE u.username = ?1")
	List<UserProgramDto> findAllProgramsByUsername(String username);
}	
