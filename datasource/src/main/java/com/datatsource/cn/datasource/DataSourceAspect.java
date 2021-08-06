package com.datatsource.cn.datasource;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @date: 2021/8/6 10:35
 * @author: wzd
 * 定义一个切面类
 *
 */
@Aspect
@Component
public class DataSourceAspect {


    //定义一个切点
    @Pointcut("execution(* com.datatsource.cn.controller.*.*(..))")
    public void pointcut(){
        System.out.println("切点");
    }

    @After("pointcut()")
    public void before(){
        System.out.println("进入切面要执行的方法");
    }

    // 定义一个切点
    @Pointcut("@annotation(org.springframework.transaction.annotation.Transactional)")
    public void transaction(){
    }

    @Before("transaction()")
    public void transactionMethod(){
        DynamicDataSourceContextHolder.setDataSourceType("PoolName[z5wh033c7i8]");
    }



}
