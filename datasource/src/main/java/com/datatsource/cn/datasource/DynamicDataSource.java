package com.datatsource.cn.datasource;

import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.Map;

/**
 *  切换数据源
 * @date: 2021/8/5 11:00
 * @author: wzd
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        System.out.println("=============" + DynamicDataSourceContextHolder.getDataSourceType());

        return DynamicDataSourceContextHolder.getDataSourceType();
    }

    public  DynamicDataSource(){

        DynamicDataSourceContextHolder.setDynamicDataSource(this);
        this.setTargetDataSources(DynamicDataSourceContextHolder.shopDataSource);
    }

}
