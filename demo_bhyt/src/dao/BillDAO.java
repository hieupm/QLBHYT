package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Bill;



public class BillDAO extends CustomerDAO{

	private static final String INSERT_BILL_SQL = "INSERT INTO tblBill" + "  (type, paidDate, tblCustomerid, tblAssociationid) VALUES "
			+ " (?, ?, ?, ?);";
	private static final String INSERT_BILL_SQL_NULLASSOCIATION = "INSERT INTO tblBill" + "  (type, paidDate, tblCustomerid) VALUES "
			+ " (?, ?, ?);";
//	private static final String SELECT_BILL_BY_ID = "select id,type,paidDate,tblCustomerid,tblAssociationid where id =?";

	private static final String SELECT_ALL_BILL = "SELECT * FROM tblBill";

	private static final String SELECT_INCREMENT_ID = "SELECT MAX(ID) FROM tblBill";
	
	private static final String SELECT_COUNT_ID = "SELECT COUNT(ID) FROM tblBill";
	
	public BillDAO() {
		
	}
	
	public int countBill() throws SQLException{
		int countId = 0;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_COUNT_ID);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				countId = rs.getInt("COUNT(ID)");		
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return countId;
	}
	public int incrementId () throws SQLException {

		int id = 0;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_INCREMENT_ID);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				id = rs.getInt("MAX(ID)");
						
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return id;
		
		
	}
	
	public boolean insertBill (Bill bill) throws SQLException {

		System.out.println(INSERT_BILL_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BILL_SQL)) {
			preparedStatement.setString(1, bill.getType());
			preparedStatement.setDate(2, bill.getPaidDate());
			preparedStatement.setInt(3, bill.getTblCustomerid());
			preparedStatement.setInt(4, bill.getTblAssociationid());
			
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			printSQLException(e);
		}
		return false;
		
	}
	
//	public Bill selectbill(int id) {
//		Bill bill = null;
//		// Step 1: Establishing a Connection
//		try (Connection connection = getConnection();
//				// Step 2:Create a statement using connection object
//				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BILL_BY_ID);) {
//			preparedStatement.setInt(1, id);
//			System.out.println(preparedStatement);
//			// Step 3: Execute the query or update query
//			ResultSet rs = preparedStatement.executeQuery();
//
//			// Step 4: Process the ResultSet object.
//			while (rs.next()) {
//				String type = rs.getString("type");
//				Date paidDate = rs.getDate("paidDate");
//				int tblCustomerid = rs.getInt("tblCustomerid");
//				int tblAssociationid = rs.getInt("tblAssociationid"); 
//				
//				bill = new Bill(id, type, paidDate, tblCustomerid, tblAssociationid);
//				System.out.println(bill.toString());
//			}
//		} catch (SQLException e) {
//			printSQLException(e);
//		}
//		return bill;
//	}
	
	public boolean insertBill2 (Bill bill) throws SQLException {

		System.out.println(INSERT_BILL_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BILL_SQL_NULLASSOCIATION)) {
			preparedStatement.setString(1, bill.getType());
			preparedStatement.setDate(2, bill.getPaidDate());
			preparedStatement.setInt(3, bill.getTblCustomerid());
			
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			printSQLException(e);
		}
		return false;
		
	}
	
	
	public List<Bill> selectAllBill() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Bill> bill = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BILL);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String type = rs.getString("type");
				Date paidDate = rs.getDate("paidDate");
				int tblCustomerId = rs.getInt("tblCustomerId");
				int tblAssociationid = rs.getInt("tblAssociationid");
				bill.add(new Bill(id, type, paidDate, tblCustomerId, tblAssociationid));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return bill;
	}

}
