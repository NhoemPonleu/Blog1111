package com.example.demo.service;

import java.util.List;

import com.example.demo.payload.CategoryDTO;

public interface CategoryService {
   CategoryDTO createCategory(CategoryDTO categoryDTO);
   CategoryDTO updateCategory(Integer categoryId,CategoryDTO categoryDTO );
   void deleteCategory(Integer categoryId);
   CategoryDTO getById(Integer categoryId);
   List<CategoryDTO>getList();
}
