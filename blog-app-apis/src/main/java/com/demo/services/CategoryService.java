package com.demo.services;

import java.util.List;

import com.demo.payloads.CategoryDto;

public interface CategoryService {
	
	//create method
	public CategoryDto createCatgeory(CategoryDto categoryDto);
	
	//update method
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);
	
	//Delete Method
	public void deleteCategory(Integer categoryId);
	
	//get method 
	public CategoryDto getCategory( Integer categoryId);

	
	//getAll method
	public List<CategoryDto> getCategories();

}
