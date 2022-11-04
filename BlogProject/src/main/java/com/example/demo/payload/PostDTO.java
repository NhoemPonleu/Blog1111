package com.example.demo.payload;

import java.util.Date;

import com.example.demo.entity.Category;
import com.example.demo.entity.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class PostDTO {
  private String title;
  private String content;
  private String immage;
  private Date addDate;
  private CategoryDTO category;
  private UserDTO user;
}
