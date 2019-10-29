package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Set;

import model.User;

public class UserDao extends ConnectionAbstract<User> {

	@Override
	protected Set<User> findAll() {
		Set<User> usuarios = null;
		Statement st = null;
		try {
			super.openConnection();
			st = conn.createStatement();
			
			String query = "Select * from [User]";
			ResultSet rs = st.executeQuery(query);
			usuarios = new TreeSet<User>();
			while(rs.next()) {
				
				User user = new User();
				user.setIdUser(rs.getInt("idUser"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				usuarios.add(user);
				
			}
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				st.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
			super.closeConnection();
		}
		return usuarios;
	}

	@Override
	protected void insert(User record) {
		PreparedStatement reparedStm =null;
		try {
			super.openconnection();
			preparedStm = 
		}
		
	}

	@Override
	protected void update(User record) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void delete(User record) {
		// TODO Auto-generated method stub
		
	}
	
}
