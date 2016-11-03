package com.demo.config.druid;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.bind.PropertySourceUtils;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;

import java.util.Map;

import javax.sql.DataSource;

/**
 * Created by dxk on 2016/10/26.
 */
@Configuration
@ConditionalOnMissingBean({DataSource.class})
@ConditionalOnClass({DruidDataSource.class})
public class DruidAutoConfiguration implements EnvironmentAware {
    private static Logger log = LoggerFactory.getLogger(DruidAutoConfiguration.class);
    private ConfigurableEnvironment env;

    public DruidAutoConfiguration() {
    }

    @Bean
    @ConditionalOnMissingBean
    public DataSource dataSource() {
        Map druidProperties = PropertySourceUtils.getSubProperties(this.env.getPropertySources(), "druid.");
        DruidDataSource dataSource = null;

        try {
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(druidProperties);
            return dataSource;
        } catch (Exception var4) {
            throw new RuntimeException("load datasource error, dbProperties is :" + druidProperties, var4);
        }
    }

    public void setEnvironment(Environment environment) {
        this.env = (ConfigurableEnvironment)environment;
    }
}
