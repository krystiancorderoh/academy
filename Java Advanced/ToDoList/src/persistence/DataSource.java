package persistence;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import model.User;

public class DataSource {

	public static void main(String[] args) throws ClassNotFoundException {
		
		try {
			ConnectionAbstract<User> userDao = new UserDao();
			System.out.println(userDao.getAll());
			userDao.insert(new User("Sarahi", "sarahi@gmail.com"));
			System.out.println(userDao.getAll());
			
			userDao.update(new User("Sarahiii", "sarahi@gmail.com"));
			System.out.println(userDao.getAll());
			
			Set<User> usuarios = new HashSet<User>();
			usuarios.add(new User("Usuario", "Correo@dfs.com"));
			usuarios.add(new User("Hamona", "hamona@correo.com"));
			
			userDao.insertBach(usuarios);
			System.out.println(userDao.getAll());
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	

}
