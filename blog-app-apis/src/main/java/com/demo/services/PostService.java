package com.demo.services;

import java.util.List;

import com.demo.payloads.PostDto;
import com.demo.payloads.PostResponse;

public interface PostService {

	//Create Post 
	//Interface put public if you use it or not
	public PostDto createPost(PostDto postDto, Integer categoryId, Integer userId);
	
	//update post
	PostDto updatePost(PostDto postDto, Integer postId);
	
	//Delete Post 
	void deletePost(Integer postId);
	
	//get All Posts
    PostResponse getAllPosts(Integer pageNumber, Integer pageSize, String sortBy);
   
   //get Single Post 
   PostDto getPostById(Integer postId);
   
   //get All Post By Category
   List<PostDto> getAllPostsByCategory(Integer categoryId);
   
   //get All Posts By USer
   List<PostDto> getAllPostsByUser(Integer userId);
   
   //Search post
   List<PostDto> searchPostByTitle(String keywords);
}
