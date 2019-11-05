package com.softtek.academy.jstl.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

public abstract class AbstractDao {

    private final static BasicDataSource dataSource;

    static {
        // Data sources are provided and configured normally in Application servers
        dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dataSource.setUrl("jdbc:sqlserver://localhost\\SQLEXPRESS:1433;DatabaseName=ToDoList");
        dataSource.setUsername("sa");
        dataSource.setPassword("softtek.001");
    }


    final protected Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

}
