package com.tcw.core.dataSource;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.github.pagehelper.PageHelper;

@Configuration
@MapperScan(basePackages = DataSourceSMSDB.PACKAGE, sqlSessionTemplateRef  = DataSourceSMSDB.DB_NAME + "SqlSessionTemplate")
public class DataSourceSMSDB {
	
	static final String DB_NAME = "smsdb";
	static final String PACKAGE = "com.tcw.mapper." + DB_NAME;
    static final String MAPPER_LOCATION = "classpath:mybatis/mapper/" + DB_NAME + "/**/*.xml";
    static final String MYBATIS_CONFIG = "classpath:mybatis/mybatis-config.xml";
    
    @Bean(name = DB_NAME + "DataSource")
    @ConfigurationProperties(prefix = "spring.datasource." + DB_NAME)
    @Primary
    public DataSource build() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = DB_NAME + "TransactionManager")
    @Primary
    public DataSourceTransactionManager buildDatasourceTransactionManager(@Qualifier(DB_NAME + "DataSource") DataSource dataSource) {
    	return new DataSourceTransactionManager(dataSource);
    }
    
    @Bean(name = DB_NAME + "SqlSessionFactory")
    @Primary
    public SqlSessionFactory buildSqlSessionFactory(@Qualifier(DB_NAME + "DataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_LOCATION));
        bean.setConfigLocation(new DefaultResourceLoader().getResource(MYBATIS_CONFIG));
        
        // 分页插件
        PageHelper pageHelper = new PageHelper();  
        Properties props = new Properties();  
        props.setProperty("reasonable", "true");  
        props.setProperty("supportMethodsArguments", "true");  
        props.setProperty("returnPageInfo", "check");  
        props.setProperty("params", "count=countSql");  
        pageHelper.setProperties(props);  
        //添加插件 
        bean.setPlugins(new Interceptor[]{pageHelper});
        
        return bean.getObject();
    }

    @Bean(name = DB_NAME + "SqlSessionTemplate")
    @Primary
    public SqlSessionTemplate buildSqlSessionTemplate(@Qualifier(DB_NAME + "SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
