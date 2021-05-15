package Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;
import java.util.List;

import org.hibernate.*;
import org.hibernate.Query;
import org.hibernate.query.*;
import org.junit.jupiter.api.*;

import hibernate.HibernateUtil;
import model.Customer;

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
        if (sessionFactory != null) sessionFactory.close();
        System.out.println("SessionFactory destroyed");
    }
     
    @Test
    public void testCreateCustomer() {
    	System.out.println("Running testCreate...");
        
        session.beginTransaction();
        Date dob = new Date( 1999, 10,  10);
        System.out.println("Ngày sinh: "+dob);
        Customer cus = new Customer("Phạm Minh Hiếu", "", dob , "Hà Đông", "09473472429");
        Integer id = (Integer) session.save(cus);
         
        session.getTransaction().commit();
         
        Assertions.assertTrue(id > 0);
    }
    
    @Test
    public void testCreateBHYT() {
    	System.out.println("Running testCreate...");
        
        session.beginTransaction();
        Date dob = new Date( 1999, 10,  10);
        System.out.println("Ngày sinh: "+dob);
        Customer cus = new Customer("Phạm Minh Hiếu", "", dob , "Hà Đông", "09473472429");
        Integer id = (Integer) session.save(cus);
         
        session.getTransaction().commit();
         
        Assertions.assertTrue(id > 0);
    }
     
    @Test
    public void testUpdateCustomer() {
    	System.out.println("Running testUpdate...");
    	
    	Date dob = new Date( 1999, 10,  10);

        Integer id = 18;
        Customer cus = new Customer(id,"Phạm Minh Hải", "32434231", dob , "Hà Đông", "09473472429");
         
        session.beginTransaction();
        session.update(cus);
        session.getTransaction().commit();
         
        Customer updatedCustomer = session.find(Customer.class, id);
         
        assertEquals("Phạm Minh Hải", updatedCustomer.getName());
    }
     
    @Test
    public void testGet() {
    	System.out.println("Running testGet...");
        
        Integer id = 18;
         
        Customer cus = session.find(Customer.class, id);
         
        assertEquals("Phạm Minh Hiếu", cus.getName());   
    }
     
    @Test
    public void testListCustomer() {
    	System.out.println("Running testList...");
        
        Query<Customer> query = session.createQuery("from Customer", Customer.class);
        List<Customer> resultList = query.getResultList();
         
        Assertions.assertFalse(resultList.isEmpty());
    }
     
    @Test
    public void testDelete() {
    	System.out.println("Running testDelete...");
        
        Integer id = 18;
        Customer cus = session.find(Customer.class, id);
         
        session.beginTransaction();
        session.delete(cus);
        session.getTransaction().commit();
         
        Customer deletedCustomer = session.find(Customer.class, id);
         
        Assertions.assertNull(deletedCustomer);
    }  
     
    @BeforeEach
    public void openSession() {
        session = sessionFactory.openSession();
        System.out.println("Session created");
    }
     
    @AfterEach
    public void closeSession() {
        if (session != null) session.close();
        System.out.println("Session closed\n");
    }  
    
}
