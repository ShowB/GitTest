package demo.hello.plaync.webapp.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.ncsoft.aframework.jdbc.DataSourceBuilder;

import demo.hello.plaync.webapp.config.DatabaseConnectionProperties.DataSourceProperties;

@Configuration
@EnableTransactionManagement
@EnableConfigurationProperties(DatabaseConnectionProperties.class)
public class DatabaseConfiguration {

	@Autowired
	private DatabaseConnectionProperties properties;

	@Bean(name="dataSourceMSSQL_SAMPLE", destroyMethod="close")
	public DataSource dataSourceMSSQLSample () {
	    DataSourceProperties dataSourceProperties = properties.getConnections().get("MSSQL_SAMPLE");
	    return DataSourceBuilder.hikari()
	            .setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver")
	            .setJdbcUrl(dataSourceProperties.getUrl())
	            .setMaximumPoolSize(dataSourceProperties.getMaxPoolSize())
	            .setUserName(dataSourceProperties.getUsername())
	            .setPassword(dataSourceProperties.getPassword())
	            .build();
	}
	
	@Bean
	public PlatformTransactionManager txManager() {
		return new DataSourceTransactionManager(dataSourceMSSQLSample());
	}
} 