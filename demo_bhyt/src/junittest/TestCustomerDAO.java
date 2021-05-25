package junittest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import org.junit.jupiter.api.*;
import com.mysql.jdbc.PreparedStatement;
import model.Customer;
import dao.CustomerDAO;


public class TestCustomerDAO {
	protected CustomerDAO customerDAO;
	protected String jdbcURL = "jdbc:mysql://localhost:3306/demo_bhyt?serverTimezone=Asia/Bangkok";
	protected String jdbcUsername = "root";
	protected String jdbcPassword = "1234";

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

	@Test
	public void testValidCreateCustomer() {
		try {
			System.out.println("Running testCreateCustomer...");
			customerDAO = new CustomerDAO();
			java.sql.Date dob = java.sql.Date.valueOf("1999-12-31");
			Customer customer = new Customer("Pham Minh Hieu", "01219451", dob, "Ha Noi", "0904579384");
			customerDAO.insertCustomer(customer);
			Customer existedCustomer = customerDAO.selectCustomerbyidcard("01219451");
			assertEquals("Pham Minh Hieu", existedCustomer.getName());

			// rollback
//			Connection connection = getConnection();
//			String sql = "delete from tblCustomer where id = ?";
//			PreparedStatement p = (PreparedStatement) connection.prepareStatement(sql);
//			p.setInt(1, existedCustomer.getId());
//			p.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testInvalidCreateCustomer1() {
		try {
			System.out.println("Running testCreateCustomer...");
			customerDAO = new CustomerDAO();
			java.sql.Date dob = java.sql.Date.valueOf("1999-12-31");
			Customer customer = new Customer("Pham Minh Hieu", "01219451", dob, "Ha Noi", "0904579384");
			customerDAO.insertCustomer(customer);
			Customer existedCustomer = customerDAO.selectCustomerbyidcard("01219451");
			//assertEquals("Pham Minh Hieu", existedCustomer.getName());
			Assertions.assertNull(existedCustomer);

			// rollback
//			Connection connection = getConnection();
//			String sql = "delete from tblCustomer where id = ?";
//			PreparedStatement p = (PreparedStatement) connection.prepareStatement(sql);
//			p.setInt(1, existedCustomer.getId());
//			p.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testInvalidCreateCustomer2() {
		try {
			System.out.println("Running testCreateCustomer...");
			customerDAO = new CustomerDAO();
			java.sql.Date dob = java.sql.Date.valueOf("1999-12-31");
			Customer customer = new Customer("Pham Minh Hieu", null, dob, "Ha Noi", "0904579384");
			customerDAO.insertCustomer(customer);
			Customer existedCustomer = customerDAO.selectCustomerbyidcard("01219451");
			//assertEquals("Pham Minh Hieu", existedCustomer.getName());
			Assertions.assertNull(existedCustomer);

			// rollback
//			Connection connection = getConnection();
//			String sql = "delete from tblCustomer where id = ?";
//			PreparedStatement p = (PreparedStatement) connection.prepareStatement(sql);
//			p.setInt(1, existedCustomer.getId());
//			p.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testInvalidCreateCustomer3() {
		try {
			System.out.println("Running testCreateCustomer...");
			customerDAO = new CustomerDAO();
			java.sql.Date dob = java.sql.Date.valueOf("1999-12-31");
			Customer customer = new Customer("Pham Minh Hieu", "01219451", null, "Ha Noi", "0904579384");
			customerDAO.insertCustomer(customer);
			Customer existedCustomer = customerDAO.selectCustomerbyidcard("01219451");
			//assertEquals("Pham Minh Hieu", existedCustomer.getName());
			Assertions.assertNull(existedCustomer);

			// rollback
//			Connection connection = getConnection();
//			String sql = "delete from tblCustomer where id = ?";
//			PreparedStatement p = (PreparedStatement) connection.prepareStatement(sql);
//			p.setInt(1, existedCustomer.getId());
//			p.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testInvalidCreateCustomer4() {
		try {
			System.out.println("Running testCreateCustomer...");
			customerDAO = new CustomerDAO();
			java.sql.Date dob = java.sql.Date.valueOf("1999-12-31");
			Customer customer = new Customer("Pham Minh Hieu", "01219451", dob, null, "0904579384");
			customerDAO.insertCustomer(customer);
			Customer existedCustomer = customerDAO.selectCustomerbyidcard("01219451");
			//assertEquals("Pham Minh Hieu", existedCustomer.getName());
			Assertions.assertNull(existedCustomer);

			// rollback
//			Connection connection = getConnection();
//			String sql = "delete from tblCustomer where id = ?";
//			PreparedStatement p = (PreparedStatement) connection.prepareStatement(sql);
//			p.setInt(1, existedCustomer.getId());
//			p.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testInvalidCreateCustomer5() {
		try {
			System.out.println("Running testCreateCustomer...");
			customerDAO = new CustomerDAO();
			java.sql.Date dob = java.sql.Date.valueOf("1999-12-31");
			Customer customer = new Customer("Pham Minh Hieu", "012194511", dob, "Ha Noi", null);
			customerDAO.insertCustomer(customer);
			Customer existedCustomer = customerDAO.selectCustomerbyidcard("012194511");
			assertEquals("Pham Minh Hieu", existedCustomer.getName());
			//Assertions.assertNull(existedCustomer);

			// rollback
			Connection connection = getConnection();
			String sql = "delete from tblCustomer where id = ?";
			PreparedStatement p = (PreparedStatement) connection.prepareStatement(sql);
			p.setInt(1, existedCustomer.getId());
			p.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testInvalidCreateCustomer6() {
		try {
			System.out.println("Running testCreateCustomer...");
			customerDAO = new CustomerDAO();
			java.sql.Date dob = java.sql.Date.valueOf("1999-12-31");
			Customer customer = new Customer("Pham Minh Hieu@#%", "01219451", dob, "Ha Noi", "0904579384");
			customerDAO.insertCustomer(customer);
			Customer existedCustomer = customerDAO.selectCustomerbyidcard("01219451");
			//assertEquals("Pham Minh Hieu", existedCustomer.getName());
			Assertions.assertNull(existedCustomer);

			// rollback
			Connection connection = getConnection();
			String sql = "delete from tblCustomer where id = ?";
			PreparedStatement p = (PreparedStatement) connection.prepareStatement(sql);
			p.setInt(1, existedCustomer.getId());
			p.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testInvalidCreateCustomer7() {
		try {
			System.out.println("Running testCreateCustomer...");
			customerDAO = new CustomerDAO();
			java.sql.Date dob = java.sql.Date.valueOf("1999-12-31");
			Customer customer = new Customer("Pham Minh Hieu", "01219451@^&", dob, "Ha Noi", "0904579384");
			customerDAO.insertCustomer(customer);
			Customer existedCustomer = customerDAO.selectCustomerbyidcard("01219451@^&");
			//assertEquals("Pham Minh Hieu", existedCustomer.getName());
			Assertions.assertNull(existedCustomer);

			// rollback
			Connection connection = getConnection();
			String sql = "delete from tblCustomer where id = ?";
			PreparedStatement p = (PreparedStatement) connection.prepareStatement(sql);
			p.setInt(1, existedCustomer.getId());
			p.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testInvalidCreateCustomer8() {
		try {
			System.out.println("Running testCreateCustomer...");
			customerDAO = new CustomerDAO();
			java.sql.Date dob = java.sql.Date.valueOf("1999-12-31$%");
			Customer customer = new Customer("Pham Minh Hieu", "01219451", dob, "Ha Noi", "0904579384");
			customerDAO.insertCustomer(customer);
			Customer existedCustomer = customerDAO.selectCustomerbyidcard("01219451");
			//assertEquals("Pham Minh Hieu", existedCustomer.getName());
			Assertions.assertNull(existedCustomer);

			// rollback
//			Connection connection = getConnection();
//			String sql = "delete from tblCustomer where id = ?";
//			PreparedStatement p = (PreparedStatement) connection.prepareStatement(sql);
//			p.setInt(1, existedCustomer.getId());
//			p.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testInvalidCreateCustomer9() {
		try {
			System.out.println("Running testCreateCustomer...");
			customerDAO = new CustomerDAO();
			java.sql.Date dob = java.sql.Date.valueOf("1999-12-31");
			Customer customer = new Customer("Pham Minh Hieu", "01219451", dob, "Ha Noi#$^&", "0904579384");
			customerDAO.insertCustomer(customer);
			Customer existedCustomer = customerDAO.selectCustomerbyidcard("01219451");
			//assertEquals("Pham Minh Hieu", existedCustomer.getName());
			Assertions.assertNull(existedCustomer);

			// rollback
			Connection connection = getConnection();
			String sql = "delete from tblCustomer where id = ?";
			PreparedStatement p = (PreparedStatement) connection.prepareStatement(sql);
			p.setInt(1, existedCustomer.getId());
			p.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testInvalidCreateCustomer10() {
		try {
			System.out.println("Running testCreateCustomer...");
			customerDAO = new CustomerDAO();
			java.sql.Date dob = java.sql.Date.valueOf("1999-12-31");
			Customer customer = new Customer("Pham Minh Hieu", "01219451", dob, "Ha Noi", "0904579384@$%&");
			customerDAO.insertCustomer(customer);
			Customer existedCustomer = customerDAO.selectCustomerbyidcard("01219451");
			//assertEquals("Pham Minh Hieu", existedCustomer.getName());
			Assertions.assertNull(existedCustomer);

			// rollback
			Connection connection = getConnection();
			String sql = "delete from tblCustomer where id = ?";
			PreparedStatement p = (PreparedStatement) connection.prepareStatement(sql);
			p.setInt(1, existedCustomer.getId());
			p.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testInvalidCreateCustomer11() {
		try {
			System.out.println("Running testCreateCustomer...");
			customerDAO = new CustomerDAO();
			java.sql.Date dob = java.sql.Date.valueOf("1999-12-31");
			Customer customer = new Customer("Pham Minh Hieu", "01219", dob, "Ha Noi", "0904579384");
			customerDAO.insertCustomer(customer);
			Customer existedCustomer = customerDAO.selectCustomerbyidcard("01219");
			//assertEquals("Pham Minh Hieu", existedCustomer.getName());
			Assertions.assertNull(existedCustomer);

			// rollback
			Connection connection = getConnection();
			String sql = "delete from tblCustomer where id = ?";
			PreparedStatement p = (PreparedStatement) connection.prepareStatement(sql);
			p.setInt(1, existedCustomer.getId());
			p.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testInvalidCreateCustomer12() {
		try {
			System.out.println("Running testCreateCustomer...");
			customerDAO = new CustomerDAO();
			java.sql.Date dob = java.sql.Date.valueOf("1999-12-31");
			Customer customer = new Customer("Pham Minh Hieu", "012194512", dob, "Ha Noi", "0904579384");
			customerDAO.insertCustomer(customer);
			Customer existedCustomer = customerDAO.selectCustomerbyidcard("012194512");
			//assertEquals("Pham Minh Hieu", existedCustomer.getName());
			Assertions.assertNull(existedCustomer);

			// rollback
			Connection connection = getConnection();
			String sql = "delete from tblCustomer where id = ?";
			PreparedStatement p = (PreparedStatement) connection.prepareStatement(sql);
			p.setInt(1, existedCustomer.getId());
			p.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testInvalidCreateCustomer13() {
		try {
			System.out.println("Running testCreateCustomer...");
			customerDAO = new CustomerDAO();
			java.sql.Date dob = java.sql.Date.valueOf("1999-12-31");
			Customer customer = new Customer("Pham Minh Hieu", "0121945123522", dob, "Ha Noi", "0904579384");
			customerDAO.insertCustomer(customer);
			Customer existedCustomer = customerDAO.selectCustomerbyidcard("0121945123522");
			//assertEquals("Pham Minh Hieu", existedCustomer.getName());
			Assertions.assertNull(existedCustomer);

			// rollback
			Connection connection = getConnection();
			String sql = "delete from tblCustomer where id = ?";
			PreparedStatement p = (PreparedStatement) connection.prepareStatement(sql);
			p.setInt(1, existedCustomer.getId());
			p.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testInvalidCreateCustomer14() {
		try {
			System.out.println("Running testCreateCustomer...");
			customerDAO = new CustomerDAO();
			java.sql.Date dob = java.sql.Date.valueOf("2022-12-31");
			Customer customer = new Customer("Pham Minh Hieu", "01219451", dob, "Ha Noi", "0904579384");
			customerDAO.insertCustomer(customer);
			Customer existedCustomer = customerDAO.selectCustomerbyidcard("01219451");
			//assertEquals("Pham Minh Hieu", existedCustomer.getName());
			Assertions.assertNull(existedCustomer);

			// rollback
			Connection connection = getConnection();
			String sql = "delete from tblCustomer where id = ?";
			PreparedStatement p = (PreparedStatement) connection.prepareStatement(sql);
			p.setInt(1, existedCustomer.getId());
			p.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testInvalidCreateCustomer15() {
		try {
			System.out.println("Running testCreateCustomer...");
			customerDAO = new CustomerDAO();
			java.sql.Date dob = java.sql.Date.valueOf("1999-12-31");
			Customer customer = new Customer("Pham Minh Hieu", "01219451", dob, "Ha Noi", "0904579384");
			customerDAO.insertCustomer(customer);
			customerDAO.insertCustomer(customer);
			//assertEquals("Pham Minh Hieu", existedCustomer.getName());
			Customer existedCustomer = customerDAO.selectCustomerbyidcard("01219451");
			// rollback
			Connection connection = getConnection();
			String sql = "delete from tblCustomer where id = ?";
			PreparedStatement p = (PreparedStatement) connection.prepareStatement(sql);
			p.setInt(1, existedCustomer.getId());
			p.executeUpdate();
			Customer existedCustomer2 = customerDAO.selectCustomerbyidcard("01219451");
			Assertions.assertNull(existedCustomer2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testValideUpdateCustomer() {
		try {
			System.out.println("Running testUpdateCustomer...");
			customerDAO = new CustomerDAO();
			Customer rollBackCustomer = customerDAO.selectCustomerbyidcard("01232989");
			java.sql.Date dob = java.sql.Date.valueOf("1999-12-31");
			Customer customer = new Customer(59, "Pham Minh Hai", "01232989", dob, "Nguyan Trai", "0904579384");
			customerDAO.updateCustomer(customer);
			Customer existedCustomer = customerDAO.selectCustomerbyidcard("01232989");
			assertEquals("Pham Minh Hai", existedCustomer.getName());
			//Assertions.assertNull(existedCustomer);
			// rollback
//			Connection connection = getConnection();
//			String sql = "update tblCustomer set name = ?, idCardNum = ?, dob = ?, address = ?, telephone = ? where id = ?;";
//			PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);
//			statement.setString(1, rollBackCustomer.getName());
//			statement.setString(2, rollBackCustomer.getIdCardNum());
//			statement.setDate(3, rollBackCustomer.getDob());
//			statement.setString(4, rollBackCustomer.getAddress());
//			statement.setString(5, rollBackCustomer.getTelephone());
//			statement.setInt(6, rollBackCustomer.getId());
//			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	@Test
	public void testINvalideUpdateCustomer1() {
		try {
			System.out.println("Running testUpdateCustomer...");
			customerDAO = new CustomerDAO();
			Customer rollBackCustomer = customerDAO.selectCustomerbyidcard("01232989");
			int id = Integer.parseInt(null);
			java.sql.Date dob = java.sql.Date.valueOf("1999-12-31");
			Customer customer = new Customer(id, "Pham Minh Hai Nam", "01232989", dob, "Nguyan Trai", "0904579384");
			customerDAO.updateCustomer(customer);
			Customer existedCustomer = customerDAO.selectCustomerbyidcard("01232989");
			assertEquals("Pham Minh Hai", existedCustomer.getName());
			//Assertions.assertNull(existedCustomer);
			// rollback
			Connection connection = getConnection();
			String sql = "update tblCustomer set name = ?, idCardNum = ?, dob = ?, address = ?, telephone = ? where id = ?;";
			PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);
			statement.setString(1, rollBackCustomer.getName());
			statement.setString(2, rollBackCustomer.getIdCardNum());
			statement.setDate(3, rollBackCustomer.getDob());
			statement.setString(4, rollBackCustomer.getAddress());
			statement.setString(5, rollBackCustomer.getTelephone());
			statement.setInt(6, rollBackCustomer.getId());
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	@Test
	public void testINvalideUpdateCustomer2() {
		try {
			System.out.println("Running testUpdateCustomer...");
			customerDAO = new CustomerDAO();
			Customer rollBackCustomer = customerDAO.selectCustomerbyidcard("01232989");
			java.sql.Date dob = java.sql.Date.valueOf("1999-12-31");
			Customer customer = new Customer(59, null, "01232989", dob, "Nguyan Trai", "0904579384");
			customerDAO.updateCustomer(customer);
			Customer existedCustomer = customerDAO.selectCustomerbyidcard("01232989");
			assertEquals("Pham Minh Hai", existedCustomer.getName());
			//Assertions.assertNull(existedCustomer);
			// rollback
			Connection connection = getConnection();
			String sql = "update tblCustomer set name = ?, idCardNum = ?, dob = ?, address = ?, telephone = ? where id = ?;";
			PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);
			statement.setString(1, rollBackCustomer.getName());
			statement.setString(2, rollBackCustomer.getIdCardNum());
			statement.setDate(3, rollBackCustomer.getDob());
			statement.setString(4, rollBackCustomer.getAddress());
			statement.setString(5, rollBackCustomer.getTelephone());
			statement.setInt(6, rollBackCustomer.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	@Test
	public void testINvalideUpdateCustomer3() {
		try {
			System.out.println("Running testUpdateCustomer...");
			customerDAO = new CustomerDAO();
			Customer rollBackCustomer = customerDAO.selectCustomerbyidcard("01232989");
			java.sql.Date dob = java.sql.Date.valueOf("1999-12-31");
			Customer customer = new Customer(59, "Pham Minh Hai Nam", null, dob, "Nguyan Trai", "0904579384");
			customerDAO.updateCustomer(customer);
			Customer existedCustomer = customerDAO.selectCustomerbyidcard("01232989");
			assertEquals("Pham Minh Hai", existedCustomer.getName());
			//Assertions.assertNull(existedCustomer);
			// rollback
			Connection connection = getConnection();
			String sql = "update tblCustomer set name = ?, idCardNum = ?, dob = ?, address = ?, telephone = ? where id = ?;";
			PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);
			statement.setString(1, rollBackCustomer.getName());
			statement.setString(2, rollBackCustomer.getIdCardNum());
			statement.setDate(3, rollBackCustomer.getDob());
			statement.setString(4, rollBackCustomer.getAddress());
			statement.setString(5, rollBackCustomer.getTelephone());
			statement.setInt(6, rollBackCustomer.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	@Test
	public void testINvalideUpdateCustomer4() {
		try {
			System.out.println("Running testUpdateCustomer...");
			customerDAO = new CustomerDAO();
			Customer rollBackCustomer = customerDAO.selectCustomerbyidcard("01232989");
			java.sql.Date dob = java.sql.Date.valueOf("1999-12-31");
			Customer customer = new Customer(59, "Pham Minh Hai Nam", "01232989", null, "Nguyan Trai", "0904579384");
			customerDAO.updateCustomer(customer);
			Customer existedCustomer = customerDAO.selectCustomerbyidcard("01232989");
			assertEquals("Pham Minh Hai", existedCustomer.getName());
			//Assertions.assertNull(existedCustomer);
			// rollback
			Connection connection = getConnection();
			String sql = "update tblCustomer set name = ?, idCardNum = ?, dob = ?, address = ?, telephone = ? where id = ?;";
			PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);
			statement.setString(1, rollBackCustomer.getName());
			statement.setString(2, rollBackCustomer.getIdCardNum());
			statement.setDate(3, rollBackCustomer.getDob());
			statement.setString(4, rollBackCustomer.getAddress());
			statement.setString(5, rollBackCustomer.getTelephone());
			statement.setInt(6, rollBackCustomer.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	@Test
	public void testINvalideUpdateCustomer5() {
		try {
			System.out.println("Running testUpdateCustomer...");
			customerDAO = new CustomerDAO();
			Customer rollBackCustomer = customerDAO.selectCustomerbyidcard("01232989");
			java.sql.Date dob = java.sql.Date.valueOf("1999-12-31");
			Customer customer = new Customer(59, "Pham Minh Hai", "01232989", dob, null, "0904579384");
			customerDAO.updateCustomer(customer);
			Customer existedCustomer = customerDAO.selectCustomerbyidcard("01232989");
			assertEquals("Pham Minh Hai", existedCustomer.getName());
			//Assertions.assertNull(existedCustomer);
			// rollback
			Connection connection = getConnection();
			String sql = "update tblCustomer set name = ?, idCardNum = ?, dob = ?, address = ?, telephone = ? where id = ?;";
			PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);
			statement.setString(1, rollBackCustomer.getName());
			statement.setString(2, rollBackCustomer.getIdCardNum());
			statement.setDate(3, rollBackCustomer.getDob());
			statement.setString(4, rollBackCustomer.getAddress());
			statement.setString(5, rollBackCustomer.getTelephone());
			statement.setInt(6, rollBackCustomer.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	@Test
	public void testINvalideUpdateCustomer6() {
		try {
			System.out.println("Running testUpdateCustomer...");
			customerDAO = new CustomerDAO();
			Customer rollBackCustomer = customerDAO.selectCustomerbyidcard("01232989");
			java.sql.Date dob = java.sql.Date.valueOf("1999-12-31");
			Customer customer = new Customer(59, "Pham Minh Hai Nam", "01232989", dob, "Nguyan Trai", null);
			customerDAO.updateCustomer(customer);
			Customer existedCustomer = customerDAO.selectCustomerbyidcard("01232989");
			assertEquals("Pham Minh Hai Nam", existedCustomer.getName());
			//Assertions.assertNull(existedCustomer);
			// rollback
			Connection connection = getConnection();
			String sql = "update tblCustomer set name = ?, idCardNum = ?, dob = ?, address = ?, telephone = ? where id = ?;";
			PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);
			statement.setString(1, rollBackCustomer.getName());
			statement.setString(2, rollBackCustomer.getIdCardNum());
			statement.setDate(3, rollBackCustomer.getDob());
			statement.setString(4, rollBackCustomer.getAddress());
			statement.setString(5, rollBackCustomer.getTelephone());
			statement.setInt(6, rollBackCustomer.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	@Test
	public void testINvalideUpdateCustomer7() {
		try {
			System.out.println("Running testUpdateCustomer...");
			customerDAO = new CustomerDAO();
			Customer rollBackCustomer = customerDAO.selectCustomerbyidcard("01232989");
			int id = Integer.parseInt("1@");
			java.sql.Date dob = java.sql.Date.valueOf("1999-12-31");
			Customer customer = new Customer(id, "Pham Minh Hai Nam", "01232989", dob, "Nguyan Trai", "0904579384");
			customerDAO.updateCustomer(customer);
			Customer existedCustomer = customerDAO.selectCustomerbyidcard("01232989");
			assertEquals("Pham Minh Hai", existedCustomer.getName());
			//Assertions.assertNull(existedCustomer);
			// rollback
			Connection connection = getConnection();
			String sql = "update tblCustomer set name = ?, idCardNum = ?, dob = ?, address = ?, telephone = ? where id = ?;";
			PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);
			statement.setString(1, rollBackCustomer.getName());
			statement.setString(2, rollBackCustomer.getIdCardNum());
			statement.setDate(3, rollBackCustomer.getDob());
			statement.setString(4, rollBackCustomer.getAddress());
			statement.setString(5, rollBackCustomer.getTelephone());
			statement.setInt(6, rollBackCustomer.getId());
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	@Test
	public void testINvalideUpdateCustomer8() {
		try {
			System.out.println("Running testUpdateCustomer...");
			customerDAO = new CustomerDAO();
			Customer rollBackCustomer = customerDAO.selectCustomerbyidcard("01232989");
			java.sql.Date dob = java.sql.Date.valueOf("1999-12-31");
			Customer customer = new Customer(59, "Pham Minh Hai @%$#", "01232989", dob, "Nguyan Trai", "0904579384");
			customerDAO.updateCustomer(customer);
			Customer existedCustomer = customerDAO.selectCustomerbyidcard("01232989");
			assertEquals("Pham Minh Hai", existedCustomer.getName());
			//Assertions.assertNull(existedCustomer);
			// rollback
			Connection connection = getConnection();
			String sql = "update tblCustomer set name = ?, idCardNum = ?, dob = ?, address = ?, telephone = ? where id = ?;";
			PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);
			statement.setString(1, rollBackCustomer.getName());
			statement.setString(2, rollBackCustomer.getIdCardNum());
			statement.setDate(3, rollBackCustomer.getDob());
			statement.setString(4, rollBackCustomer.getAddress());
			statement.setString(5, rollBackCustomer.getTelephone());
			statement.setInt(6, rollBackCustomer.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	@Test
	public void testINvalideUpdateCustomer9() {
		try {
			System.out.println("Running testUpdateCustomer...");
			customerDAO = new CustomerDAO();
			Customer rollBackCustomer = customerDAO.selectCustomerbyidcard("01232989");
			java.sql.Date dob = java.sql.Date.valueOf("1999-12-31");
			Customer customer = new Customer(59, "Pham Minh Hai", "01232989@#", dob, "Nguyan Trai", "0904579384");
			customerDAO.updateCustomer(customer);
			Customer existedCustomer = customerDAO.selectCustomerbyidcard("01232989@#");
			//assertEquals("Pham Minh Hai", existedCustomer.getName());
			Assertions.assertNull(existedCustomer);
			// rollback
			Connection connection = getConnection();
			String sql = "update tblCustomer set name = ?, idCardNum = ?, dob = ?, address = ?, telephone = ? where id = ?;";
			PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);
			statement.setString(1, rollBackCustomer.getName());
			statement.setString(2, rollBackCustomer.getIdCardNum());
			statement.setDate(3, rollBackCustomer.getDob());
			statement.setString(4, rollBackCustomer.getAddress());
			statement.setString(5, rollBackCustomer.getTelephone());
			statement.setInt(6, rollBackCustomer.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	@Test
	public void testINvalideUpdateCustomer10() {
		try {
			System.out.println("Running testUpdateCustomer...");
			customerDAO = new CustomerDAO();
			Customer rollBackCustomer = customerDAO.selectCustomerbyidcard("01232989");
			java.sql.Date dob = java.sql.Date.valueOf("1999-12-31@#");
			Customer customer = new Customer(59, "Pham Minh Hai", "01232989", dob, "Nguyan Trai", "0904579384");
			customerDAO.updateCustomer(customer);
			Customer existedCustomer = customerDAO.selectCustomerbyidcard("01232989");
			assertEquals("Pham Minh Hai", existedCustomer.getName());
			//Assertions.assertNull(existedCustomer);
			// rollback
			Connection connection = getConnection();
			String sql = "update tblCustomer set name = ?, idCardNum = ?, dob = ?, address = ?, telephone = ? where id = ?;";
			PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);
			statement.setString(1, rollBackCustomer.getName());
			statement.setString(2, rollBackCustomer.getIdCardNum());
			statement.setDate(3, rollBackCustomer.getDob());
			statement.setString(4, rollBackCustomer.getAddress());
			statement.setString(5, rollBackCustomer.getTelephone());
			statement.setInt(6, rollBackCustomer.getId());
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	@Test
	public void testINvalideUpdateCustomer11() {
		try {
			System.out.println("Running testUpdateCustomer...");
			customerDAO = new CustomerDAO();
			Customer rollBackCustomer = customerDAO.selectCustomerbyidcard("01232989");
			java.sql.Date dob = java.sql.Date.valueOf("1999-12-31");
			Customer customer = new Customer(59, "Pham Minh Hai Nam", "01232989", dob, "Nguyan Trai@#%", "0904579384");
			customerDAO.updateCustomer(customer);
			Customer existedCustomer = customerDAO.selectCustomerbyidcard("01232989");
			assertEquals("Pham Minh Hai", existedCustomer.getName());
			//Assertions.assertNull(existedCustomer);
			// rollback
			Connection connection = getConnection();
			String sql = "update tblCustomer set name = ?, idCardNum = ?, dob = ?, address = ?, telephone = ? where id = ?;";
			PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);
			statement.setString(1, rollBackCustomer.getName());
			statement.setString(2, rollBackCustomer.getIdCardNum());
			statement.setDate(3, rollBackCustomer.getDob());
			statement.setString(4, rollBackCustomer.getAddress());
			statement.setString(5, rollBackCustomer.getTelephone());
			statement.setInt(6, rollBackCustomer.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	@Test
	public void testINvalideUpdateCustomer12() {
		try {
			System.out.println("Running testUpdateCustomer...");
			customerDAO = new CustomerDAO();
			Customer rollBackCustomer = customerDAO.selectCustomerbyidcard("01232989");
			java.sql.Date dob = java.sql.Date.valueOf("1999-12-31");
			Customer customer = new Customer(59, "Pham Minh Hai Nam", "01232989", dob, "Nguyan Trai", "0904579384@#");
			customerDAO.updateCustomer(customer);
			Customer existedCustomer = customerDAO.selectCustomerbyidcard("01232989");
			assertEquals("Pham Minh Hai", existedCustomer.getName());
			//Assertions.assertNull(existedCustomer);
			// rollback
			Connection connection = getConnection();
			String sql = "update tblCustomer set name = ?, idCardNum = ?, dob = ?, address = ?, telephone = ? where id = ?;";
			PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);
			statement.setString(1, rollBackCustomer.getName());
			statement.setString(2, rollBackCustomer.getIdCardNum());
			statement.setDate(3, rollBackCustomer.getDob());
			statement.setString(4, rollBackCustomer.getAddress());
			statement.setString(5, rollBackCustomer.getTelephone());
			statement.setInt(6, rollBackCustomer.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	@Test
	public void testINvalideUpdateCustomer13() {
		try {
			System.out.println("Running testUpdateCustomer...");
			customerDAO = new CustomerDAO();
			Customer rollBackCustomer = customerDAO.selectCustomerbyidcard("01232989");
			java.sql.Date dob = java.sql.Date.valueOf("1999-12-31");
			Customer customer = new Customer(59, "Pham Minh Hai Nam", "012", dob, "Nguyan Trai", "0904579384");
			customerDAO.updateCustomer(customer);
			Customer existedCustomer = customerDAO.selectCustomerbyidcard("012");
			assertEquals("Pham Minh Hai", existedCustomer.getName());
			//Assertions.assertNull(existedCustomer);
			// rollback
			Connection connection = getConnection();
			String sql = "update tblCustomer set name = ?, idCardNum = ?, dob = ?, address = ?, telephone = ? where id = ?;";
			PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);
			statement.setString(1, rollBackCustomer.getName());
			statement.setString(2, rollBackCustomer.getIdCardNum());
			statement.setDate(3, rollBackCustomer.getDob());
			statement.setString(4, rollBackCustomer.getAddress());
			statement.setString(5, rollBackCustomer.getTelephone());
			statement.setInt(6, rollBackCustomer.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	@Test
	public void testINvalideUpdateCustomer14() {
		try {
			System.out.println("Running testUpdateCustomer...");
			customerDAO = new CustomerDAO();
			Customer rollBackCustomer = customerDAO.selectCustomerbyidcard("01232989");
			java.sql.Date dob = java.sql.Date.valueOf("1999-12-31");
			Customer customer = new Customer(59, "Pham Minh Hai Nam", "012329892", dob, "Nguyan Trai", "0904579384");
			customerDAO.updateCustomer(customer);
			Customer existedCustomer = customerDAO.selectCustomerbyidcard("012329892");
			assertEquals("Pham Minh Hai", existedCustomer.getName());
			//Assertions.assertNull(existedCustomer);
			// rollback
			Connection connection = getConnection();
			String sql = "update tblCustomer set name = ?, idCardNum = ?, dob = ?, address = ?, telephone = ? where id = ?;";
			PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);
			statement.setString(1, rollBackCustomer.getName());
			statement.setString(2, rollBackCustomer.getIdCardNum());
			statement.setDate(3, rollBackCustomer.getDob());
			statement.setString(4, rollBackCustomer.getAddress());
			statement.setString(5, rollBackCustomer.getTelephone());
			statement.setInt(6, rollBackCustomer.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	@Test
	public void testINvalideUpdateCustomer15() {
		try {
			System.out.println("Running testUpdateCustomer...");
			customerDAO = new CustomerDAO();
			Customer rollBackCustomer = customerDAO.selectCustomerbyidcard("01232989");
			java.sql.Date dob = java.sql.Date.valueOf("1999-12-31");
			Customer customer = new Customer(59, "Pham Minh Hai Nam", "01232989123121", dob, "Nguyan Trai", "0904579384");
			customerDAO.updateCustomer(customer);
			Customer existedCustomer = customerDAO.selectCustomerbyidcard("01232989123121");
			assertEquals("Pham Minh Hai", existedCustomer.getName());
			//Assertions.assertNull(existedCustomer);
			// rollback
			Connection connection = getConnection();
			String sql = "update tblCustomer set name = ?, idCardNum = ?, dob = ?, address = ?, telephone = ? where id = ?;";
			PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);
			statement.setString(1, rollBackCustomer.getName());
			statement.setString(2, rollBackCustomer.getIdCardNum());
			statement.setDate(3, rollBackCustomer.getDob());
			statement.setString(4, rollBackCustomer.getAddress());
			statement.setString(5, rollBackCustomer.getTelephone());
			statement.setInt(6, rollBackCustomer.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	@Test
	public void testINvalideUpdateCustomer16() {
		try {
			System.out.println("Running testUpdateCustomer...");
			customerDAO = new CustomerDAO();
			Customer rollBackCustomer = customerDAO.selectCustomerbyidcard("01232989");
			java.sql.Date dob = java.sql.Date.valueOf("2022-12-31");
			Customer customer = new Customer(59, "Pham Minh Hai Nam", "01232989", dob, "Nguyan Trai", "0904579384");
			customerDAO.updateCustomer(customer);
			Customer existedCustomer = customerDAO.selectCustomerbyidcard("01232989");
			assertEquals("Pham Minh Hai", existedCustomer.getName());
			//Assertions.assertNull(existedCustomer);
			// rollback
			Connection connection = getConnection();
			String sql = "update tblCustomer set name = ?, idCardNum = ?, dob = ?, address = ?, telephone = ? where id = ?;";
			PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);
			statement.setString(1, rollBackCustomer.getName());
			statement.setString(2, rollBackCustomer.getIdCardNum());
			statement.setDate(3, rollBackCustomer.getDob());
			statement.setString(4, rollBackCustomer.getAddress());
			statement.setString(5, rollBackCustomer.getTelephone());
			statement.setInt(6, rollBackCustomer.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	@Test
	public void testINvalideUpdateCustomer17() {
		try {
			System.out.println("Running testUpdateCustomer...");
			customerDAO = new CustomerDAO();
			Customer rollBackCustomer = customerDAO.selectCustomerbyidcard("01232989");
			java.sql.Date dob = java.sql.Date.valueOf("1999-12-31");
			Customer customer = new Customer(59, "Pham Minh Hai Nam", "01219451", dob, "Nguyan Trai", "0904579384");
			customerDAO.updateCustomer(customer);
			Customer existedCustomer = customerDAO.selectCustomerbyidcard("01219451");
			assertEquals("Pham Minh Hieu", existedCustomer.getName());
			//Assertions.assertNull(existedCustomer);
			// rollback
			Connection connection = getConnection();
			String sql = "update tblCustomer set name = ?, idCardNum = ?, dob = ?, address = ?, telephone = ? where id = ?;";
			PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);
			statement.setString(1, rollBackCustomer.getName());
			statement.setString(2, rollBackCustomer.getIdCardNum());
			statement.setDate(3, rollBackCustomer.getDob());
			statement.setString(4, rollBackCustomer.getAddress());
			statement.setString(5, rollBackCustomer.getTelephone());
			statement.setInt(6, rollBackCustomer.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	@Test
	public void testGet() {
		System.out.println("Running testGet...");
		customerDAO = new CustomerDAO();
		Customer customer = customerDAO.selectCustomer(59);
		assertEquals(59, customer.getId());
	}
	@Test
	public void testInvalidGet() {
		try {
			System.out.println("Running testGet...");
			int id = Integer.parseInt(null);
			customerDAO = new CustomerDAO();
			Customer customer = customerDAO.selectCustomer(id);
		} catch (Exception e) {
			e.printStackTrace();
	
		}
	}
	@Test
	public void testInvalidGet2() {
		try {
			System.out.println("Running testGet...");
			int id = Integer.parseInt("1@");
			customerDAO = new CustomerDAO();
			Customer customer = customerDAO.selectCustomer(id);
		} catch (Exception e) {
			e.printStackTrace();
	
		}
	}
	@Test
	public void testListCustomer() {

		customerDAO = new CustomerDAO();
		System.out.println("Running testListCustomer...");
		List<Customer> customers = customerDAO.selectAllCustomer();
		Assertions.assertFalse(customers.isEmpty());

	}

	@Test
	public void testValidDeleteCustomer() {
		try {
			System.out.println("Running testDeleteCustomer...");
			customerDAO = new CustomerDAO();
			Customer rollBackCustomer = customerDAO.selectCustomer(59);
			Customer customer = customerDAO.selectCustomer(59);
			customerDAO.deleteCustomer(59);
			Customer deletedCustomer = customerDAO.selectCustomer(59);

			Assertions.assertNull(deletedCustomer);
			
			//rollback
			Connection connection = getConnection();
			String sql = "INSERT INTO tblCustomer" + "  (name, idCardNum, dob, address, telephone) VALUES " + " (?, ?, ?, ?, ?);";
			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			preparedStatement.setString(1, customer.getName());
			preparedStatement.setString(2, customer.getIdCardNum());
			preparedStatement.setDate(3, customer.getDob());
			preparedStatement.setString(4, customer.getAddress());
			preparedStatement.setString(5, customer.getTelephone());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();

		}

	}
	@Test
	public void testInvalidDeleteCustomer1() {
		try {
			System.out.println("Running testDeleteCustomer...");
			customerDAO = new CustomerDAO();
			int id = Integer.parseInt(null);
			Customer rollBackCustomer = customerDAO.selectCustomer(id);
			Customer customer = customerDAO.selectCustomer(id);
			customerDAO.deleteCustomer(id);
			Customer deletedCustomer = customerDAO.selectCustomer(id);

			
			//rollback
//			Connection connection = getConnection();
//			String sql = "INSERT INTO tblCustomer" + "  (name, idCardNum, dob, address, telephone) VALUES " + " (?, ?, ?, ?, ?);";
//			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
//			preparedStatement.setString(1, customer.getName());
//			preparedStatement.setString(2, customer.getIdCardNum());
//			preparedStatement.setDate(3, customer.getDob());
//			preparedStatement.setString(4, customer.getAddress());
//			preparedStatement.setString(5, customer.getTelephone());
//			System.out.println(preparedStatement);
//			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();

		}

	}
	@Test
	public void testInvalidDeleteCustomer2() {
		try {
			System.out.println("Running testDeleteCustomer...");
			customerDAO = new CustomerDAO();
			int id = Integer.parseInt("2@");
			Customer rollBackCustomer = customerDAO.selectCustomer(id);
			Customer customer = customerDAO.selectCustomer(id);
			customerDAO.deleteCustomer(id);
			Customer deletedCustomer = customerDAO.selectCustomer(id);

			
			//rollback
//			Connection connection = getConnection();
//			String sql = "INSERT INTO tblCustomer" + "  (name, idCardNum, dob, address, telephone) VALUES " + " (?, ?, ?, ?, ?);";
//			PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
//			preparedStatement.setString(1, customer.getName());
//			preparedStatement.setString(2, customer.getIdCardNum());
//			preparedStatement.setDate(3, customer.getDob());
//			preparedStatement.setString(4, customer.getAddress());
//			preparedStatement.setString(5, customer.getTelephone());
//			System.out.println(preparedStatement);
//			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}
