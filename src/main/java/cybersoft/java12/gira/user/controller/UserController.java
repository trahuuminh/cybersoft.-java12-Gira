package cybersoft.java12.gira.user.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cybersoft.java12.gira.common.ResponseHandler;
import cybersoft.java12.gira.user.dto.AddToCart;
import cybersoft.java12.gira.user.dto.CreateUserDto;
import cybersoft.java12.gira.user.dto.UserDto;
import cybersoft.java12.gira.user.dto.UserProgramDto;
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
	
	@GetMapping("/{username}/programs")
	public Object getAllProgramsOfUser(@PathVariable("username") String username ) {
		List<UserProgramDto> programs = service.findAllProgramsOfUser(username);
		/*
		 * 	path: /api/user/%/programs
		 *  thực tế: /api/user/admin/programs
		 */
		"/api/user/admin/programs".matches("/api/user/%/programs");
		
		return ResponseHandler.getResponse(programs, HttpStatus.OK);
	}
	
	@PostMapping("/createuser")
	public Object createNewUser(@Valid @RequestBody CreateUserDto dto, BindingResult errors) {
		if(errors.hasErrors()) {
			return ResponseHandler.getResponse(errors,HttpStatus.BAD_REQUEST);
		}
		User newUser=service.createUser(dto);
		
		return ResponseHandler.getResponse(newUser, HttpStatus.CREATED);
		
	}
	
	@PostMapping("/add-to-cart")
	public Object addToCart(@Valid @RequestBody AddToCart dto,BindingResult errors) {
		if(errors.hasErrors())
			return ResponseHandler.getResponse(errors,HttpStatus.BAD_REQUEST);
		
		User user=service.addToCart(dto);
		
		return ResponseHandler.getResponse(user,HttpStatus.OK);
	}
}
