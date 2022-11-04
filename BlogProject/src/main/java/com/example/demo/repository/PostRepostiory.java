package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Category;
import com.example.demo.entity.Post;
import com.example.demo.entity.User;

public interface PostRepostiory extends JpaRepository<Post, Integer>{
  List<Post>findByuser(User user);
 List<Post> findByCategory(Category category);
}
