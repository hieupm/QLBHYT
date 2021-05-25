package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Association;


public class AssociationDAO extends CustomerDAO{

	private static final String SELECT_ALL_ASSOCIATION = "select * from tblAssociation";
	
	private static final String SELECT_ASSOCIATION_BY_ID = "select id, name, address, telephone where id =?";

	public AssociationDAO() {
	}
	
	public List<Association> selectAllAssociation() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Association> association = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ASSOCIATION);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String address = rs.getString("address");
				String telephone = rs.getString("telephone");
				association.add(new Association(id, name, address, telephone));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return association;
	}
	
	public Association selectAssociationById(int id) {
		Association association = null;
	// Step 1: Establishing a Connection
	try (Connection connection = getConnection();
			// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ASSOCIATION_BY_ID);) {
		preparedStatement.setInt(1, id);
		System.out.println(preparedStatement);
		// Step 3: Execute the query or update query
		ResultSet rs = preparedStatement.executeQuery();

		// Step 4: Process the ResultSet object.
		while (rs.next()) {
			String name = rs.getString("name");
			String address = rs.getString("address");
			String telephone = rs.getString("telephone");

			
			association = new Association(id, name, address, telephone);
			System.out.println(association.toString());
		}
	} catch (SQLException e) {
		printSQLException(e);
	}
	return association;
}

}
