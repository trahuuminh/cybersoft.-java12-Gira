package cybersoft.java12.gira.user.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cybersoft.java12.gira.user.dto.UserDto;
import cybersoft.java12.gira.user.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	

	@Query("SELECT u FROM User u")
	List<UserDto> findAllUserDto();
	
	int countByUsername(String name);

	int countByEmail(String email);
	
	@Query("SELECT u FROM User u JOIN FETCH u.groups")// nếu không có JOIN FETCH sẽ sinh ra 2 câu SQL, sẽ dư ra 1 câu SELECT groups
	Optional<User> findByUserNameWithGroups(String username);
}	
