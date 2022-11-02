package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.payload.ApiResponse;
import com.example.demo.payload.CategoryDTO;
import com.example.demo.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	@PostMapping("/")
  public ResponseEntity<CategoryDTO>createCat(@Valid @RequestBody CategoryDTO categoryDTO){
	  CategoryDTO createCategory = this.categoryService.createCategory(categoryDTO);
	  return new ResponseEntity<CategoryDTO>(createCategory,HttpStatus.CREATED);
  }
	@PutMapping("/{categoryId}")
	public ResponseEntity<CategoryDTO>updatCat(@Valid @PathVariable Integer categoryId,@RequestBody CategoryDTO categoryDTO){
		CategoryDTO updateCategory = this.categoryService.updateCategory(categoryId, categoryDTO);
		return new ResponseEntity<CategoryDTO>(updateCategory,HttpStatus.OK);
		
	}
	@DeleteMapping("/{categoryId}")
	public ResponseEntity<ApiResponse> deleteCat(@PathVariable Integer categoryId){
		this.categoryService.deleteCategory(categoryId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("delete succes",true),HttpStatus.OK);
	}
	@GetMapping("/{categoryId}")
	public ResponseEntity<CategoryDTO>findById(@PathVariable Integer categoryId){
		return ResponseEntity.ok(this.categoryService.getById(categoryId));
	}
	@GetMapping("/list")
	public ResponseEntity<List<CategoryDTO>>getList(){
		return ResponseEntity.ok(this.categoryService.getList());
	}
}
