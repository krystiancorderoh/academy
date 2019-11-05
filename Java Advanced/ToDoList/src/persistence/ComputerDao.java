package persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;
import java.util.TreeSet;

import model.Computer;

public class ComputerDao extends ConnectionAbstractTest<Computer>{
	
	public ComputerDao() throws ClassNotFoundException, SQLException {
		this.openConnection();
	}
	
	@Override
	protected Set<Computer> getAll() {
		Set<Computer> computers = null;
		Statement st = null;

		try {
			st = this.getConnection().createStatement();
			String query = "SELECT * from [Computer_Assignement]";
			ResultSet rs = st.executeQuery(query);
			computers = new TreeSet<Computer>();
			while (rs.next()) {
				Computer computer = new Computer();
				computer.setUserId(Integer.parseInt(rs.getString("UserID")));
				computer.setComputerName(rs.getString("Computer_Name"));
				computer.setBrand(rs.getString("Brand"));
				computer.setId(Integer.parseInt(rs.getString("ID")));
				computer.setAssignedDate(Integer.parseInt(rs.getString("Assigned_Date")));
				
				computers.add(computer);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return computers;
	}

	@Override
	protected void insert(Computer record) {
		PreparedStatement preparedStm = null;
		try {
			preparedStm = this.getConnection().prepareStatement("INSERT INTO [Computer_Assignement] "
					+ "([UserID], Computer_Name, Brand, ID, Assigned_Date) VALUES (?,?,?,?,?)");
			preparedStm.setString(1, Integer.toString(record.getUserId()));
			preparedStm.setString(2, record.getComputerName());
			preparedStm.setString(3, record.getBrand());
			preparedStm.setString(4, Integer.toString(record.getId()));
			preparedStm.setString(5, Integer.toString(record.getAssignedDate()));
			int count = preparedStm.executeUpdate();
			System.out.println(String.format("Records modified %d", count));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	protected void update(Computer record) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void delete(Computer record) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void insertBach(Set<Computer> records) {
		// TODO Auto-generated method stub
		
	}

}
