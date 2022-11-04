package com.example.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Category;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.payload.CategoryDTO;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.CategoryService;
@Service
public class CategoryServiceImple implements CategoryService{
	@Autowired
     private CategoryRepository categoryRepository;
	@Autowired
	private ModelMapper modelMapper;
	public CategoryDTO createCategory(CategoryDTO categoryDTO) {
		Category cat=this.modelMapper.map(categoryDTO, Category.class);
		Category addcat=this.categoryRepository.save(cat);
		
		// TODO Auto-generated method stub
		return this.modelMapper.map(addcat,CategoryDTO.class);
	}

	@Override
	public CategoryDTO updateCategory(Integer categoryId, CategoryDTO categoryDTO) {
		Category cat = this.categoryRepository.findById(categoryId).orElseThrow(()->
		new ResourceNotFoundException("Category","Category Id",categoryId));
		cat.setCategoryDescription(categoryDTO.getCategoryDescription());
		cat.setCategoryTitle(categoryDTO.getCategoryTitle());
		Category update=this.categoryRepository.save(cat);
		// TODO Auto-generated method stub
		return this.modelMapper.map(update, CategoryDTO.class);
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		// TODO Auto-generated method stub
		Category cat = this.categoryRepository.findById(categoryId).orElseThrow(()->
		new ResourceNotFoundException("Category","Category Id",categoryId));
		this.categoryRepository.delete(cat);;
	}

	@Override
	public CategoryDTO getById(Integer categoryId) {
		// TODO Auto-generated method stub
		Category cat = this.categoryRepository.findById(categoryId).orElseThrow(()->
		new ResourceNotFoundException("Category","Category Id",categoryId));
		return this.modelMapper.map(cat, CategoryDTO.class);
	}

	@Override
	public List<CategoryDTO> getList() {
		List<Category> list = this.categoryRepository.findAll();
		// TODO Auto-generated method stub
		List<CategoryDTO> collect = list.stream().map((cat)->this.modelMapper.map(cat, CategoryDTO.class)).collect(Collectors.toList());
		return collect;
	}

	

}
