package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.BHYT;

public class BhytDAO extends CustomerDAO{

	private static final String INSERT_BHYT_SQL = "INSERT INTO tblBHYT" + "  (startDate, endDate, supportLevel, salary, tblCustomerid, tblHospitalid, tblBillid ) VALUES "
			+ " (?, ?, ?, ?, ?, ? , ?);";


	public BhytDAO() {
	}
	
	public void insertBhyt (BHYT bhyt) throws SQLException {

		System.out.println(INSERT_BHYT_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BHYT_SQL)) {
			preparedStatement.setDate(1, bhyt.getStartDate());
			preparedStatement.setDate(2, bhyt.getEndDate());
			preparedStatement.setFloat(3, bhyt.getSupportLevel());
			preparedStatement.setInt(4, bhyt.getSalary());
			preparedStatement.setInt(5, bhyt.getCustomer().getId());
			preparedStatement.setInt(6, bhyt.getHospital().getId());
			preparedStatement.setInt(7, bhyt.getTblBillid());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
		
		
	}
	
	

}
