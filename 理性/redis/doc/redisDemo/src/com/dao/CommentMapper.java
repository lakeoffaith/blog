package com.dao;

import java.util.List;

import com.modal.Comment;

public interface CommentMapper {
	List<Comment> findAll();
	
	void insert(Comment a);

	void delete(int index);

}
