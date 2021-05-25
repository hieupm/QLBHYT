package control;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import dao.AssociationDAO;
import dao.BhytDAO;
import dao.BillDAO;
import dao.CustomerDAO;
import dao.HospitalDAO;
import model.Bill;
import model.Customer;
import model.Hospital;
import model.Association;
import model.BHYT;
/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 * @email Ramesh Fadatare
 */

@WebServlet("/")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected CustomerDAO customerDAO;
	private BillDAO billDAO;
	private AssociationDAO associationDAO;
	private HospitalDAO hospitalDAO;
	private List<BHYT> bhytList;
	public void init() {
		customerDAO = new CustomerDAO();
		billDAO = new BillDAO();
		associationDAO = new AssociationDAO();
		hospitalDAO = new HospitalDAO();
		bhytList = new ArrayList<BHYT>();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {

				case "/Customer-list":
					listCustomer(request, response);
				break;
				case "/Customer-new":
					showCustomerNewForm(request, response);
					break;
				case "/Customer-insert":
					insertCustomer(request, response);
					break;
				case "/Customer-delete":
					deleteCustomer(request, response);
					break;
				
				case "/Customer-edit":
					showCustomerEditForm(request, response);
					break;
				case "/Customer-update":
					updateCustomer(request, response);
					break;
					
				case "/Bill-list":
					listBill(request, response);
				break;
				case "/Bill-new":
					showBillNewForm(request, response);
					break;
				case "/Bill-insert":
					insertBill(request, response);
					break;
					
				case "/Bhyt-new":
					showBhytNewForm(request, response);
					break;
				case "/Bhyt-fill":
					fillBhyt(request, response);
					break;
				case "/Bhyt-delete":
					deleteBhytFromList(request, response);
					break;
			default:
				listCustomer(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	
	
	
	private void listCustomer(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Customer> listCustomer = customerDAO.selectAllCustomer();
		request.setAttribute("listCustomer", listCustomer);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Customer-list.jsp");
		dispatcher.forward(request, response);
	}
	
	
	
	private void listBill(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Bill> listBill = billDAO.selectAllBill();
		request.setAttribute("listBill", listBill);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Bill-list.jsp");
		dispatcher.forward(request, response);
	}
	private void showBillNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("Bill-form.jsp");
		List<Customer> listCustomer = customerDAO.selectAllCustomer();
		request.setAttribute("listCustomer", listCustomer);
		List<Association> listAssociation = associationDAO.selectAllAssociation();
		request.setAttribute("listAssociation", listAssociation);
		request.setAttribute("bhytList",bhytList);
		dispatcher.forward(request, response);
		
	}
	
	
	private void showBhytNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("Bhyt-form.jsp");
		List<Customer> listCustomer = customerDAO.selectAllCustomer();
		request.setAttribute("listCustomer", listCustomer);
		List<Hospital> listHospital = hospitalDAO.selectAllHospital();
		request.setAttribute("listHospital", listHospital);
		dispatcher.forward(request, response);
	}
	
	private void showCustomerNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("Customer-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showCustomerEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Customer existingCustomer = customerDAO.selectCustomer(id);
		System.out.println(existingCustomer.toString());
		RequestDispatcher dispatcher = request.getRequestDispatcher("Customer-form.jsp");
		request.setAttribute("customer", existingCustomer);
		dispatcher.forward(request, response);
	}

	private void insertCustomer(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException {
		
		String name = request.getParameter("name");
		byte[] byte1 = name.getBytes(StandardCharsets.ISO_8859_1);
		name = new String(byte1, StandardCharsets.UTF_8);
		String idCardNum = request.getParameter("idCardNum");
		Date dob = Date.valueOf(request.getParameter("dob"));
		String address = request.getParameter("address");
		byte[] byte2 = address.getBytes(StandardCharsets.ISO_8859_1);
		address = new String(byte2, StandardCharsets.UTF_8);
		String telephone = request.getParameter("telephone");	
		Customer newCustomer = new Customer(name, idCardNum, dob, address, telephone);
		boolean bl = customerDAO.insertCustomer(newCustomer);
		if(bl) {
			response.sendRedirect("Customer-list?message=1");

		} else {
			response.sendRedirect("Customer-list?message=2");
		}

	}
	
	private void insertBill(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException{
		System.out.println("abc");
		String type = request.getParameter("type");
		byte[] byte1 = type.getBytes(StandardCharsets.ISO_8859_1);
		type = new String(byte1, StandardCharsets.UTF_8);
		Date paidDate = Date.valueOf(request.getParameter("paidDate"));
		String idCardNum = String.valueOf(request.getParameter("idCardNum"));
		System.out.println("idcard:"+idCardNum);
		CustomerDAO dao = new CustomerDAO();
		Customer customer = dao.selectCustomerbyidcard(idCardNum);
		System.out.println("cusname: "+customer.getName());
		int tblAssociationid=Integer.parseInt(request.getParameter("tblAssociationid"));
		
		if(tblAssociationid == 0) {
		Bill newBill = new Bill(type, paidDate, customer.getId());
		Boolean bl2 = billDAO.insertBill2(newBill);
			if(bl2) response.sendRedirect("Bill-list?bill=1");
			else response.sendRedirect("Bill-list?bill=0");
		}
		else {
			Bill newBill = new Bill(type, paidDate, customer.getId(), tblAssociationid);
			Boolean bl1 = billDAO.insertBill(newBill);
			if(bl1) response.sendRedirect("Bill-list?bill=1");
			else response.sendRedirect("Bill-list?bill=0");
		}
		BillDAO billDao = new BillDAO();
		int id = billDao.incrementId();
		BhytDAO bhytDao = new BhytDAO();
		for (BHYT b : bhytList) {
			b.setTblBillid(id);
			bhytDao.insertBhyt(b);
		}
		bhytList.removeAll(bhytList);
	//	response.sendRedirect("Bill-list");
		
	}
	
	private void fillBhyt(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		Date startDate = Date.valueOf(request.getParameter("startDate"));
		System.out.println("startDate:" + startDate);
		Date endDate = Date.valueOf(request.getParameter("endDate"));
		System.out.println("endDate" + endDate);
		float supportLevel = Float.parseFloat(request.getParameter("supportLevel"));
		System.out.println("supportLevel: "+supportLevel);
		int salary = Integer.parseInt(request.getParameter("salary"));
		System.out.println("salary: "+salary);
		String idCardNum = String.valueOf(request.getParameter("idCardNum"));
		System.out.println("idcard: "+idCardNum);
		CustomerDAO cusDao = new CustomerDAO();
		Customer customer = cusDao.selectCustomerbyidcard(idCardNum);
		System.out.println("cus name: "+customer.getName());
		
		String name = String.valueOf(request.getParameter("name"));
		byte[] byte1 = name.getBytes(StandardCharsets.ISO_8859_1);
		name = new String(byte1, StandardCharsets.UTF_8);
		System.out.println("Hospital name: "+name);
		HospitalDAO hosDao = new HospitalDAO();
		Hospital hospital = hosDao.selectHospitalbyName(name);
		System.out.println("ID hospital: "+hospital.getId());
		BHYT newBhyt = new BHYT(startDate, endDate, supportLevel, salary, customer, hospital);
		Boolean bl = bhytList.add(newBhyt);
		if(bl) {
			response.sendRedirect("Bill-new?bhyt=1");

		} else {
			response.sendRedirect("Bill-new?bhyt=0");
		}
	//	response.sendRedirect("Bill-new");
	}
	
	private void updateCustomer(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		byte[] byte1 = name.getBytes(StandardCharsets.ISO_8859_1);
		name = new String(byte1, StandardCharsets.UTF_8);
		String idCardNum = request.getParameter("idCardNum");
		Date dob = Date.valueOf(request.getParameter("dob"));
		String address = request.getParameter("address");
		byte[] byte2 = address.getBytes(StandardCharsets.ISO_8859_1);
		address = new String(byte2, StandardCharsets.UTF_8);
		String telephone = request.getParameter("telephone");

		Customer book = new Customer(id, name, idCardNum, dob, address, telephone);
		Boolean bl = customerDAO.updateCustomer(book);
		if(bl) {
			response.sendRedirect("Customer-list?update=1");

		} else {
			response.sendRedirect("Customer-list?update=0");
		}
	}

	private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Boolean bl = customerDAO.deleteCustomer(id);
		if(bl) {
			response.sendRedirect("Customer-list?delete=1");

		} else {
			response.sendRedirect("Customer-list?delete=0");
		}
		
		
	}

	private void deleteBhytFromList(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		bhytList.remove(id);
		if(id == 0 ) {
			response.sendRedirect("Bill-new?deletebh=1");
		}	else {
			response.sendRedirect("Bill-new?deletebh=0");
		}

	}
	
}
