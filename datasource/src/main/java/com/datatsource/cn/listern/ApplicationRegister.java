package com.datatsource.cn.listern;

import com.datatsource.cn.bo.TenantDatasource;
import com.datatsource.cn.service.TenantDatasourceService;
import com.datatsource.cn.utils.SpringUtils;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @date: 2021/8/5 15:55
 * @author: wzd
 */
@Component
public class ApplicationRegister implements ApplicationListener<ApplicationReadyEvent> {


    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        System.out.println("项目启动完成");
        //通过spring容器创建的对象直接获取
        //获取service 对象
//        TenantDatasourceService tenantDatasourceService = (TenantDatasourceService) SpringUtils.getClass(TenantDatasourceService.class);
//        // 查询所有的租户信息
//        List<TenantDatasource> list = new ArrayList<>();
//        TenantDatasource datasource = new TenantDatasource();
//        datasource.setDataKey("A");
//        datasource.setDatabaseName("CCC");
//        datasource.setDbUsername("root");
//        datasource.setJdbcUrl("jdbc:mysql://127.0.0.1:3307/crm_boss?useUnicode=true&characterEncoding=utf-8&useSSL=true&serverTimezone=UTC");
        TenantDatasourceService tenantDatasourceService = (TenantDatasourceService) SpringUtils.getClass(TenantDatasourceService.class);
        List<TenantDatasource> list1 = tenantDatasourceService.list();
        System.out.println(list1);
//        DynamicDataSourceContextHolder.initDataSourceContextHolder(list);


    }
}
