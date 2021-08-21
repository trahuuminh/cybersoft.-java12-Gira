package cybersoft.java12.gira.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cybersoft.java12.gira.user.dto.UserDto;
import cybersoft.java12.gira.user.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	

	@Query("SELECT u FROM User u")
	List<UserDto> findAllUserDto();
	
	int countByUsername(String name);

	int countByEmail(String email);
}	
