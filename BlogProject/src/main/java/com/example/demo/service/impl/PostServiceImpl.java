package com.example.demo.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Category;
import com.example.demo.entity.Post;
import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.payload.PostDTO;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.PostRepostiory;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.PostService;
@Service
public class PostServiceImpl implements PostService{

	@Autowired
  private PostRepostiory postRepostiory;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ModelMapper modelMapper;
	@Override
	public Post updatePost(PostDTO postDTO, Integer postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePost(Integer postId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PostDTO> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post getpostById(Integer postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostDTO> getPostByCategory(Integer categoryId) {
		Category category = this.categoryRepository.findById(categoryId)
		.orElseThrow(()->new ResourceNotFoundException("Category", "categoryId", categoryId));
		List<Post> list = this.postRepostiory.findByCategory(category);
		List<PostDTO> collect = list.stream().map(post->this.modelMapper.map(post, PostDTO.class)).collect(Collectors.toList());
		return collect;
				
			
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PostDTO> getPostByUser(Integer userId) {
		User user=this.userRepository.findById(userId)
				.orElseThrow(()->new ResourceNotFoundException("User", "user Id", userId));
		List<Post>list=this.postRepostiory.findByuser(user);
	      List<PostDTO>post=list.stream().map(post1->this.modelMapper.map(post1, PostDTO.class)).collect(Collectors.toList());
	 return post;
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Post> searchPost(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PostDTO cretePost(PostDTO postDTO, Integer userId, Integer categoryId) {
		// TODO Auto-generated method stub
		
	User user=this.userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","User Id", userId));
	Category cat=this.categoryRepository.findById(categoryId)
			.orElseThrow(()->new ResourceNotFoundException("Category", "category Id", categoryId));
	// TODO Auto-generated method stub
	Post post = this.modelMapper.map(postDTO, Post.class);
	post.setImmage("default.png");
	post.setAddDate(new Date());
	post.setUser(user);
	post.setCategory(cat);
	Post save = this.postRepostiory.save(post);
	return this.modelMapper.map(save, PostDTO.class);
	
		
	}

}
