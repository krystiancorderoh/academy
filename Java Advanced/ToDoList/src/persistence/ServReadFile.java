package persistence;

import java.sql.SQLException;

import model.Computer;

public class ServReadFile {
	public static void main(String[] args) throws ClassNotFoundException{
		int[] userID = {1,2,3,4};
		String[] computerName = {"Pc1","Pc2","Pc3","Pc4"};
		String[] brand = {"HP","Dell","HP","Dell"};
		int[] id = {10,20,30,40};
		int[] assignedDate = {20101007,20101007,20101007,20101007};
		
		try {
			ConnectionAbstractTest<Computer> computerDao = new ComputerDao();
			for (int i=0;i<4;i++) {
				computerDao.insert(new Computer(userID[i], computerName[i], brand[i], id[i], assignedDate[i] ));
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		
	}
}
