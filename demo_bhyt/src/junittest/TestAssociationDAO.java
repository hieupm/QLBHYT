package junittest;


import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import dao.AssociationDAO;
import model.Association;


public class TestAssociationDAO {
	private AssociationDAO associationDAO;
	@Test
	public void testListBill() {
		associationDAO = new AssociationDAO();
		List<Association> associations = associationDAO.selectAllAssociation();
		Assertions.assertFalse(associations.isEmpty());

	}
}
