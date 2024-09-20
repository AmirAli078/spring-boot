package com.demo.services.impli;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.Category;
import com.demo.exceptions.ResourceNotFoundException;
import com.demo.payloads.CategoryDto;
import com.demo.repositry.CategoryRepo;
import com.demo.services.CategoryService;
@Service
public class CategoryServiceImpli implements CategoryService {
	
	@Autowired
	private CategoryRepo categoryRep;
	@Autowired
	private ModelMapper modelMaper;

	
	@Override
	public CategoryDto createCatgeory(CategoryDto categoryDto) {
		Category cat=this.modelMaper.map(categoryDto, Category.class);
		Category addedCat=this.categoryRep.save(cat);
		return this.modelMaper.map(addedCat, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
		Category cat=this.categoryRep.findById(categoryId)
				.orElseThrow(()-> new ResourceNotFoundException("Category", "Catgeory Id", categoryId));
		cat.setCategoryTitle(categoryDto.getCategoryTitle());
		cat.setCategoryDescription(categoryDto.getCategoryDescription());
		Category updatedCat=this.categoryRep.save(cat);
		return this.modelMaper.map(updatedCat, CategoryDto.class);
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		Category cat=this.categoryRep.findById(categoryId)
				.orElseThrow(()-> new ResourceNotFoundException("category", "catgeory Id", categoryId));
		this.categoryRep.delete(cat);

	}

	@Override
	public CategoryDto getCategory(Integer categoryId) {
		Category cat=this.categoryRep.findById(categoryId)
				.orElseThrow(()-> new ResourceNotFoundException("category", "Category Id", categoryId));
		return this.modelMaper.map(cat, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getCategories() {
		List<Category> categories=this.categoryRep.findAll();
		List<CategoryDto> catDtos=categories.stream().map((cat)-> this.modelMaper.map(cat, CategoryDto.class)).collect(Collectors.toList());
		return catDtos;
	}

}
