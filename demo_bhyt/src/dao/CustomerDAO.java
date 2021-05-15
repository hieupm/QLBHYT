package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Customer;



/**
 * AbstractDAO.java This DAO class provides CRUD database operations for the
 * table users in the database.
 * 
 * 
 *
 */
public class CustomerDAO {
	protected String jdbcURL = "jdbc:mysql://localhost:3306/demo_bhyt?serverTimezone=Asia/Bangkok";
	protected String jdbcUsername = "root";
	protected String jdbcPassword = "1234";

	private static final String INSERT_CUSTOMER_SQL = "INSERT INTO tblCustomer" + "  (name, idCardNum, dob, address, telephone) VALUES "
			+ " (?, ?, ?, ?, ?);";

	private static final String SELECT_CUSTOMER_BY_ID = "select id,name,idCardNum,dob,address,telephone from tblCustomer where id =?";
	private static final String SELECT_ALL_CUSTOMER = "select * from tblCustomer";
	private static final String DELETE_CUSTOMER_SQL = "delete from tblCustomer where id = ?;";
	private static final String UPDATE_CUSTOMER_SQL = "update tblCustomer set name = ?, idCardNum = ?, dob = ?, address = ?, telephone = ? where id = ?;";
	private static final String SELECT_CUSTOMER_BY_IDCARD = "select id,name,idCardNum,dob,address,telephone from tblCustomer where idCardNum =?";
	public CustomerDAO() {
	}

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public void insertCustomer (Customer customer) throws SQLException {
		System.out.println(INSERT_CUSTOMER_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER_SQL)) {
			preparedStatement.setString(1, customer.getName());
			preparedStatement.setString(2, customer.getIdCardNum());
			preparedStatement.setDate(3, customer.getDob());
			preparedStatement.setString(4, customer.getAddress());
			preparedStatement.setString(5, customer.getTelephone());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public Customer selectCustomer(int id) {
		Customer customer = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String name = rs.getString("name");
				String idCardNum = rs.getString("idCardNum");
				Date dob = rs.getDate("dob");
				String address = rs.getString("address");
				String telephone = rs.getString("telephone");
				customer = new Customer(id, name, idCardNum, dob, address, telephone);
				System.out.println(customer.toString());
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return customer;
	}
	
	public Customer selectCustomerbyidcard(String idCardNum) {
		Customer customer = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_BY_IDCARD);) {
			preparedStatement.setString(1, idCardNum);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				Date dob = rs.getDate("dob");
				String address = rs.getString("address");
				String telephone = rs.getString("telephone");
				customer = new Customer(id, name, idCardNum, dob, address, telephone);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return customer;
	}
	
	public List<Customer> selectAllCustomer() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Customer> customers = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String idCardNum = rs.getString("idCardNum");
				Date dob = rs.getDate("dob");
				String address = rs.getString("address");
				String telephone = rs.getString("telephone");
				customers.add(new Customer(id, name, idCardNum, dob, address, telephone));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return customers;
	}

	public boolean deleteCustomer(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_CUSTOMER_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateCustomer(Customer customer) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_CUSTOMER_SQL);) {
			statement.setString(1, customer.getName());
			statement.setString(2, customer.getIdCardNum());
			statement.setDate(3, customer.getDob());
			statement.setString(4, customer.getAddress());
			statement.setString(5, customer.getTelephone());
			statement.setInt(6, customer.getId());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	protected void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

}

