package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Set;

public abstract class ConnectionAbstract<T> {
	
	private String URL = "jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=ToDoList";
	private String USERNAME = "sa";
	private String PASSWORD = "softtek.001";
	protected Connection conn = null;
	
	protected void openConnection() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
	}
	protected void closeConnection() {
		try {
			if(this.conn != null) {
				
				this.conn.close();
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	protected abstract Set<T> findAll();
	
	protected abstract void insert(T record);
	
	protected abstract void update(T record);
	
	protected abstract void delete(T record);
	
	

	protected Connection getConn() {
		return conn;
	}

	
	
		
}