package com.example.demo.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="posts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Post {
	@Id
@GeneratedValue(strategy = GenerationType.AUTO)

  private int postId;
	@Column(name="post_title",length = 100,nullable = false)
  private String title;
	@Column(length = 10000)
  private String content;
  private String immage;
  private Date addDate;
  @ManyToOne
  @JoinColumn(name="category_id")
  private Category category;
  @ManyToOne
  private User user;
}
