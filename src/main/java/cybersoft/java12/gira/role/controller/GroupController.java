package cybersoft.java12.gira.role.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cybersoft.java12.gira.common.ResponseHandler;
import cybersoft.java12.gira.role.dto.CreateGroupDto;
import cybersoft.java12.gira.role.entity.Group;
import cybersoft.java12.gira.role.service.itf.GroupService;


@RestController
@RequestMapping("/api/group")
public class GroupController {
	private GroupService service;
	
	public GroupController(GroupService groupService) {
		service=groupService;
	}
	
	@GetMapping
	public Object findAllGroup() {
		List<Group>groups=service.findAll();
		return  ResponseHandler.getResponse(groups, HttpStatus.OK);
	}
	
	@PostMapping
	public Object saveGroup(@Valid @RequestBody CreateGroupDto dto, BindingResult errors) {
		if(errors.hasErrors())
			return new ResponseEntity<>(errors.getAllErrors(), HttpStatus.BAD_REQUEST);
		Group group=service.addNewGroup(dto);		
		
		return ResponseHandler.getResponse(group, HttpStatus.CREATED);
	}
}
