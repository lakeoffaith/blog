package com.springmvc;


import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dao.ArticleDao;
import com.dao.CommentMapper;
import com.modal.Article;
import com.modal.Comment;
import com.service.ArticleService;
import com.service.CommentService;

@Controller
public class demo {

	@Autowired
	public ArticleService helloWorld;
	@Autowired
	public ArticleDao articleDao;
	@Autowired
	public CommentMapper commentDao;
	@Autowired   
	public CommentService commentService;
	@RequestMapping("/hello")
	public String hello(String name){
		
		
		/*System.out.println("-------根据文章的id来查询评论--------");
		Random r=new  Random();
		int index=r.nextInt(1000);
		int articleId=articleDao.findAll().get(index).getId();
		Article a=articleDao.findArticleCommentsDetailsId(articleId);
		System.out.println("----------------");
		System.out.println(a);*/
		
		System.out.println(name);
		List<Comment> r=commentService.findAll();
		
		return "success";
	}
	@RequestMapping("/add")
	@ResponseBody
	public String add(String name){
		System.out.println("add"+name);
		Random r=new  Random();
		int index=r.nextInt(1000);
		Article article=articleDao.findAll().get(index);
		Comment comment=new Comment();
		comment.article=article;
		comment.content="新加评论 "+System.currentTimeMillis();
		commentService.add(comment);
		return "nihao";
	}
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(){
		Random r=new  Random();
		int index=5000+r.nextInt(5000);
		commentService.delete(index);
		return "删除";
	}
}
