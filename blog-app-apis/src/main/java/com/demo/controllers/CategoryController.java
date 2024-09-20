package com.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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

import com.demo.payloads.ApiResponse;
import com.demo.payloads.CategoryDto;
import com.demo.services.CategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;

	//create APIs
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto){
		
		CategoryDto createdCategory=this.categoryService.createCatgeory(categoryDto);
		return new ResponseEntity<CategoryDto>(createdCategory,HttpStatus.CREATED);
	}
	
	//update APIs 
	
	@PutMapping("/{catId}")
	public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto,@PathVariable Integer catId ){
		
		CategoryDto updateCategory=this.categoryService.updateCategory(categoryDto,catId);
		return new ResponseEntity<CategoryDto>(updateCategory,HttpStatus.OK);
	}
	
	//delete APIs
	
	@DeleteMapping("/{catId}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer catId ){
		
		this.categoryService.deleteCategory(catId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Category is deleted successfully",true)
				, HttpStatus.OK);
	}
	
	//get single APIs
	@GetMapping("/{catId}")
	public ResponseEntity<CategoryDto> getCategory(@PathVariable Integer catId ){
		
		CategoryDto getCategory =this.categoryService.getCategory(catId);
		return new ResponseEntity<CategoryDto>(getCategory,HttpStatus.OK);
	}
	
	//get all APIs 
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getCategories(){
		
		List<CategoryDto> getAllCategory =this.categoryService.getCategories();
		return ResponseEntity.ok(getAllCategory);
	}
	
}
