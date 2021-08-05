package com.datatsource.cn.datasource;

import com.sun.org.apache.xml.internal.security.Init;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotationMetadata;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @date: 2021/8/5 14:03
 * @author: wzd 启动注册类
 * Class: 说明 ImportBeanDefinitionRegistrar
 *  ImportBeanDefinitionRegistrar类只能通过其他类@Import的方式来加载，通常是启动类或配置类。
 *
 */
public class DynamicDataSourceRegister implements ImportBeanDefinitionRegistrar, EnvironmentAware {

    /**
     * 指定默认数据源(springboot2.0默认数据源是hikari如何想使用其他数据源可以自己配置)
     */
    private static final String DATASOURCE_TYPE_DEFAULT = "com.zaxxer.hikari.HikariDataSource";

    private DataSource defaultDataSource;

    @Override
    public void setEnvironment(Environment environment) {
        try {
            initDeaultDataSource(environment);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void initDeaultDataSource(Environment environment) throws ClassNotFoundException {
        Map<String,Object> map = new HashMap<>();
        map.put("driverName",environment.getProperty("spring.datasource.driver-class-name"));
        map.put("url",environment.getProperty("spring.datasource.url"));
        map.put("userName",environment.getProperty("spring.datasource.username"));
        map.put("password",environment.getProperty("spring.datasource.password"));
        defaultDataSource =  createDataSource(map);
        DynamicDataSourceContextHolder.setDatasourceKey(null);

    }

    /**HikariDataSource
     * 创建数据库连接
     * @param map
     * @return
     */
    private DataSource createDataSource(Map<String, Object> map) throws ClassNotFoundException {
        // 设置数据源类型
        Class<?extends DataSource> dataSourceType = (Class<? extends DataSource>) Class.forName(DATASOURCE_TYPE_DEFAULT);
        // 返回数据源对象
        return DataSourceBuilder.create().driverClassName(map.get("driverName").toString())
                .url(map.get("url").toString())
                .password(map.get("password").toString())
                .type(dataSourceType).build();
    }

    /**
     *  初始化默认数据源
     * @param importingClassMetadata
     * @param registry
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        genericBeanDefinition.setBeanClass(DynamicDataSource.class);
        genericBeanDefinition.setSynthetic(true);
        // 没看懂
//        MutablePropertyValues propertyValues = genericBeanDefinition.getPropertyValues();
//        propertyValues.add("deaultDataSource",defaultDataSource);
        registry.registerBeanDefinition("dataSource", genericBeanDefinition);

    }
}
