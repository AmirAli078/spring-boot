package com.demo.services.impli;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.demo.entities.Category;
import com.demo.entities.Post;
import com.demo.entities.User;
import com.demo.exceptions.ResourceNotFoundException;
import com.demo.payloads.PostDto;
import com.demo.payloads.PostResponse;
import com.demo.repositry.CategoryRepo;
import com.demo.repositry.PostRepo;
import com.demo.repositry.UserRepo;
import com.demo.services.PostService;

@Service
public class PostServiceImpli implements PostService {

	@Autowired
	private PostRepo postRepo;
	@Autowired
	private CategoryRepo categoryRepo;
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private ModelMapper modelMaper;
	
	@Override
	public PostDto createPost(PostDto postDto,Integer categoryId, Integer userId) {
		
		User user=this.userRepo.findById(userId)
				.orElseThrow(()->new ResourceNotFoundException("User", "User Id", userId));
		Category category=this.categoryRepo.findById(categoryId)
		.orElseThrow(()-> new ResourceNotFoundException("Catgegory", "Category Id", categoryId));
		
		Post post=modelMaper.map(postDto, Post.class);
		post.setImageName("Default.png");
		post.setAddedDate(new Date());
		post.setUser(user);
		post.setCategory(category);
		
	     Post newPost=this.postRepo.save(post);
		return this.modelMaper.map(newPost, PostDto.class);
	}

	@Override
	public PostDto updatePost(PostDto postDto, Integer postId) {
		Post post=this.postRepo.findById(postId)
		.orElseThrow(()-> new ResourceNotFoundException("Post", "post Id", postId));
		post.setTitle(postDto.getTitle());
		post.setContent(postDto.getContent());
		Post updatedPost=this.postRepo.save(post);
		return this.modelMaper.map(updatedPost, PostDto.class);
	}

	@Override
	public void deletePost(Integer postId) {
		Post post=this.postRepo.findById(postId)
				.orElseThrow(()->new ResourceNotFoundException("Post", "Post Id", postId));
		this.postRepo.delete(post);

	}

	@Override
	public PostResponse getAllPosts(Integer pageNumber, Integer pageSize, String sortBy) {
		
		Pageable p =PageRequest.of(pageNumber,pageSize, Sort.by(sortBy));
		
	Page<Post> pagePost=  this.postRepo.findAll(p);
		List<Post> posts=pagePost.getContent();
		List<PostDto> postDtos=posts.stream()
				.map((post)->this.modelMaper.map(post, PostDto.class)).collect(Collectors.toList());
		PostResponse postResponse =new PostResponse();	
		postResponse.setContent(postDtos);
		postResponse.setPageNumber(pagePost.getNumber());
		postResponse.setPageSize(pagePost.getSize());
		postResponse.setElements(pagePost.getTotalElements());
		postResponse.setPages(pagePost.getTotalPages());
		postResponse.setLast(pagePost.isLast());
		return postResponse;
	}

	@Override
	public PostDto getPostById(Integer postId) {
		Post post=this.postRepo.findById(postId)
		.orElseThrow(()->new ResourceNotFoundException("post", "post Id", postId));
		return this.modelMaper.map(post, PostDto.class);
	}

	@Override
	public List<PostDto> getAllPostsByCategory(Integer categoryId) {
		Category category=this.categoryRepo.findById(categoryId)
				.orElseThrow(()->new ResourceNotFoundException("catgeory", "category Id", categoryId));
		List<Post> posts=this.postRepo.findByCategory(category);
		List<PostDto> postDtos=posts.stream()
				.map((post)->this.modelMaper.map(post, PostDto.class)).collect(Collectors.toList());
		return postDtos;
	}

	@Override
	public List<PostDto> getAllPostsByUser(Integer userId) {
		User user=this.userRepo.findById(userId)
				.orElseThrow(()->new ResourceNotFoundException("User", "user Id", userId));
		List<Post> posts=this.postRepo.findByUser(user);
		List<PostDto> postDtos=posts.stream()
				.map((post)->this.modelMaper.map(post, PostDto.class)).collect(Collectors.toList());
		return postDtos;
	}

	@Override
	public List<PostDto> searchPostByTitle(String keywords) {
		List<Post> posts=this.postRepo.findByTitleContaining(keywords);
		List<PostDto> postDtos=posts.stream()
				.map((post)->this.modelMaper.map(post, PostDto.class)).collect(Collectors.toList());
	
		return postDtos;
	}

}
