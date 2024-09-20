package com.demo.repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entities.Category;
import com.demo.entities.Post;
import com.demo.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer>{
	
	// Create custom methods 
	//search post by user or get all post of user
	//interface by-default put public in methods 
	public List<Post> findByUser(User user);
	
	//search or find posts by category 
	List<Post> findByCategory(Category category);
	
	List<Post> findByTitleContaining(String title);


}
