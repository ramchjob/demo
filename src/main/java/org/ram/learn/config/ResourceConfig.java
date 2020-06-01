package org.ram.learn.config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;

public class ResourceConfig {
    
    public DataSource getDataSource() {
        DataSourceBuilder<?> builder = DataSourceBuilder.create();
        return builder.password("password").build();
    }

}
