package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.payload.ApiResponse;
import com.example.demo.payload.UserDTO;
import com.example.demo.service.UserService;

import lombok.Delegate;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	@PostMapping
  public ResponseEntity<UserDTO>create(@Valid  @RequestBody UserDTO userDTO){
	  UserDTO user=this.userService.createUser(userDTO);
	  return new ResponseEntity<UserDTO>(user,HttpStatus.CREATED);
  }
	@PutMapping("/{userId}")
	public ResponseEntity<UserDTO>updatUser(@Valid  @RequestBody UserDTO userDTO, @PathVariable Integer userId){
		UserDTO updatuserdto=this.userService.updateUser(userId, userDTO);
		return ResponseEntity.ok(updatuserdto);
	}
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse>deleteUser(@PathVariable("userId") Integer uid){
		this.userService.deletUser(uid);
		return new ResponseEntity(new ApiResponse("sucesfully", true),HttpStatus.OK);
	}
	@GetMapping()
	public ResponseEntity<List<UserDTO>>getALlUser(){
		return  ResponseEntity.ok(this.userService.getList());
		
	}
	@GetMapping("/{userId}")
	public ResponseEntity<UserDTO>getById(@PathVariable Integer userId){
		return  ResponseEntity.ok(this.userService.getByid(userId));
	}
	
}
