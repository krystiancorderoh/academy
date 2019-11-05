package persistence;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;


import model.Computer;
import model.User;

public class ServMostrarComputadoras {
	public static void main(String[] args) throws ClassNotFoundException{
		try {
			ConnectionAbstractTest<Computer> computerDao = new ComputerDao();
			System.out.println(computerDao.getAll());
			//Set<Computers> usuarios = new TreeSet<User>();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
