package com.datatsource.cn;

import com.datatsource.cn.datasource.DynamicDataSource;
import com.datatsource.cn.datasource.DynamicDataSourceRegister;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
//@MapperScan("com.datasource.cn.dao")
@Import({DynamicDataSourceRegister.class})
public class DatasourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatasourceApplication.class, args);
    }

}
