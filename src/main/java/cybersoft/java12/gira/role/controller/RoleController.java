package cybersoft.java12.gira.role.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cybersoft.java12.gira.common.ResponseHandler;
import cybersoft.java12.gira.role.dto.AddProgramDto;
import cybersoft.java12.gira.role.dto.CreateRoleDto;
import cybersoft.java12.gira.role.dto.RoleDto;
import cybersoft.java12.gira.role.dto.UpdateRoleDto;
import cybersoft.java12.gira.role.entity.Role;
import cybersoft.java12.gira.role.service.itf.RoleService;



@RestController
@RequestMapping("/api/role")
public class RoleController {
	private RoleService service;
	
	public RoleController(RoleService roleService) {
		service = roleService;
	}
	
	@GetMapping
	public Object findAllRole() {
		List<RoleDto> roles = service.findAll();
		
		return ResponseHandler.getResponse(roles, HttpStatus.OK);
	}
	
	
	
	
	@PostMapping
	public Object saveRole(@Valid @RequestBody CreateRoleDto dto, BindingResult errors) {
		if(errors.hasErrors())
			return ResponseHandler.getResponse(errors,HttpStatus.BAD_REQUEST);
		
		Role addedRole = service.addNewRole(dto);
		
		return ResponseHandler.getResponse(addedRole, HttpStatus.CREATED);
	}
	
	@PostMapping("/add-program")
	public Object addProgram(@Valid @RequestBody AddProgramDto dto,BindingResult errors) {
		if(errors.hasErrors())
			return ResponseHandler.getResponse(errors, HttpStatus.BAD_REQUEST);
			
		Role updatedRole=service.addProgram(dto);
		
		return ResponseHandler.getResponse(updatedRole, HttpStatus.OK);
	}
	
	@PostMapping("/remove-program")
	public Object deleteProgram(@Valid @RequestBody AddProgramDto dto, BindingResult errors) {
		if(errors.hasErrors())
			return ResponseHandler.getResponse(errors, HttpStatus.BAD_REQUEST);
		Role role=service.deleteProgram(dto);
		
		return ResponseHandler.getResponse(role, HttpStatus.OK);
		
	}
	
	@PutMapping
	public Object updateRole(@Valid @RequestBody UpdateRoleDto dto, BindingResult errors) {
		if(errors.hasErrors())
			return ResponseHandler.getResponse(errors, HttpStatus.BAD_REQUEST);
		return null;
	}
	
}