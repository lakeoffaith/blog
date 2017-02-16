package com.service;

import java.util.List;

import com.modal.Comment;

public interface CommentService {
	public List<Comment> findAll();

	public void add(Comment comment);

	public void delete(int index);
}
