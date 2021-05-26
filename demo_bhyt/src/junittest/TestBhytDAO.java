package junittest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.mysql.jdbc.PreparedStatement;

import control.Payment;
import dao.BhytDAO;
import dao.BillDAO;
import dao.CustomerDAO;
import dao.HospitalDAO;
import model.BHYT;
import model.Customer;
import model.Hospital;

public class TestBhytDAO {
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
    public void testCreateBHYT1() {
		try {

			billDAO = new BillDAO();
			customerDAO = new CustomerDAO();
			hospitalDAO = new HospitalDAO();
			bhytDAO = new BhytDAO();
			int billId = 1;
			int countId1 = bhytDAO.countBhyt(); 
	        java.sql.Date startDate = java.sql.Date.valueOf("2020-10-10");
	        java.sql.Date endDate = java.sql.Date.valueOf("2021-10-10");
//	        java.sql.Date paidDate = java.sql.Date.valueOf("2020-12-12");
	        float supportLevel = (float) 0.4;
	        Customer cus = customerDAO.selectCustomerbyidcard("012913248");
	        Hospital hos = hospitalDAO.selectHospitalById(1);
	        BHYT bhyt = new BHYT(startDate, endDate, supportLevel, 7500000, cus, hos, billId);
	        
	        bhytDAO.insertBhyt(bhyt);
	        
	        int countId2 = bhytDAO.countBhyt();
	        
	        assertEquals(countId1+1, countId2);
	        
	      //rollback
			Connection connection = getConnection();
			String sql = "delete from tblBHYT where id = ?";
			PreparedStatement p = (PreparedStatement) connection.prepareStatement(sql);
			p.setInt(1, countId2);
			p.executeUpdate();
	        
		}catch (SQLException e) {
            e.printStackTrace();
        }
	}
		@Test
	    public void testCreateBHYT2() {
			try {

				billDAO = new BillDAO();
				customerDAO = new CustomerDAO();
				hospitalDAO = new HospitalDAO();
				bhytDAO = new BhytDAO();
				int billId = 1;
				int countId1 = bhytDAO.countBhyt(); 
		        java.sql.Date startDate = java.sql.Date.valueOf("2020-10-10");
		        java.sql.Date endDate = java.sql.Date.valueOf("2021-10-10");
		        float supportLevel = (float) 0.4;
		        Customer cus = customerDAO.selectCustomerbyidcard("012913248");
		        Hospital hos = hospitalDAO.selectHospitalById(1);
		        BHYT bhyt = new BHYT(null, endDate, supportLevel, 7500000, cus, hos, billId);		        
		        bhytDAO.insertBhyt(bhyt);	  
		        int countId2 = bhytDAO.countBhyt();		        
		        assertEquals(countId1, countId2);
		        
		      //rollback
				Connection connection = getConnection();
				String sql = "delete from tblBHYT where id = ?";
				PreparedStatement p = (PreparedStatement) connection.prepareStatement(sql);
				p.setInt(1, countId2);
				p.executeUpdate();
		        
			}catch (SQLException e) {
	            e.printStackTrace();
	        }
    	
    }
		
		@Test
	    public void testCreateBHYT3() {
			try {

				billDAO = new BillDAO();
				customerDAO = new CustomerDAO();
				hospitalDAO = new HospitalDAO();
				bhytDAO = new BhytDAO();
				
				int countId1 = bhytDAO.countBhyt(); 
				int billId = 1;
		        java.sql.Date startDate = java.sql.Date.valueOf("2020-10-10");
		        float supportLevel = (float) 0.4;
		        Customer cus = customerDAO.selectCustomerbyidcard("012329829");
		        Hospital hos = hospitalDAO.selectHospitalById(1);
		        BHYT bhyt = new BHYT(startDate, null, supportLevel, 7500000, cus, hos, billId);		        
		        bhytDAO.insertBhyt(bhyt);	  
		        int countId2 = bhytDAO.countBhyt();		        
		        assertEquals(countId1, countId2);
		        
		      //rollback
				Connection connection = getConnection();
				String sql = "delete from tblBHYT where id = ?";
				PreparedStatement p = (PreparedStatement) connection.prepareStatement(sql);
				p.setInt(1, countId2);
				p.executeUpdate();
		        
			}catch (SQLException e) {
	            e.printStackTrace();
	        }
    	
    }
		
		@Test
	    public void testCreateBHYT4() {
			try {

				billDAO = new BillDAO();
				customerDAO = new CustomerDAO();
				hospitalDAO = new HospitalDAO();
				bhytDAO = new BhytDAO();
				
				int countId1 = bhytDAO.countBhyt(); 
				int billId = 1;
		        java.sql.Date startDate = java.sql.Date.valueOf("2020-10-10");
		        java.sql.Date endDate = java.sql.Date.valueOf("2027-10-10");
		        float supportLevel = (float) 1.4;
		        Customer cus = customerDAO.selectCustomerbyidcard("012329829");
		        Hospital hos = hospitalDAO.selectHospitalById(1);
		        BHYT bhyt = new BHYT(startDate, endDate, supportLevel, 7500000, cus, hos, billId);		        
		        bhytDAO.insertBhyt(bhyt);	  
		        int countId2 = bhytDAO.countBhyt();		        
		        assertEquals(countId1, countId2);
		        
		      //rollback
				Connection connection = getConnection();
				String sql = "delete from tblBHYT where id = ?";
				PreparedStatement p = (PreparedStatement) connection.prepareStatement(sql);
				p.setInt(1, countId2);
				p.executeUpdate();
		        
			}catch (SQLException e) {
	            e.printStackTrace();
	        }
    	
    }
		
		@Test
	    public void testCreateBHYT5() {
			try {

				billDAO = new BillDAO();
				customerDAO = new CustomerDAO();
				hospitalDAO = new HospitalDAO();
				bhytDAO = new BhytDAO();
				
				int countId1 = bhytDAO.countBhyt(); 
				int billId = 1;
		        java.sql.Date startDate = java.sql.Date.valueOf("2020-10-10");
		        java.sql.Date endDate = java.sql.Date.valueOf("2027-10-10");
		        float supportLevel = (float) 0.4;
		        Customer cus = customerDAO.selectCustomerbyidcard("012329829");
		        Hospital hos = hospitalDAO.selectHospitalById(1);
		        BHYT bhyt = new BHYT(startDate, endDate, supportLevel, -7500000, cus, hos, billId);		        
		        bhytDAO.insertBhyt(bhyt);	  
		        int countId2 = bhytDAO.countBhyt();		        
		        assertEquals(countId1, countId2);
		        
		      //rollback
				Connection connection = getConnection();
				String sql = "delete from tblBHYT where id = ?";
				PreparedStatement p = (PreparedStatement) connection.prepareStatement(sql);
				p.setInt(1, countId2);
				p.executeUpdate();
		        
			}catch (SQLException e) {
	            e.printStackTrace();
	        }
    	
    }
		
		
	
}
