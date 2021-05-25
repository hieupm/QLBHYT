package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Association;
import model.Hospital;

public class HospitalDAO extends CustomerDAO{

	private static final String SELECT_ALL_HOSPITAL = "select * from tblHospital";
	private static final String SELECT_HOSPITAL_BY_NAME = "select id,name,address from tblHospital where name =?";
	private static final String SELECT_HOSPITAL_BY_ID = "select id, name, address from tblHospital where id =?";
	
	public HospitalDAO() {
	}
	
	public Hospital selectHospitalById(int id) {
		Hospital hospital = null;
	// Step 1: Establishing a Connection
	try (Connection connection = getConnection();
			// Step 2:Create a statement using connection object
		PreparedStatement preparedStatement = connection.prepareStatement(SELECT_HOSPITAL_BY_ID);) {
		preparedStatement.setInt(1, id);
		System.out.println(preparedStatement);
		// Step 3: Execute the query or update query
		ResultSet rs = preparedStatement.executeQuery();

		// Step 4: Process the ResultSet object.
		while (rs.next()) {
			String name = rs.getString("name");
			String address = rs.getString("address");
			hospital = new Hospital(id, name, address);
			System.out.println(hospital.toString());
		}
	} catch (SQLException e) {
		printSQLException(e);
	}
	return hospital;
}
	
	public Hospital selectHospitalbyName(String name) {
		Hospital hospital = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_HOSPITAL_BY_NAME);) {
			preparedStatement.setString(1, name);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String address = rs.getString("address");
				hospital = new Hospital(id, name, address);
				System.out.println("DAO hospital:"+hospital.getAddress());
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return hospital;
	}
	
	public List<Hospital> selectAllHospital() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Hospital> hospital = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_HOSPITAL);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String address = rs.getString("address");
				hospital.add(new Hospital(id, name, address));
			}} catch (SQLException e) {
			printSQLException(e);
		}
		return hospital;
	}
	

}
