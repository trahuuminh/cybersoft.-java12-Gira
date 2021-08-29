package cybersoft.java12.gira.user.service.itf;

import java.util.List;

import cybersoft.java12.gira.user.dto.CreateUserDto;
import cybersoft.java12.gira.user.dto.UserDto;
import cybersoft.java12.gira.user.dto.UserProgramDto;
import cybersoft.java12.gira.user.entity.User;

public interface UserService {

	List<UserDto> findAllUserDto();

	boolean isTakenUsername(String username);

	boolean isTakenEmail(String email);
	
	User createUser(CreateUserDto dto);

	List<UserProgramDto> findAllProgramsOfUser(String username);
}
