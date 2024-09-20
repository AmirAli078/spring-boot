package com.demo.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.demo.config.AppConstants;
import com.demo.payloads.ApiResponse;
import com.demo.payloads.PostDto;
import com.demo.payloads.PostResponse;
import com.demo.services.FileService;
import com.demo.services.PostService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
//this is a link through which we can access the post 
@RequestMapping("/api/")
public class PostController {
	@Autowired
	private PostService postService;
	@Autowired
	private FileService fileService;
	
	@Value("${project.image}")
	private String path;
	
	//create post Api
	@PostMapping("/user/{userId}/category/{categoryId}/posts")
        public ResponseEntity<PostDto> createPost(
        		@RequestBody PostDto postDto,
        		@PathVariable Integer userId,
        		@PathVariable Integer categoryId){
        	PostDto createPost=this.postService.createPost(postDto, categoryId, userId);
        	return new ResponseEntity<PostDto>(createPost,HttpStatus.CREATED); 
        }

	// get Post By User Id
	@GetMapping("/user/{userId}/posts")
	public ResponseEntity<List<PostDto>> getPostByUser( @PathVariable Integer userId){
		List<PostDto> post=this.postService.getAllPostsByUser(userId);
		return new ResponseEntity<List<PostDto>>(post,HttpStatus.OK);
	}
	
	//get All Posts By Category 
	
	@GetMapping("/category/{categoryId}/posts")
	public ResponseEntity<List<PostDto>> getPostByCategory(@RequestBody @PathVariable Integer categoryId){
		List<PostDto> post=this.postService.getAllPostsByCategory(categoryId);
		return new ResponseEntity<List<PostDto>>(post,HttpStatus.OK);
	}
	
	//get all Posts
	
	@GetMapping("/posts")
	public ResponseEntity<PostResponse> getAllPost(
			@RequestParam(value = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
			@RequestParam(value = "pageSize",defaultValue = AppConstants.PAGE_SIZE,required = false) Integer pageSize,
			@RequestParam(value = "sortBy", defaultValue = AppConstants.SORT_BY, required = false) String sortBy
			){
		PostResponse postResponse=this.postService.getAllPosts(pageNumber, pageSize,sortBy);
		return new ResponseEntity<PostResponse>(postResponse,HttpStatus.OK);
	}
	
	//get single Post 
	@GetMapping("/posts/{postId}")
	public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId){
		PostDto postDto=this.postService.getPostById(postId);
		return new ResponseEntity<PostDto>(postDto,HttpStatus.OK);
	}
	
	//Delete A post by id
	
	@DeleteMapping("posts/{postId}")
	public ApiResponse deletePost(@PathVariable Integer postId) {
		this.postService.deletePost(postId);
		return new ApiResponse("Post is Successfully Deleted!! ",true);
	}
	
	//update a post By Post id
	
	@PutMapping("posts/{postId}")
	public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto ,@PathVariable Integer postId){
		PostDto updatedPost=this.postService.updatePost(postDto, postId);
		return new ResponseEntity<PostDto>(updatedPost,HttpStatus.OK);
	}
	
	//Search post By title keywords 
	@GetMapping("/posts/search/{keywords}")
	public ResponseEntity<List<PostDto>> searchPostByTitle(@PathVariable("keywords") String keywords){
		List<PostDto> result=this.postService.searchPostByTitle(keywords);
		return new ResponseEntity<List<PostDto>>(result,HttpStatus.OK);
	}
	
	//Post Image upload
	@PostMapping("/post/image/upload/{postId}")
	public ResponseEntity<PostDto> uploadImage(@RequestParam("image") MultipartFile image,
			@PathVariable Integer postId) throws IOException{
		PostDto postDtos=this.postService.getPostById(postId);
		String fileName=this.fileService.uploadImage(path, image);
		postDtos.setImageName(fileName);
		PostDto updatePost=this.postService.updatePost(postDtos, postId);
		return new ResponseEntity<PostDto>(updatePost,HttpStatus.OK);
		
	}
	
	//get image 
	@GetMapping(value = "/post/image/{imageName}", produces=MediaType.IMAGE_JPEG_VALUE)
	public void downloadImage(@PathVariable("imageName") String imageName,
			HttpServletResponse response) throws IOException {
		InputStream resource=this.fileService.getResource(path, imageName);
		response.setContentType(MediaType.IMAGE_JPEG_VALUE);
		StreamUtils.copy(resource, response.getOutputStream());
		
	}
	
}
