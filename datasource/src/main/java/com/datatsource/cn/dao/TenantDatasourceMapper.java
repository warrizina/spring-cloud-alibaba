package com.datatsource.cn.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.datatsource.cn.bo.TenantDatasource;
import org.apache.ibatis.annotations.Mapper;

/**
 * @date: 2021/8/5 15:50
 * @author: wzd
 *
 * 注意： mybatis -plus  如果要 需要重写方法则 继承 Mapper 否则 继承baseMapper
 */
@Mapper
public interface TenantDatasourceMapper extends BaseMapper<TenantDatasource> {
}
