package com.demo.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entities.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer>{

	//Comment save(Comment comment);

}
