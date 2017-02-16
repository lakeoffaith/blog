package com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.service.CommentService;

public class Hello {
	public static void main(String[] args){
		 ApplicationContext ac =  new ClassPathXmlApplicationContext("classpath:spring-common.xml");
		 /* System.out.println(ac.getBean("redisTemplate"));
	       System.out.println(ac.getBean("userDao"));
	      UserDao userDao=(UserDao) ac.getBean("userDao");
	       userDao.add(new User(1,"nihao"));
	       
	       System.out.println(userDao.get(1));*/
		  CommentService service=(CommentService)ac.getBean("commentService");
		  service.findAll();
		   //System.out.println(service.findAll());
	}
}
