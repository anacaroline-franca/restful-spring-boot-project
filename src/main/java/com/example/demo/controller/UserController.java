package com.example.demo.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDto;
import com.example.demo.model.request.UserDetailsRequestModel;
import com.example.demo.model.response.UserRest;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping
	public String getUsers() {
		return "getUsers method";
	}
	
	@PostMapping
	public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails) {
		UserRest returnValue = new UserRest();
		
		UserDto userDTO = new UserDto();
		BeanUtils.copyProperties(userDetails, userDTO);
		
		UserDto createdUser = userService.createUser(userDTO);
		BeanUtils.copyProperties(createdUser, returnValue);
		
		return returnValue;
	}
	
	@PutMapping
	public String updateUser() {
		return "updateUser method";
	}
	
	@DeleteMapping
	public String deleteUser() {
		return "deleteUser method";
	}
}
