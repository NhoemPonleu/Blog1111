package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Post;
import com.example.demo.payload.PostDTO;

public interface PostService {
  // PostDTO cretePost(PostDTO postDTO);
   Post updatePost(PostDTO postDTO,Integer postId);
   void deletePost(Integer postId);
   List<PostDTO>getList();
   Post getpostById(Integer postId);
   List<PostDTO>getPostByCategory(Integer categoryId);
   List<PostDTO>getPostByUser(Integer userId);
   List<Post>searchPost(String keyword);
PostDTO cretePost(PostDTO postDTO, Integer userId, Integer categoryId);


}
 