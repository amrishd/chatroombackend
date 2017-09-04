package com.chatroom.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.chatroom.model.*;


@Configuration
@EnableTransactionManagement
public class DBConfig {

		@Bean
	   public SessionFactory sessionFactory()
	   {
			LocalSessionFactoryBuilder lsfb=new LocalSessionFactoryBuilder(getDataSource());
			Properties hibernateProperties=new Properties();
			hibernateProperties.setProperty("hibernate.dialect","org.hibernate.dialect.Oracle10gDialect");
	        hibernateProperties.setProperty("hibernate.hbm2ddl.auto","update");
	        hibernateProperties.setProperty("hibernate.show_sql","true");
	         lsfb.addProperties(hibernateProperties);
	         Class classess[]=new Class[]{User.class,Job.class,Friend.class,Blog.class,Comment.class};
	         return lsfb.addAnnotatedClasses(classess).buildSessionFactory();
	   }
		
		@Bean
		public DataSource getDataSource() {
			BasicDataSource datasource=new BasicDataSource();
			datasource.setDriverClassName("oracle.jdbc.OracleDriver");
			datasource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
			datasource.setUsername("TEST");
			datasource.setPassword("admin123");
			return datasource;
		}
	@Bean
	public HibernateTransactionManager hibTransManagement()
	{
		return new HibernateTransactionManager(sessionFactory());
	}


	
}
