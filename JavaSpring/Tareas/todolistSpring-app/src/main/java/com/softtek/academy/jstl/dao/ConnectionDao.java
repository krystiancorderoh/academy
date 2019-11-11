package com.softtek.academy.jstl.dao;

import java.sql.Connection;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.sql.SQLException;

import javax.annotation.PostConstruct;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.softtek.academy.jstl.service.TaskService;

@Component
public class ConnectionDao {
	
	private BasicDataSource dataSource = new BasicDataSource();
	
//	BasicDataSource dataSource=context.getBean(dataSource);
    
	@Value("#{settings['db.DriverClassName']}")
	private String driverClassName;

	@Value("#{settings['db.url']}")
	private String url;

	@Value("#{settings['db.user']}")
	private String user;

	@Value("#{settings['db.pass']}")
	private String pass;

	@PostConstruct
	private void postConstruct() {
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(user);
		dataSource.setPassword(pass);
	}

	final protected Connection getConnection() throws SQLException {

		return dataSource.getConnection();
	}

}
