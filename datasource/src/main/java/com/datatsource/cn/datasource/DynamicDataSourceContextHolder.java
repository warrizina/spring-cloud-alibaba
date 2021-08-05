package com.datatsource.cn.datasource;

import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.datatsource.cn.bo.TenantDatasource;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @date: 2021/8/5 13:45
 * @author: wzd
 * 自定义数据源切换
 */
public class DynamicDataSourceContextHolder {

    //  将数据存储到内存中
    public static Map<Object, Object> shopDataSource = new ConcurrentHashMap<>();

    static DynamicDataSource dynamicDataSource;

    /**
     * 存放当前线程使用的数据源类型信息
     */
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

    /**
     * 当前系统标示 base，course，exam
     */
    private static String datasourceKey;

    /**
     * 设置动态数据源对象*
     */
    public static void setDynamicDataSource(DynamicDataSource dataSource) {
        dynamicDataSource = dataSource;
    }

    /**
     * 初始化所有的数据源
     *
     * @param list
     */
    public static void initDataSourceContextHolder(List<TenantDatasource> list) {
        if (ObjectUtils.isNotEmpty(list)) {
            list.forEach(e -> {
                shopDataSource.put("PoolName[A]", createDataSource(e));
            });
            // 方法说明在 方法初始化之前执行 afterPropertiesSet
            dynamicDataSource.afterPropertiesSet();
        }

    }

    /**
     * 设置数据源
     *
     * @param dataSourceType
     */
    public static void setDataSourceType(String dataSourceType) {
        System.out.println("数据源标识:" + dataSourceType);
        // 去掉datakey长度校验，有的租户字符串长度已经到了12位
        if (dataSourceType == null || dataSourceType.equals("")) {
            System.out.println("---数据源 " + dataSourceType + " 不存在，不符合租户标识规范");
        } else if (isContainsDataSource(dataSourceType)) {
            System.out.println("设置=========");
            contextHolder.set(dataSourceType);
        } else {
//            CommonCacheChannel commonCacheChannel = SpringUtil.getBean(CommonCacheChannel.class);
//            //获取所有数据源
//            Map<String, List<TenantDatasource>> dataSourceMap = (Map<String, List<TenantDatasource>>) commonCacheChannel.get("thirty_day_region", "DATA_SOURCE_MAP").getValue();
//            //获取当前系统的 数据源
//            List<TenantDatasource> shopDataSourceList = dataSourceMap.get(datasourceKey);
//            //获取默认系统的 数据源
//            shopDataSourceList.addAll(dataSourceMap.get(defaultDatasourceKey));
//            //初始化当前租户 当前系统 数据源
//            shopDataSourceList.forEach(e -> {
//                if (e.getDataKey().equals(dataSourceType)) {
//                    DynamicDataSourceContextHolder.initShopDataSource(e);
//                }
//            });
//            if (isContainsDataSource(dataSourceType)) {
//                DynamicDataSourceContextHolder.setDataSourceType(dataSourceType);
//            } else {
//                log.info("数据源 " + dataSourceType + " 不存在，此处预留处理操作");
//            }
        }
    }

    /**
     * 判断当前数据源是否存在
     *
     * @param dataSourceId
     * @return
     */
    public static boolean isContainsDataSource(String dataSourceId) {
        return ObjectUtils.isNotEmpty(shopDataSource.get(dataSourceId));
    }

    /**
     * 创建连接对象
     *
     * @param tenantDatasource
     * @return
     */
    public static DataSource createDataSource(TenantDatasource tenantDatasource) {
//        HikariDataSource
        HikariConfig hikariConfig = new HikariConfig();

        hikariConfig.setJdbcUrl(tenantDatasource.getJdbcUrl());
        hikariConfig.setDriverClassName("com.mysql.cj.jdbc.Driver");              //shopDataSource.getDriver()
        hikariConfig.setUsername(tenantDatasource.getDbUsername());
        hikariConfig.setPassword(tenantDatasource.getDbPassword());
        hikariConfig.setPoolName("PoolName[" + tenantDatasource.getDataKey() + "]");
        hikariConfig.setConnectionTimeout(5000l);   //shopDataSource.getConnectionTimeout()
        hikariConfig.setMinimumIdle(5);             //shopDataSource.getMinImum()
        hikariConfig.setMaximumPoolSize(200);        //shopDataSource.getMaxImum()
        hikariConfig.setMaxLifetime(300000);
        hikariConfig.setIdleTimeout(5000l);              //shopDataSource.getTimeout()
        return new HikariDataSource(hikariConfig);
    }


    public static void setDatasourceKey(String systemType) {
        datasourceKey = systemType;
    }

    /**
     * 获取数据源
     *
     * @return
     */
    public static String getDataSourceType() {
        return contextHolder.get();
    }
}
