package com.kuang.diy;

// 方式三，使用注解的方式实现AOP，自定义一个切片类

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect  // 标注这是一个切片类
public class AnnotationPointCut {

    @Before("execution(* com.kuang.service.UserServiceImpl.*(..))")
    public void before(){
        System.out.println("======方法执行前======");
    }

    @After("execution(* com.kuang.service.UserServiceImpl.*(..))")
    public void after(){
        System.out.println("======方法执行后======");
    }

    //在环绕增强中，我们可以给定一个参数，代表我们要获取处理切入的点JoinPoint
    @Around("execution(* com.kuang.service.UserServiceImpl.*(..))")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕前");
        Object proceed = joinPoint.proceed();  //执行方法
//        System.out.println(proceed);
        System.out.println("环绕后");
    }
}
