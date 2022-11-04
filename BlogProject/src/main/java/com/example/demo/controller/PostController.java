package com.example.demo.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Post;
import com.example.demo.payload.PostDTO;
import com.example.demo.service.CategoryService;
import com.example.demo.service.PostService;
import com.example.demo.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/")

public class PostController {
	@Autowired
	private PostService postService;
//	@Autowired
//	private CategoryService categoryService;
//	@Autowired
//	private UserService userService;
//	@Autowired
//	private ModelMapper modelMapper;
	

	@PostMapping("/user/{userId}/category/{categoryId}")
  public ResponseEntity<PostDTO>createPost(
		  @RequestBody PostDTO postDTO,
		  @PathVariable Integer userId,
		  @PathVariable Integer categoryId){
		PostDTO cretePost = this.postService.cretePost(postDTO,userId,categoryId);
	  return new ResponseEntity<PostDTO>(cretePost,HttpStatus.CREATED);
  }
	@GetMapping("/user/{userId}/post")
	public ResponseEntity<List<PostDTO>>getUser(@PathVariable Integer userId){
	   List<PostDTO> postByUser = this.postService.getPostByUser(userId);
		
		return new ResponseEntity<List<PostDTO>>(postByUser,HttpStatus.OK);
	}
	@GetMapping("/category/{categoryId}/post")
	public ResponseEntity<List<PostDTO>>getcategory(@PathVariable Integer categoryId){
		List<PostDTO> postByCategory = this.postService.getPostByCategory(categoryId);
		return new ResponseEntity<List<PostDTO>>(postByCategory,HttpStatus.OK);
	}
}
