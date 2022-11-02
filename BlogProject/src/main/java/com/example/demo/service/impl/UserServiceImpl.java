package com.example.demo.service.impl;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.payload.UserDTO;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
   private UserRepository userRepository;
	@Autowired
	private ModelMapper modelMapper;
	@Override
	public UserDTO createUser(UserDTO userDTO) {
		User user=this.dtoToUser(userDTO);
		User saveu=this.userRepository.save(user);
		// TODO Auto-generated method stub
		return this.userToDto(saveu);
	}

	@Override
	public UserDTO updateUser(Integer userId, UserDTO userDto) {
		User user=this.userRepository.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("User","Id",userId));
		// TODO Auto-generated method stub
		//user.setId(userDto.getId());
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		User updatUser=this.userRepository.save(user);
		UserDTO userDto1=this.userToDto(updatUser);
		
		return userDto1;
	}

	@Override
	public UserDTO getByid(Integer userId) {
		// TODO Auto-generated method stub
		User user=this.userRepository.findById(userId)
				.orElseThrow(()->new ResourceNotFoundException("User", "Id", userId));
		
		return this.userToDto(user);
	}

	@Override
	public List<UserDTO> getList() {
		List<User> users=this.userRepository.findAll();
		List<UserDTO> collect = users.stream().map(user->this.userToDto(user)).collect(Collectors.toList());
		// TODO Auto-generated method stub
		return collect;
	}

	@Override
	public void deletUser(Integer userId) {
		// TODO Auto-generated method stub
		User user=this.userRepository.findById(userId)
				.orElseThrow(()->new ResourceNotFoundException("User", "Id", userId));
	 this.userRepository.delete(user);
	}
	public User dtoToUser(UserDTO userDto) {
		User user=this.modelMapper.map(userDto, User.class);
		return user;
//		user.setId(userDto.getId());
//		user.setName(userDto.getName());
//		user.setEmail(userDto.getEmail());
//		user.setPassword(userDto.getPassword());
//		user.setAbout(userDto.getAbout());
//		return user;
	}
	public UserDTO userToDto(User user) {
		UserDTO userDto=this.modelMapper.map(user, UserDTO.class);
//		userDto.setId(user.getId());
//		userDto.setName(user.getName());
//		userDto.setEmail(user.getEmail());
//		userDto.setPassword(user.getPassword());
//		userDto.setAbout(user.getAbout());
		return userDto;
	}

}
