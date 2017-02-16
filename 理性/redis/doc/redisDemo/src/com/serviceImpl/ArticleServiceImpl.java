package com.serviceImpl;

import org.springframework.stereotype.Component;

import com.service.ArticleService;

@Component("helloWorld")
public class ArticleServiceImpl implements ArticleService{

	@Override
	public String get() {
		// TODO Auto-generated method stub
		return "nihao";
	}

}
