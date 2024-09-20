package com.demo.services.impli;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.Comment;
import com.demo.entities.Post;
import com.demo.exceptions.ResourceNotFoundException;
import com.demo.payloads.CommentDto;
import com.demo.repositry.CommentRepo;
import com.demo.repositry.PostRepo;
import com.demo.services.CommentService;

@Service
public class CommentServiceImpli implements CommentService {

	@Autowired
	private PostRepo postRepo;
	@Autowired
	private CommentRepo commentRepo;
	@Autowired
	private ModelMapper modelMapper;
	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId) {
		Post post=this.postRepo.findById(postId)
				.orElseThrow(()-> new ResourceNotFoundException("post", "post Id", postId));
		Comment comment = this.modelMapper.map(commentDto, Comment.class);
		comment.setPost(post);
		//Comment savedComment = this.commentRepo.save(comment);
		Comment savedComment = this.commentRepo.save(comment);
		return this.modelMapper.map(savedComment, CommentDto.class);
	}

	@Override
	public void deleteComment(Integer commentId) {
		Comment com=commentRepo.findById(commentId)
		.orElseThrow(()->new ResourceNotFoundException("Comment", "Comment ID", commentId));
		this.commentRepo.delete(com);

	}

}
