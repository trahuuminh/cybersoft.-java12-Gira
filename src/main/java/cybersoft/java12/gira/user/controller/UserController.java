package cybersoft.java12.gira.user.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cybersoft.java12.gira.common.ResponseHandler;
import cybersoft.java12.gira.user.dto.CreateUserDto;
import cybersoft.java12.gira.user.dto.UserDto;
import cybersoft.java12.gira.user.entity.User;
import cybersoft.java12.gira.user.service.itf.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	private UserService service;
	
	public UserController(UserService userService) {
		service =userService;
	}
	
	@GetMapping
	public Object findAllUser() {
		List<UserDto>users=service.findAllUserDto();
		return ResponseHandler.getResponse(users, HttpStatus.OK);
	}
	
	@PostMapping
	public Object createNewUser(@Valid @RequestBody CreateUserDto dto, BindingResult errors) {
		if(errors.hasErrors()) {
			return ResponseHandler.getResponse(errors,HttpStatus.BAD_REQUEST);
		}
		User newUser=service.createUser(dto);
		
		return ResponseHandler.getResponse(newUser, HttpStatus.CREATED);
		
	}
}
