package Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.*;
import org.hibernate.Query;
import org.hibernate.query.*;
import org.junit.jupiter.api.*;

import control.Payment;
import hibernate.HibernateUtil;
import model.Association;
import model.BHYT;
import model.Bill;
import model.BHYT2;
import model.Bill2;
import model.Customer;
import model.Hospital;
import control.Payment;



public class HibernateUtilTest {
	private static SessionFactory sessionFactory;
	private Session session;

	@BeforeAll
	public static void setup() {
		sessionFactory = HibernateUtil.getSessionFactory();
		System.out.println("SessionFactory created");
	}

	@AfterAll
	public static void tearDown() {
		if (sessionFactory != null)
			sessionFactory.close();
		System.out.println("SessionFactory destroyed");
	}
	
	private static java.sql.Date convertUtilToSql(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }
	
	@Test
	public void testCreateCustomer() throws ParseException {
		try {
			System.out.println("Running testCreate...");
			
			session.beginTransaction();

			java.sql.Date dob = java.sql.Date.valueOf("1999-12-31");
			
			Customer cus = new Customer("Phạm Minh Hiếu", "01232989", dob , "Hà Nội", "0904579384");
			Integer id = (Integer) session.save(cus);

			session.getTransaction().commit();
			Assertions.assertTrue(id > 0);

		} catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
        }
		finally{
			session.getTransaction().rollback();
			session.close();
		}

	}
	
	@Test
	public void testCreateBill() {
		try {
			System.out.println("Running testCreateBill...");

			session.beginTransaction();
			java.sql.Date dob = java.sql.Date.valueOf("1999-12-31");
			java.sql.Date paidDate = java.sql.Date.valueOf("2026-05-05");
			Association association = new Association("TechLead", "Thái Hà", "09430593534");
			Customer cus = new Customer("Phạm Minh Hiếu", "013859375", dob , "Hà Nội", "0904579384");

	        Bill2 bill = new Bill2("Nhóm do cơ quan bảo hiểm xã hội đóng",paidDate,cus,association);
	        
	        Integer customerId = (Integer) session.save(cus);
	        Integer associationId = (Integer) session.save(association);
			Integer billId = (Integer) session.save(bill);
//			session.getTransaction().commit();
			Assertions.assertTrue(billId == null);

		} catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
        }
		finally{
			session.getTransaction().rollback();
			session.close();
		}

	}
	
	@Test
    public void testCreateBHYT() {
		try {
			System.out.println("Running testCreate...");
	        
	        session.beginTransaction();
	        java.sql.Date dob = java.sql.Date.valueOf("1999-12-31");
	        java.sql.Date startDate = java.sql.Date.valueOf("2020-10-10");
	        java.sql.Date endDate = java.sql.Date.valueOf("2019-10-10");
	        java.sql.Date paidDate = java.sql.Date.valueOf("2020-12-12");
	        float supportLevel = (float) 1.4;
	        Association association = new Association("TechLead", "Thái Hà", "09430593534");
	        Customer cus = new Customer("Phạm Minh Hải", "013859375", dob , "Hà Nội", "0904579384");
	        Hospital hos = new Hospital("BV Bạch Mai", "HN");
	        Bill2 bill = new Bill2("Nhóm do cơ quan bảo hiểm xã hội đóng",paidDate,cus,association); 
	        BHYT2 bh = new BHYT2(startDate, endDate, supportLevel, 7500000, cus, hos, bill);
	        
	        Integer associationId = (Integer) session.save(association);
	        Integer hospitalId = (Integer) session.save(hos);
	        Integer billId = (Integer) session.save(bill);
	        Integer customerId = (Integer) session.save(cus);
	        Integer bhytId = (Integer) session.save(bh);         
   //         session.getTransaction().commit();
	        Assertions.assertTrue(bhytId == null);
		}catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
        }finally{
			session.getTransaction().rollback();
			session.close();
		}
    	
    }
	
	@Test
	public void testPayment() {
		Payment bhyt = new Payment();
		System.out.println("Running testPayment...");
		
		String type = "Nhóm do người sử dụng lao động đóng";
		float supportLevel = (float) 0.3;
		int salary = 7500000;
		double payment = bhyt.pay(type, supportLevel, salary);
				
		Assertions.assertEquals(2835000, payment);
	}

	@Test
    public void testUpdateCustomer() {
		try {
			System.out.println("Running testUpdate...");
	    	
			java.sql.Date dob = java.sql.Date.valueOf("1999-12-31");

	        Integer id = 12;
	        Customer cus = new Customer(id,"Phạm Minh Hải", "0137849274", dob , "Hà Đông", "09473472429");
	         
	        session.beginTransaction();
	        session.update(cus);
	        session.getTransaction().commit();
	         
	        Customer updatedCustomer = session.find(Customer.class, id);
	         
	        assertEquals("Phạm Minh Hải", updatedCustomer.getName());
    	}catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
        }
		finally{
			session.getTransaction().rollback();
			session.close();
		}
    	
    }

	@Test
	public void testGet() {
			try {
				System.out.println("Running testGet...");

				Integer id = 12;

				Customer cus = session.find(Customer.class, id);

				assertEquals("0137849274", cus.getIdCardNum());

			}catch (Exception e) {
	            e.printStackTrace();
	            session.getTransaction().rollback();
	            session.close();
	        }
			finally{
				session.getTransaction().rollback();
				session.close();
			}

	}

	@Test
	public void testListCustomer() {
		try {
			System.out.println("Running testList...");

			Query<Customer> query = session.createQuery("from Customer", Customer.class);
			List<Customer> resultList = query.getResultList();

			Assertions.assertFalse(resultList.isEmpty());
		}catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
        }
		finally{
			session.getTransaction().rollback();
			session.close();
		}
		
	}

	@Test
	public void testDelete() {
		try {
			System.out.println("Running testDelete...");

			Integer id = 14;
			Customer cus = session.find(Customer.class, id);

			session.beginTransaction();
			session.delete(cus);
	//		session.getTransaction().commit();

			Customer deletedCustomer = session.find(Customer.class, id);

			Assertions.assertNull(deletedCustomer);
		}catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            session.close();
        }
		finally{
			session.getTransaction().rollback();
			session.close();
		}
		
	}

	@BeforeEach
	public void openSession() {
		session = sessionFactory.openSession();
		System.out.println("Session created");
	}

	@AfterEach
	public void closeSession() {
		if (session != null)
			session.close();
		System.out.println("Session closed\n");
	}

}
