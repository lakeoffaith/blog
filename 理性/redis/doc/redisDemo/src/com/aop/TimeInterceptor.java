package com.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component("timeInterceptor")
@Aspect
public class TimeInterceptor {
	@Pointcut("execution (* com.serviceImpl.CommentServiceImpl.*(..))")
	private void anyMethod(){
		
	}
	
	private long time;
	
	@Before("anyMethod()")
	public void doAccessCheck(){
		
	}
	
	@After("anyMethod()")
	public void doAfter(){
		
	}
	
	@Around("anyMethod()")  
    public Object doAround(ProceedingJoinPoint pJoinPoint) throws Throwable {  
        // 这里如果pJoinPoint.proceed()不执行，后面拦截到的方法都不会执行，非常适用于权限管理  
        Long oldTimeMillis=System.currentTimeMillis();
        Object result = pJoinPoint.proceed();  
        System.out.println("*****执行花费时间= "+(System.currentTimeMillis()-oldTimeMillis));  
        return result;  
    }
}
