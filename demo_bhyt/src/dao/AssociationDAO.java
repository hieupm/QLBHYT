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

}
