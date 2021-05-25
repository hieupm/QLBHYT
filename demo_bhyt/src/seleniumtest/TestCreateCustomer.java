package seleniumtest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.gson.Gson;
import com.mysql.jdbc.PreparedStatement;

import dao.CustomerDAO;
import model.Customer;


public class TestCreateCustomer {
	protected CustomerDAO customerDAO;
	protected String jdbcURL = "jdbc:mysql://localhost:3306/demo_bhyt?serverTimezone=Asia/Bangkok";
	protected String jdbcUsername = "root";
	protected String jdbcPassword = "1234";

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	@Test
	public void createCustomer1() {
		WebDriver webDriver;
			System.setProperty("webdriver.chrome.driver", "C:/Eden/SQA/chromedriver/chromedriver.exe");
			webDriver = new ChromeDriver();
			try {
				webDriver.get("http://localhost:8080/demo_bhyt/Customer-new");
				Thread.sleep(1000);
				
				WebElement name = webDriver.findElement(By.id("name"));
				name.sendKeys("Trần Đình Nam");
				Thread.sleep(1000);
				
				WebElement idCardNum = webDriver.findElement(By.id("idCardNum"));
				idCardNum.sendKeys("01385903248");
				Thread.sleep(1000);
				
				WebElement dob = webDriver.findElement(By.id("dob"));
				dob.sendKeys("06/06/1999");
				Thread.sleep(1000);
				
				WebElement address = webDriver.findElement(By.id("address"));
				address.sendKeys("Hà Nội");
				Thread.sleep(1000);
				
				WebElement telephone = webDriver.findElement(By.id("telephone"));
				telephone.sendKeys("0904579895");
				Thread.sleep(1000);
				
				WebElement save = webDriver.findElement(By.id("saveCus"));
				save.click();

				WebDriverWait wait = new WebDriverWait(webDriver, 3);
				WebElement messageElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("message")));
				Thread.sleep(1000);
				String success = messageElement.getText();
				String expected = "Thêm khách hàng mới thành công!";
				assertEquals(expected, success);
				
				//rollback
				customerDAO = new CustomerDAO();
				Customer existedCustomer = customerDAO.selectCustomerbyidcard("01385903248");
				Connection connection = getConnection();
				String sql = "delete from tblCustomer where id = ?";
				PreparedStatement p = (PreparedStatement) connection.prepareStatement(sql);
				p.setInt(1, existedCustomer.getId());
				p.executeUpdate();
				webDriver.close();
				
				
			} catch (Exception e) {
				System.out.println("Test failed!" + e.getMessage());
				webDriver.close();
			} 
		}
	
	@Test
	public void createCustomer2() {
		WebDriver webDriver;
			System.setProperty("webdriver.chrome.driver", "C:/Eden/SQA/chromedriver/chromedriver.exe");
			webDriver = new ChromeDriver();
			try {
				webDriver.get("http://localhost:8080/demo_bhyt/Customer-new");
				Thread.sleep(1000);
				
				WebElement name = webDriver.findElement(By.id("name"));
				name.sendKeys("");
				Thread.sleep(1000);
				
				WebElement idCardNum = webDriver.findElement(By.id("idCardNum"));
				idCardNum.sendKeys("01385903248");
				Thread.sleep(1000);
				
				WebElement dob = webDriver.findElement(By.id("dob"));
				dob.sendKeys("06/06/1999");
				Thread.sleep(1000);
				
				WebElement address = webDriver.findElement(By.id("address"));
				address.sendKeys("Hà Nội");
				Thread.sleep(1000);
				
				WebElement telephone = webDriver.findElement(By.id("telephone"));
				telephone.sendKeys("0904579895");
				Thread.sleep(1000);
				
				WebElement save = webDriver.findElement(By.id("saveCus"));
				save.click();

				JavascriptExecutor js = (JavascriptExecutor) webDriver; 
				boolean isRequired = (Boolean) js.executeScript("return arguments[0].required;",name);
				

				assertTrue(isRequired==true);
				Thread.sleep(1000);
				webDriver.close();
				
				
			} catch (Exception e) {
				System.out.println("Test failed!" + e.getMessage());
				webDriver.close();
			} 
		}
	
	@Test
	public void createCustomer3() {
		WebDriver webDriver;
			System.setProperty("webdriver.chrome.driver", "C:/Eden/SQA/chromedriver/chromedriver.exe");
			webDriver = new ChromeDriver();
			try {
				webDriver.get("http://localhost:8080/demo_bhyt/Customer-new");
				Thread.sleep(1000);
				
				WebElement name = webDriver.findElement(By.id("name"));
				name.sendKeys("Phạm Minh Hải");
				Thread.sleep(1000);
				
				WebElement idCardNum = webDriver.findElement(By.id("idCardNum"));
				idCardNum.sendKeys("");
				Thread.sleep(1000);
				
				WebElement dob = webDriver.findElement(By.id("dob"));
				dob.sendKeys("06/06/1999");
				Thread.sleep(1000);
				
				WebElement address = webDriver.findElement(By.id("address"));
				address.sendKeys("Hà Nội");
				Thread.sleep(1000);
				
				WebElement telephone = webDriver.findElement(By.id("telephone"));
				telephone.sendKeys("0904579895");
				Thread.sleep(1000);
				
				WebElement save = webDriver.findElement(By.id("saveCus"));
				save.click();

				JavascriptExecutor js = (JavascriptExecutor) webDriver; 
				boolean isRequired = (Boolean) js.executeScript("return arguments[0].required;",idCardNum);
				

				assertTrue(isRequired==true);
				Thread.sleep(1000);
				webDriver.close();
				
				
			} catch (Exception e) {
				System.out.println("Test failed!" + e.getMessage());
				webDriver.close();
			} 
		}
	
	@Test
	public void createCustomer4() {
		WebDriver webDriver;
			System.setProperty("webdriver.chrome.driver", "C:/Eden/SQA/chromedriver/chromedriver.exe");
			webDriver = new ChromeDriver();
			try {
				webDriver.get("http://localhost:8080/demo_bhyt/Customer-new");
				Thread.sleep(1000);
				
				WebElement name = webDriver.findElement(By.id("name"));
				name.sendKeys("Phạm Minh Hải");
				Thread.sleep(1000);
				
				WebElement idCardNum = webDriver.findElement(By.id("idCardNum"));
				idCardNum.sendKeys("232132311");
				Thread.sleep(1000);
				
				WebElement dob = webDriver.findElement(By.id("dob"));
				dob.sendKeys("");
				Thread.sleep(1000);
				
				WebElement address = webDriver.findElement(By.id("address"));
				address.sendKeys("Hà Nội");
				Thread.sleep(1000);
				
				WebElement telephone = webDriver.findElement(By.id("telephone"));
				telephone.sendKeys("0904579895");
				Thread.sleep(1000);
				
				WebElement save = webDriver.findElement(By.id("saveCus"));
				save.click();

				JavascriptExecutor js = (JavascriptExecutor) webDriver; 
				boolean isRequired = (Boolean) js.executeScript("return arguments[0].required;",dob);
				

				assertTrue(isRequired==true);
				Thread.sleep(1000);
				webDriver.close();
				
				
			} catch (Exception e) {
				System.out.println("Test failed!" + e.getMessage());
				webDriver.close();
			} 
		}
	
	@Test
	public void createCustomer5() {
		WebDriver webDriver;
			System.setProperty("webdriver.chrome.driver", "C:/Eden/SQA/chromedriver/chromedriver.exe");
			webDriver = new ChromeDriver();
			try {
				webDriver.get("http://localhost:8080/demo_bhyt/Customer-new");
				Thread.sleep(1000);
				
				WebElement name = webDriver.findElement(By.id("name"));
				name.sendKeys("Phạm Minh Hải");
				Thread.sleep(1000);
				
				WebElement idCardNum = webDriver.findElement(By.id("idCardNum"));
				idCardNum.sendKeys("232132311");
				Thread.sleep(1000);
				
				WebElement dob = webDriver.findElement(By.id("dob"));
				dob.sendKeys("06/06/1999");
				Thread.sleep(1000);
				
				WebElement address = webDriver.findElement(By.id("address"));
				address.sendKeys("");
				Thread.sleep(1000);
				
				WebElement telephone = webDriver.findElement(By.id("telephone"));
				telephone.sendKeys("0904579895");
				Thread.sleep(1000);
				
				WebElement save = webDriver.findElement(By.id("saveCus"));
				save.click();

				JavascriptExecutor js = (JavascriptExecutor) webDriver; 
				boolean isRequired = (Boolean) js.executeScript("return arguments[0].required;",address);
				

				assertTrue(isRequired==true);
				Thread.sleep(1000);
				webDriver.close();
				
				
			} catch (Exception e) {
				System.out.println("Test failed!" + e.getMessage());
				webDriver.close();
			} 
		}
	
	@Test
	public void createCustomer6() {
		WebDriver webDriver;
			System.setProperty("webdriver.chrome.driver", "C:/Eden/SQA/chromedriver/chromedriver.exe");
			webDriver = new ChromeDriver();
			try {
				webDriver.get("http://localhost:8080/demo_bhyt/Customer-new");
				Thread.sleep(1000);
				
				WebElement name = webDriver.findElement(By.id("name"));
				name.sendKeys("Phạm Minh Hải");
				Thread.sleep(1000);
				
				WebElement idCardNum = webDriver.findElement(By.id("idCardNum"));
				idCardNum.sendKeys("232132311");
				Thread.sleep(1000);
				
				WebElement dob = webDriver.findElement(By.id("dob"));
				dob.sendKeys("06/06/1999");
				Thread.sleep(1000);
				
				WebElement address = webDriver.findElement(By.id("address"));
				address.sendKeys("Hà Nội");
				Thread.sleep(1000);
				
				WebElement telephone = webDriver.findElement(By.id("telephone"));
				telephone.sendKeys("");
				Thread.sleep(1000);
				
				WebElement save = webDriver.findElement(By.id("saveCus"));
				save.click();

				JavascriptExecutor js = (JavascriptExecutor) webDriver; 
				boolean isRequired = (Boolean) js.executeScript("return arguments[0].required;",telephone);
				

				assertTrue(isRequired==true);
				Thread.sleep(1000);
				webDriver.close();
				
				
			} catch (Exception e) {
				System.out.println("Test failed!" + e.getMessage());
				webDriver.close();
			} 
		}

	
	@Test
	public void createCustomer7() {
		WebDriver webDriver;
			System.setProperty("webdriver.chrome.driver", "C:/Eden/SQA/chromedriver/chromedriver.exe");
			webDriver = new ChromeDriver();
			try {
				webDriver.get("http://localhost:8080/demo_bhyt/Customer-new");
				Thread.sleep(1000);
				
				WebElement name = webDriver.findElement(By.id("name"));
				name.sendKeys("Ph!m M!nh Hải3");
				Thread.sleep(1000);
				
				WebElement idCardNum = webDriver.findElement(By.id("idCardNum"));
				idCardNum.sendKeys("03875428323");
				Thread.sleep(1000);
				
				WebElement dob = webDriver.findElement(By.id("dob"));
				dob.sendKeys("06/06/1999");
				Thread.sleep(1000);
				
				WebElement address = webDriver.findElement(By.id("address"));
				address.sendKeys("Hà Nội");
				Thread.sleep(1000);
				
				WebElement telephone = webDriver.findElement(By.id("telephone"));
				telephone.sendKeys("09084932482");
				Thread.sleep(1000);
				
				WebElement save = webDriver.findElement(By.id("saveCus"));
				save.click();

				WebDriverWait wait = new WebDriverWait(webDriver, 2);
				WebElement messageElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("message")));
				Thread.sleep(1000);
				String failure = messageElement.getText();
				String expected = "Thêm khách hàng mới thất bại!";
				assertEquals(expected, failure);
				
				//rollback
				customerDAO = new CustomerDAO();
				Customer existedCustomer = customerDAO.selectCustomerbyidcard("03875428323");
				Connection connection = getConnection();
				String sql = "delete from tblCustomer where id = ?";
				PreparedStatement p = (PreparedStatement) connection.prepareStatement(sql);
				p.setInt(1, existedCustomer.getId());
				p.executeUpdate();
				webDriver.close();
				
			} catch (Exception e) {
				System.out.println("Test failed!" + e.getMessage());
				webDriver.close();
			} 
		}
	
	@Test
	public void createCustomer8() {
		WebDriver webDriver;
			System.setProperty("webdriver.chrome.driver", "C:/Eden/SQA/chromedriver/chromedriver.exe");
			webDriver = new ChromeDriver();
			try {
				webDriver.get("http://localhost:8080/demo_bhyt/Customer-new");
				Thread.sleep(1000);
				
				WebElement name = webDriver.findElement(By.id("name"));
				name.sendKeys("Phim Minh Hải");
				Thread.sleep(1000);
				
				WebElement idCardNum = webDriver.findElement(By.id("idCardNum"));
				idCardNum.sendKeys("@*hd28323");
				Thread.sleep(1000);
				
				WebElement dob = webDriver.findElement(By.id("dob"));
				dob.sendKeys("06/06/1999");
				Thread.sleep(1000);
				
				WebElement address = webDriver.findElement(By.id("address"));
				address.sendKeys("Hà Nội");
				Thread.sleep(1000);
				
				WebElement telephone = webDriver.findElement(By.id("telephone"));
				telephone.sendKeys("09084932482");
				Thread.sleep(1000);
				
				WebElement save = webDriver.findElement(By.id("saveCus"));
				save.click();

				WebDriverWait wait = new WebDriverWait(webDriver, 2);
				WebElement messageElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("message")));
				Thread.sleep(1000);
				String failure = messageElement.getText();
				String expected = "Thêm khách hàng mới thất bại!";
				assertEquals(expected, failure);
				
				//rollback
				customerDAO = new CustomerDAO();
				Customer existedCustomer = customerDAO.selectCustomerbyidcard("@*hd28323");
				Connection connection = getConnection();
				String sql = "delete from tblCustomer where id = ?";
				PreparedStatement p = (PreparedStatement) connection.prepareStatement(sql);
				p.setInt(1, existedCustomer.getId());
				p.executeUpdate();
				webDriver.close();
				
			} catch (Exception e) {
				System.out.println("Test failed!" + e.getMessage());
				webDriver.close();
			} 
		}
	
	@Test
	public void createCustomer9() {
		WebDriver webDriver;
			System.setProperty("webdriver.chrome.driver", "C:/Eden/SQA/chromedriver/chromedriver.exe");
			webDriver = new ChromeDriver();
			try {
				webDriver.get("http://localhost:8080/demo_bhyt/Customer-new");
				Thread.sleep(1000);
				
				WebElement name = webDriver.findElement(By.id("name"));
				name.sendKeys("Phim Minh Hải");
				Thread.sleep(1000);
				
				WebElement idCardNum = webDriver.findElement(By.id("idCardNum"));
				idCardNum.sendKeys("123");
				Thread.sleep(1000);
				
				WebElement dob = webDriver.findElement(By.id("dob"));
				dob.sendKeys("06/06/1999");
				Thread.sleep(1000);
				
				WebElement address = webDriver.findElement(By.id("address"));
				address.sendKeys("Hà Nội");
				Thread.sleep(1000);
				
				WebElement telephone = webDriver.findElement(By.id("telephone"));
				telephone.sendKeys("09084932482");
				Thread.sleep(1000);
				
				WebElement save = webDriver.findElement(By.id("saveCus"));
				save.click();

				WebDriverWait wait = new WebDriverWait(webDriver, 2);
				WebElement messageElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("message")));
				Thread.sleep(1000);
				String failure = messageElement.getText();
				String expected = "Thêm khách hàng mới thất bại!";
				assertEquals(expected, failure);
				
				//rollback
				customerDAO = new CustomerDAO();
				Customer existedCustomer = customerDAO.selectCustomerbyidcard("123");
				Connection connection = getConnection();
				String sql = "delete from tblCustomer where id = ?";
				PreparedStatement p = (PreparedStatement) connection.prepareStatement(sql);
				p.setInt(1, existedCustomer.getId());
				p.executeUpdate();
				webDriver.close();
				
			} catch (Exception e) {
				System.out.println("Test failed!" + e.getMessage());
				webDriver.close();
			} 
		}
	
	@Test
	public void createCustomer10() {
		WebDriver webDriver;
			System.setProperty("webdriver.chrome.driver", "C:/Eden/SQA/chromedriver/chromedriver.exe");
			webDriver = new ChromeDriver();
			try {
				webDriver.get("http://localhost:8080/demo_bhyt/Customer-new");
				Thread.sleep(1000);
				
				WebElement name = webDriver.findElement(By.id("name"));
				name.sendKeys("Phim Minh Hải");
				Thread.sleep(1000);
				
				WebElement idCardNum = webDriver.findElement(By.id("idCardNum"));
				idCardNum.sendKeys("18594839523");
				Thread.sleep(1000);
				
				WebElement dob = webDriver.findElement(By.id("dob"));
				dob.sendKeys("06/06/1999");
				Thread.sleep(1000);
				
				WebElement address = webDriver.findElement(By.id("address"));
				address.sendKeys("Hà Nội");
				Thread.sleep(1000);
				
				WebElement telephone = webDriver.findElement(By.id("telephone"));
				telephone.sendKeys("09084932482");
				Thread.sleep(1000);
				
				WebElement save = webDriver.findElement(By.id("saveCus"));
				save.click();

				WebDriverWait wait = new WebDriverWait(webDriver, 2);
				WebElement messageElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("message")));
				Thread.sleep(1000);
				String failure = messageElement.getText();
				String expected = "Thêm khách hàng mới thất bại!";
				assertEquals(expected, failure);
				
				//rollback
				customerDAO = new CustomerDAO();
				Customer existedCustomer = customerDAO.selectCustomerbyidcard("18594839523");
				Connection connection = getConnection();
				String sql = "delete from tblCustomer where id = ?";
				PreparedStatement p = (PreparedStatement) connection.prepareStatement(sql);
				p.setInt(1, existedCustomer.getId());
				p.executeUpdate();
				webDriver.close();
				
			} catch (Exception e) {
				System.out.println("Test failed!" + e.getMessage());
				webDriver.close();
			} 
		}
	
	@Test
	public void createCustomer11() {
		WebDriver webDriver;
			System.setProperty("webdriver.chrome.driver", "C:/Eden/SQA/chromedriver/chromedriver.exe");
			webDriver = new ChromeDriver();
			try {
				webDriver.get("http://localhost:8080/demo_bhyt/Customer-new");
				Thread.sleep(1000);
				
				WebElement name = webDriver.findElement(By.id("name"));
				name.sendKeys("Phim Minh Hải");
				Thread.sleep(1000);
				
				WebElement idCardNum = webDriver.findElement(By.id("idCardNum"));
				idCardNum.sendKeys("012913248");
				Thread.sleep(1000);
				
				WebElement dob = webDriver.findElement(By.id("dob"));
				dob.sendKeys("06/06/1999");
				Thread.sleep(1000);
				
				WebElement address = webDriver.findElement(By.id("address"));
				address.sendKeys("Hà Nội");
				Thread.sleep(1000);
				
				WebElement telephone = webDriver.findElement(By.id("telephone"));
				telephone.sendKeys("09084932482");
				Thread.sleep(1000);
				
				WebElement save = webDriver.findElement(By.id("saveCus"));
				save.click();

				WebDriverWait wait = new WebDriverWait(webDriver, 2);
				WebElement messageElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("message")));
				Thread.sleep(1000);
				String failure = messageElement.getText();
				String expected = "Thêm khách hàng mới thất bại!";
				assertEquals(expected, failure);
				
				//rollback
				customerDAO = new CustomerDAO();
				Customer existedCustomer = customerDAO.selectCustomerbyidcard("2342423423");
				Connection connection = getConnection();
				String sql = "delete from tblCustomer where id = ?";
				PreparedStatement p = (PreparedStatement) connection.prepareStatement(sql);
				p.setInt(1, existedCustomer.getId());
				p.executeUpdate();
				webDriver.close();
				
			} catch (Exception e) {
				System.out.println("Test failed!" + e.getMessage());
				webDriver.close();
			} 
		}
	
	@Test
	public void createCustomer12() {
		WebDriver webDriver;
			System.setProperty("webdriver.chrome.driver", "C:/Eden/SQA/chromedriver/chromedriver.exe");
			webDriver = new ChromeDriver();
			try {
				webDriver.get("http://localhost:8080/demo_bhyt/Customer-new");
				Thread.sleep(1000);
				
				WebElement name = webDriver.findElement(By.id("name"));
				name.sendKeys("Phim Minh Hải");
				Thread.sleep(1000);
				
				WebElement idCardNum = webDriver.findElement(By.id("idCardNum"));
				idCardNum.sendKeys("858357435734287528");
				Thread.sleep(1000);
				
				WebElement dob = webDriver.findElement(By.id("dob"));
				dob.sendKeys("06/06/1999");
				Thread.sleep(1000);
				
				WebElement address = webDriver.findElement(By.id("address"));
				address.sendKeys("Hà Nội");
				Thread.sleep(1000);
				
				WebElement telephone = webDriver.findElement(By.id("telephone"));
				telephone.sendKeys("09084932482");
				Thread.sleep(1000);
				
				WebElement save = webDriver.findElement(By.id("saveCus"));
				save.click();

				WebDriverWait wait = new WebDriverWait(webDriver, 2);
				WebElement messageElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("message")));
				Thread.sleep(1000);
				String failure = messageElement.getText();
				String expected = "Thêm khách hàng mới thất bại!";
				assertEquals(expected, failure);
				
				//rollback
				customerDAO = new CustomerDAO();
				Customer existedCustomer = customerDAO.selectCustomerbyidcard("858357435734287528");
				Connection connection = getConnection();
				String sql = "delete from tblCustomer where id = ?";
				PreparedStatement p = (PreparedStatement) connection.prepareStatement(sql);
				p.setInt(1, existedCustomer.getId());
				p.executeUpdate();
				webDriver.close();
				
			} catch (Exception e) {
				System.out.println("Test failed!" + e.getMessage());
				webDriver.close();
			} 
		}
	
	@Test
	public void createCustomer13() {
		WebDriver webDriver;
			System.setProperty("webdriver.chrome.driver", "C:/Eden/SQA/chromedriver/chromedriver.exe");
			webDriver = new ChromeDriver();
			try {
				webDriver.get("http://localhost:8080/demo_bhyt/Customer-new");
				Thread.sleep(1000);
				
				WebElement name = webDriver.findElement(By.id("name"));
				name.sendKeys("Phim Minh Hải");
				Thread.sleep(1000);
				
				WebElement idCardNum = webDriver.findElement(By.id("idCardNum"));
				idCardNum.sendKeys("85837528");
				Thread.sleep(1000);
				
				WebElement dob = webDriver.findElement(By.id("dob"));
				dob.sendKeys("06/06/2022");
				Thread.sleep(1000);
				
				WebElement address = webDriver.findElement(By.id("address"));
				address.sendKeys("Hà Nội");
				Thread.sleep(1000);
				
				WebElement telephone = webDriver.findElement(By.id("telephone"));
				telephone.sendKeys("09084932482");
				Thread.sleep(1000);
				
				WebElement save = webDriver.findElement(By.id("saveCus"));
				save.click();

				WebDriverWait wait = new WebDriverWait(webDriver, 2);
				WebElement messageElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("message")));
				Thread.sleep(1000);
				String failure = messageElement.getText();
				String expected = "Thêm khách hàng mới thất bại!";
				assertEquals(expected, failure);
				
				//rollback
				customerDAO = new CustomerDAO();
				Customer existedCustomer = customerDAO.selectCustomerbyidcard("85837528");
				Connection connection = getConnection();
				String sql = "delete from tblCustomer where id = ?";
				PreparedStatement p = (PreparedStatement) connection.prepareStatement(sql);
				p.setInt(1, existedCustomer.getId());
				p.executeUpdate();
				webDriver.close();
				
			} catch (Exception e) {
				System.out.println("Test failed!" + e.getMessage());
				webDriver.close();
			} 
		}
	
	@Test
	public void createCustomer14() {
		WebDriver webDriver;
			System.setProperty("webdriver.chrome.driver", "C:/Eden/SQA/chromedriver/chromedriver.exe");
			webDriver = new ChromeDriver();
			try {
				webDriver.get("http://localhost:8080/demo_bhyt/Customer-new");
				Thread.sleep(1000);
				
				WebElement name = webDriver.findElement(By.id("name"));
				name.sendKeys("Phim Minh Hải");
				Thread.sleep(1000);
				
				WebElement idCardNum = webDriver.findElement(By.id("idCardNum"));
				idCardNum.sendKeys("012913248");
				Thread.sleep(1000);
				
				WebElement dob = webDriver.findElement(By.id("dob"));
				dob.sendKeys("06/06/1999");
				Thread.sleep(1000);
				
				WebElement address = webDriver.findElement(By.id("address"));
				address.sendKeys("Hà Nội");
				Thread.sleep(1000);
				
				WebElement telephone = webDriver.findElement(By.id("telephone"));
				telephone.sendKeys("ab@332482");
				Thread.sleep(1000);
				
				WebElement save = webDriver.findElement(By.id("saveCus"));
				save.click();

				WebDriverWait wait = new WebDriverWait(webDriver, 2);
				WebElement messageElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("message")));
				Thread.sleep(1000);
				String failure = messageElement.getText();
				String expected = "Thêm khách hàng mới thất bại!";
				assertEquals(expected, failure);
				
				//rollback
				customerDAO = new CustomerDAO();
				Customer existedCustomer = customerDAO.selectCustomerbyidcard("085835743528");
				Connection connection = getConnection();
				String sql = "delete from tblCustomer where id = ?";
				PreparedStatement p = (PreparedStatement) connection.prepareStatement(sql);
				p.setInt(1, existedCustomer.getId());
				p.executeUpdate();
				webDriver.close();
				
			} catch (Exception e) {
				System.out.println("Test failed!" + e.getMessage());
				webDriver.close();
			} 
		}
	
	@Test
	public void createCustomer15() {
		WebDriver webDriver;
			System.setProperty("webdriver.chrome.driver", "C:/Eden/SQA/chromedriver/chromedriver.exe");
			webDriver = new ChromeDriver();
			try {
				webDriver.get("http://localhost:8080/demo_bhyt/Customer-new");
				Thread.sleep(1000);
				
				WebElement name = webDriver.findElement(By.id("name"));
				name.sendKeys("Phim Minh Hải");
				Thread.sleep(1000);
				
				WebElement idCardNum = webDriver.findElement(By.id("idCardNum"));
				idCardNum.sendKeys("05734287528");
				Thread.sleep(1000);
				
				WebElement dob = webDriver.findElement(By.id("dob"));
				dob.sendKeys("06/06/1999");
				Thread.sleep(1000);
				
				WebElement address = webDriver.findElement(By.id("address"));
				address.sendKeys("Hà Nội");
				Thread.sleep(1000);
				
				WebElement telephone = webDriver.findElement(By.id("telephone"));
				telephone.sendKeys("0908");
				Thread.sleep(1000);
				
				WebElement save = webDriver.findElement(By.id("saveCus"));
				save.click();

				WebDriverWait wait = new WebDriverWait(webDriver, 2);
				WebElement messageElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("message")));
				Thread.sleep(1000);
				String failure = messageElement.getText();
				String expected = "Thêm khách hàng mới thất bại!";
				assertEquals(expected, failure);
				
				//rollback
				customerDAO = new CustomerDAO();
				Customer existedCustomer = customerDAO.selectCustomerbyidcard("05734287528");
				Connection connection = getConnection();
				String sql = "delete from tblCustomer where id = ?";
				PreparedStatement p = (PreparedStatement) connection.prepareStatement(sql);
				p.setInt(1, existedCustomer.getId());
				p.executeUpdate();
				webDriver.close();
				
			} catch (Exception e) {
				System.out.println("Test failed!" + e.getMessage());
				webDriver.close();
			} 
		}
	
	@Test
	public void createCustomer16() {
		WebDriver webDriver;
			System.setProperty("webdriver.chrome.driver", "C:/Eden/SQA/chromedriver/chromedriver.exe");
			webDriver = new ChromeDriver();
			try {
				webDriver.get("http://localhost:8080/demo_bhyt/Customer-new");
				Thread.sleep(1000);
				
				WebElement name = webDriver.findElement(By.id("name"));
				name.sendKeys("Phim Minh Hải");
				Thread.sleep(1000);
				
				WebElement idCardNum = webDriver.findElement(By.id("idCardNum"));
				idCardNum.sendKeys("357435734908");
				Thread.sleep(1000);
				
				WebElement dob = webDriver.findElement(By.id("dob"));
				dob.sendKeys("06/06/1999");
				Thread.sleep(1000);
				
				WebElement address = webDriver.findElement(By.id("address"));
				address.sendKeys("Hà Nội");
				Thread.sleep(1000);
				
				WebElement telephone = webDriver.findElement(By.id("telephone"));
				telephone.sendKeys("09084932488786756542");
				Thread.sleep(1000);
				
				WebElement save = webDriver.findElement(By.id("saveCus"));
				save.click();

				WebDriverWait wait = new WebDriverWait(webDriver, 2);
				WebElement messageElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("message")));
				Thread.sleep(1000);
				String failure = messageElement.getText();
				String expected = "Thêm khách hàng mới thất bại!";
				assertEquals(expected, failure);
				
				//rollback
				customerDAO = new CustomerDAO();
				Customer existedCustomer = customerDAO.selectCustomerbyidcard("357435734908");
				Connection connection = getConnection();
				String sql = "delete from tblCustomer where id = ?";
				PreparedStatement p = (PreparedStatement) connection.prepareStatement(sql);
				p.setInt(1, existedCustomer.getId());
				p.executeUpdate();
				webDriver.close();
				
			} catch (Exception e) {
				System.out.println("Test failed!" + e.getMessage());
				webDriver.close();
			} 
		}

}
