package com.dao;

import java.util.List;

import com.modal.Article;
import com.modal.Comment;

public interface ArticleDao {
	void insert(Article a);
	void delete(int id);
	void update(Article a);
	List<Article> findAll();
	Article findArticleCommentsDetailsId(int articleId);
}
