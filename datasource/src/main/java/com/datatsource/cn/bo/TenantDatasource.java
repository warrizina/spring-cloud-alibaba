package com.datatsource.cn.bo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 租户资源存储表
 * </p>
 *
 * @author 恒利
 * @since 2021-01-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tenant_datasource")
@ApiModel(value="TenantDatasource对象", description="租户资源存储表")
public class TenantDatasource  {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "租户id")
    @TableField("shopTenantId")
    private Integer shopTenantId;

    @ApiModelProperty(value = "资源标识")
    @TableField("sourceName")
    private String sourceName;

    @ApiModelProperty(value = "dataKey")
    @TableField("dataKey")
    private String dataKey;

    @ApiModelProperty(value = "资源地址")
    @TableField("jdbcUrl")
    private String jdbcUrl;

    @ApiModelProperty(value = "账号")
    @TableField("dbUsername")
    private String dbUsername;

    @ApiModelProperty(value = "密码")
    @TableField("dbPassword")
    private String dbPassword;

    @ApiModelProperty(value = "数据库")
    @TableField("databaseName")
    private String databaseName;

    @ApiModelProperty(value = "创建者")
    @TableField("createBy")
    private String createBy;

    @ApiModelProperty(value = "更新者")
    @TableField("updateBy")
    private String updateBy;

    @ApiModelProperty(value = "备注")
    @TableField("remark")
    private String remark;

}
