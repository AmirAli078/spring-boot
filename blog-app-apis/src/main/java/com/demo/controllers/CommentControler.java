package com.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entities.Comment;
import com.demo.payloads.ApiResponse;
import com.demo.payloads.CommentDto;
import com.demo.services.CommentService;

@RestController
@RequestMapping("/api/comments")
public class CommentControler {

	@Autowired
	private CommentService commentService;
	
	// create Comments  API
	@PostMapping("/post/{postId}/comments")
	public ResponseEntity<CommentDto> createComment(
			@RequestBody CommentDto commnet, @PathVariable Integer postId){
		CommentDto createComment = this.commentService.createComment(commnet, postId);
				return new ResponseEntity<CommentDto>(createComment, HttpStatus.CREATED);
	}
	
	//Delete Comment Api
	@DeleteMapping("comments/{commentId}")
	public ResponseEntity<ApiResponse> deleteComment(@PathVariable Integer commentId){
		this.commentService.deleteComment(commentId);
		
		return new ResponseEntity<ApiResponse>(new ApiResponse("Successfully Comment Deleted!!",true), HttpStatus.OK);
	}
}
