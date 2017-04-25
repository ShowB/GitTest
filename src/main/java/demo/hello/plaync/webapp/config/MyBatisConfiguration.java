package demo.hello.plaync.webapp.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.TypeHandler;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.ncsoft.extension.mybatis.typehandler.joda.DateTimeTypeHandler;

@Configuration
public class MyBatisConfiguration {

	@Configuration
	@MapperScan(basePackages = { "demo.hello.plaync.webapp.repository.mssqlsample" }, sqlSessionFactoryRef = "mssqlSampleSqlSessionFactory", sqlSessionTemplateRef = "mssqlSampleSqlSessionTemplate")
	public static class MSSQLSampleMyBatisConfiguration {

		@Autowired
		@Qualifier("dataSourceMSSQL_SAMPLE")
		private DataSource dataSource;

		@Bean(name = "mssqlSampleSqlSessionFactory")
		public SqlSessionFactory sqlSessionFactory() throws Exception {
			SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
			sqlSessionFactoryBean.setDataSource(dataSource);
			
			org.apache.ibatis.session.Configuration conf = new org.apache.ibatis.session.Configuration();
			conf.setMapUnderscoreToCamelCase(true);
			sqlSessionFactoryBean.setConfiguration(conf);
			
			sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:repository/mssql-sample/*Mapper.xml"));
			sqlSessionFactoryBean.setTypeHandlers(new TypeHandler<?>[] { new DateTimeTypeHandler() });
			
			return sqlSessionFactoryBean.getObject();
		}

		@Bean(name = "mssqlSampleSqlSessionTemplate", destroyMethod = "clearCache")
		public SqlSessionTemplate sqlSessionTemplate() throws Exception {
			return new SqlSessionTemplate(sqlSessionFactory());
		}

	}

}