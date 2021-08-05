package com.datatsource.cn.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @date: 2021/8/5 16:04
 * @author: wzd
 *
 * 从容器中获取bean对象
 */
@Component
public class SpringUtils implements ApplicationContextAware {

    public  static  ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context=applicationContext;
    }

    /**
     *  根据bean 的名称获取bean 对象
     * @param beanName
     * @return
     */
    public  static Object getBeanName(String beanName){

        return context.getBean(beanName);
    }
    public static  <T>Object getClass(Class<T> t){
        return context.getBean(t);
    }
    public static <T>T getBeanAndClass(String beanName, Class<T> t){
        return context.getBean(beanName,t);
    }

}
