package junittest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.mysql.jdbc.PreparedStatement;

import dao.BhytDAO;
import dao.BillDAO;
import dao.CustomerDAO;
import dao.HospitalDAO;
import model.Bill;

public class TestBillDAO {
	protected CustomerDAO customerDAO;
	private BillDAO billDAO;
	private HospitalDAO hospitalDAO;
	private BhytDAO bhytDAO;
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
	public void testCreateBill1() {
		try {
			billDAO = new BillDAO();
			customerDAO = new CustomerDAO();
			int customerId = 10, associationId = 1;
			int countId1 = billDAO.countBill();
			java.sql.Date paidDate = java.sql.Date.valueOf("2021-05-22");
	        Bill bill = new Bill("Nhóm do cơ quan bảo hiểm xã hội đóng",paidDate, customerId, associationId);
	        
	        billDAO.insertBill(bill);
	        
	        int countId2 = billDAO.countBill();
	        assertEquals(countId1+1, countId2);
	        
	        //rollback
			Connection connection = getConnection();
			String sql = "delete from tblBill where id = ?";
			PreparedStatement p = (PreparedStatement) connection.prepareStatement(sql);
			p.setInt(1, countId2);
			p.executeUpdate();
	        
		} catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	@Test
	public void testCreateBill2() {
		try {
			billDAO = new BillDAO();
			customerDAO = new CustomerDAO();
			int customerId = 10;
			int countId1 = billDAO.countBill();
			
			java.sql.Date paidDate = java.sql.Date.valueOf("2021-05-22");
	        Bill bill = new Bill("Nhóm do cơ quan bảo hiểm xã hội đóng",paidDate, customerId);
	        
	        billDAO.insertBill2(bill);
	        
	        int countId2 = billDAO.countBill();
	        assertEquals(countId1+1, countId2);
	        
	        //rollback
			Connection connection = getConnection();
			String sql = "delete from tblBill where id = ?";
			PreparedStatement p = (PreparedStatement) connection.prepareStatement(sql);
			p.setInt(1, countId2);
			p.executeUpdate();
	        
		} catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	@Test
	public void testCreateBill3() {
		try {
			billDAO = new BillDAO();
			customerDAO = new CustomerDAO();

			int customerId = 10;
			int associationId = 1;
			int countId1 = billDAO.countBill();
			
			java.sql.Date paidDate = java.sql.Date.valueOf("2021-05-22");
	        Bill bill = new Bill(null,paidDate, customerId, associationId);
	        
	        billDAO.insertBill2(bill);
	        
	        int countId2 = billDAO.countBill();
	        assertEquals(countId1, countId2);
	        
	        //rollback
			Connection connection = getConnection();
			String sql = "delete from tblBill where id = ?";
			PreparedStatement p = (PreparedStatement) connection.prepareStatement(sql);
			p.setInt(1, countId2);
			p.executeUpdate();
	        
		} catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	@Test
	public void testCreateBill4() {
		try {
			billDAO = new BillDAO();
			customerDAO = new CustomerDAO();

			int customerId = 10;
			int associationId = 1;
			int countId1 = billDAO.countBill();
			
			java.sql.Date paidDate = java.sql.Date.valueOf("2021-05-22");
	        Bill bill = new Bill("Nhóm do cơ quan bảo hiểm xã hội đóng", null, customerId, associationId);
	        
	        billDAO.insertBill2(bill);
	        
	        int countId2 = billDAO.countBill();
	        assertEquals(countId1, countId2);
	        
	        //rollback
			Connection connection = getConnection();
			String sql = "delete from tblBill where id = ?";
			PreparedStatement p = (PreparedStatement) connection.prepareStatement(sql);
			p.setInt(1, countId2);
			p.executeUpdate();
	        
		} catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	
	@Test
	public void testCreateBill5() {
		try {
			billDAO = new BillDAO();
			customerDAO = new CustomerDAO();

			int customerId = 10;
			int associationId = 1;
			int countId1 = billDAO.countBill();
			
			java.sql.Date paidDate = java.sql.Date.valueOf("2028-05-22");
	        Bill bill = new Bill("Nhóm do cơ quan bảo hiểm xã hội đóng", paidDate, customerId, associationId);
	        
	        billDAO.insertBill2(bill);
	        
	        int countId2 = billDAO.countBill();
	        assertEquals(countId1, countId2);
	        
	        //rollback
			Connection connection = getConnection();
			String sql = "delete from tblBill where id = ?";
			PreparedStatement p = (PreparedStatement) connection.prepareStatement(sql);
			p.setInt(1, countId2);
			p.executeUpdate();
	        
		} catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	@Test
	public void testListBill() {
		billDAO = new BillDAO();
		List<Bill> bills = billDAO.selectAllBill();
		Assertions.assertFalse(bills.isEmpty());

	}
	
}	
