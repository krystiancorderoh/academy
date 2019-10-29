package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class DataSource {

	public static void main(String[] args) throws ClassNotFoundException {
		
		String url = "jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=ToDoList";
		String username = "sa";
		String password = "softtek.001";
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		DataSource ds = new DataSource();
		List<User> usuarios = ds.openConnection(url, username, password);
		for(User u: usuarios) {
			System.out.println(u.getIdUser() +"|"+u.getName()+"|"+u.getEmail());
		}
		//System.out.println(usuarios);
		
	}
	
	public List<User> openConnection(String url,String username,String pwd){
		
		List<User> usuarios = null;
		Connection conn = null;
		Statement st = null;
		
		
		}finally {
			
			try {
				st.close();
				conn.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return usuarios;
		
	}

}
