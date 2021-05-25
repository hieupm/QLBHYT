package junittest;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import dao.HospitalDAO;
import model.Hospital;


public class TestHospitalDAO {
	private HospitalDAO hospitalDAO;
	@Test
	public void testListBill() {
		hospitalDAO = new HospitalDAO();
		List<Hospital> bills = hospitalDAO.selectAllHospital();
		Assertions.assertFalse(bills.isEmpty());

	}
}
