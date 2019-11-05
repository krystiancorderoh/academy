package persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;
import java.util.TreeSet;

import model.User;

public class UserDao extends ConnectionAbstract<User> {

	public UserDao() throws ClassNotFoundException, SQLException {
		this.openConnection();
	}

	@Override
	protected Set<User> getAll() {
		Set<User> usuarios = null;
		Statement st = null;

		try {
			st = this.getConnection().createStatement();
			String query = "SELECT * from [User]";
			ResultSet rs = st.executeQuery(query);
			usuarios = new TreeSet<User>();
			while (rs.next()) {
				User user = new User();
				user.setName(rs.getString("Name"));
				user.setEmail(rs.getString("Email"));
				user.setIdUser(rs.getInt("idUser"));
				usuarios.add(user);
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
		return usuarios;
	}

	@Override
	protected void insert(User record) {
		PreparedStatement preparedStm = null;
		try {
			preparedStm = this.getConnection().prepareStatement("INSERT INTO [User] ([Name], Email) VALUES (?, ?)");
			preparedStm.setString(1, record.getName());
			preparedStm.setString(2, record.getEmail());
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
	protected void update(User record) {
		PreparedStatement preparedStm = null;
		try {
			preparedStm = this.getConnection().prepareStatement("SELECT * FROM [USER] WHERE email = ?",
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			preparedStm.setString(1, record.getEmail());
			ResultSet rs = preparedStm.executeQuery();
			while (rs.next()) {
				rs.updateString("name", record.getName());
				rs.updateString("email", record.getEmail());
				rs.updateRow();
			}
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
	protected void delete(User record) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void insertBach(Set<User> records) {
		PreparedStatement preparedStm = null;
		try {
			this.getConnection().setAutoCommit(false);
			preparedStm = this.getConnection().prepareStatement("INSERT INTO [User] ([name], email) VALUES (?, ?)");
			for (User record : records) {
				preparedStm.setString(1, record.getName());
				preparedStm.setString(2, record.getEmail());
				preparedStm.addBatch();
			}
			int[] updates = preparedStm.executeBatch();
			System.out.println(String.format("Records modified %d", updates.length));
			getConnection().commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				this.getConnection().rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				preparedStm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				this.getConnection().setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
