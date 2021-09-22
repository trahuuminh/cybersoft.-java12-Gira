package cybersoft.java12.gira.user.service.serviceImpl;



import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cybersoft.java12.gira.product.entity.Order;
import cybersoft.java12.gira.product.entity.Product;
import cybersoft.java12.gira.product.repository.OrderRepository;
import cybersoft.java12.gira.product.repository.ProductRepository;
import cybersoft.java12.gira.user.dto.AddOrder;
import cybersoft.java12.gira.user.dto.AddToCart;
import cybersoft.java12.gira.user.dto.CreateUserDto;
import cybersoft.java12.gira.user.dto.UserDto;
import cybersoft.java12.gira.user.dto.UserProgramDto;
import cybersoft.java12.gira.user.entity.User;
import cybersoft.java12.gira.user.repository.UserRepository;
import cybersoft.java12.gira.user.service.itf.UserService;
import cybersoft.java12.gira.user.util.UserStatus;

@Service
public class UserServiceImpl implements UserService {
	private UserRepository repository;
	private PasswordEncoder encoder;
	private ProductRepository productRepo;
	private OrderRepository orderRepo;
	
	public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, ProductRepository productRepository, OrderRepository orderRepository) {
		repository=userRepository;
		encoder=passwordEncoder;
		productRepo=productRepository;
		orderRepo=orderRepository;
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
		user.setPassword(encoder.encode(dto.getPassword()));// encode password trước khi set
		user.setStatus(UserStatus.ACTIVE);
		
		return repository.save(user);
	}
	
	@Override
	public List<UserProgramDto> findAllProgramsOfUser(String username) {
		return repository.findAllProgramsByUsername(username);
	}

	@Override
	@Transactional
	public User addToCart(AddToCart dto) {
		Product product=productRepo.getById(dto.getProductId());
		User user=repository.getById(dto.getUserId());
		
		user.getRecentCart().add(product);
		return repository.save(user);
	}

	@Override
	public User addOrder(AddOrder dto) {
		User user=repository.getById(dto.getUserId());
		Order order=orderRepo.getById(dto.getOrderId());
				
		return user.addOrder(order);
	}
	
}
