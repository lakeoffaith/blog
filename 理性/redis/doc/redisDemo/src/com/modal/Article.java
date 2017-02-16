package com.modal;

import java.io.Serializable;
import java.util.List;

public class Article  implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String content;
	private List<Comment> comments;
	public Article(){
		super();
	}
	public Article(String name,String content){
		this.name=name;
		this.content=content;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	@Override
	public String toString() {
		return "Article [id=" + id + ", name=" + name + ", content=" + content + "]";
	}
	
	
}
