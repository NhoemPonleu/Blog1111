package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.User;
import com.example.demo.payload.UserDTO;

public interface UserService {
	UserDTO createUser(UserDTO user);
	UserDTO updateUser(Integer id,UserDTO user);
	UserDTO getByid(Integer userId);
	List<UserDTO>getList();
	void deletUser(Integer userId);
}
