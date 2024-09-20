package com.demo.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.payloads.UserDto;
import com.demo.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//Post -> create user
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
		UserDto createUserDto=this.userService.createUser(userDto);
		return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
	}
	
	//put -> Update User
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updatedUser(@Valid @RequestBody UserDto userDto, @PathVariable("userId") Integer uId)
	{
		UserDto updatedUser=this.userService.updateUser(userDto, uId);
		return ResponseEntity.ok(updatedUser);
	}
	
	//Delete -> Delete user
	@DeleteMapping("/{userId}")
	public ResponseEntity<?> deleteUser(@Valid @PathVariable("userId") Integer uid)
	{
		this.userService.deleteUser(uid);
		return ResponseEntity.ok(Map.of("message","User is Deleted Successfully!"));
	}
	
	//Get AllUser -> Get
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUsers()
	{
		return ResponseEntity.ok(this.userService.getAllUsers());
	}
 
	//Get UserById -> Get
		@GetMapping("/{userId}")
		public ResponseEntity<UserDto> getUserById(@Valid @PathVariable("userId") Integer uid)
		{
			return ResponseEntity.ok(this.userService.getUserById(uid));
		}
	 
	
}
