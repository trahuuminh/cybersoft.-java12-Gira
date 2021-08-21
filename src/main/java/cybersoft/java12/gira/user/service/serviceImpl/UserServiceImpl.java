package cybersoft.java12.gira.user.service.serviceImpl;



import java.util.List;


import org.springframework.stereotype.Service;

import cybersoft.java12.gira.user.dto.CreateUserDto;
import cybersoft.java12.gira.user.dto.UserDto;
import cybersoft.java12.gira.user.entity.User;
import cybersoft.java12.gira.user.repository.UserRepository;
import cybersoft.java12.gira.user.service.itf.UserService;
import cybersoft.java12.gira.user.util.UserStatus;

@Service
public class UserServiceImpl implements UserService {
	private UserRepository repository;

	
	public UserServiceImpl(UserRepository userRepository) {
		repository=userRepository;
	}

	@Override
	public List<UserDto> findAllUserDto() {
		return repository.findAllUserDto();
	}

	@Override
	public boolean isTakenUsername(String username) {
		if(repository.countByUsername(username.toLowerCase())>0)
			return true;
		return false;
	}

	@Override
	public boolean isTakenEmail(String email) {
		if(repository.countByEmail(email.toLowerCase())>0)
			return true;
		return false;
	}

	@Override
	public User createUser(CreateUserDto dto) {
		User user=new User();
		
		user.setUsername(dto.getUsername());
		user.setEmail(dto.getEmail());
		user.setPassword(dto.getPassword());// encode password trước khi set
		user.setStatus(UserStatus.ACTIVE);
		
		return repository.save(user);
	}
	
	
	
}
