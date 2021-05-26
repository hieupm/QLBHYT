package seleniumtest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mysql.jdbc.PreparedStatement;

import dao.BhytDAO;
import dao.BillDAO;

public class TestCreateBillAndBHYT {
	protected BillDAO billDAO;
	private BhytDAO bhytDAO;
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
	public void createBill1() {
		billDAO = new BillDAO();
		WebDriver webDriver;
			System.setProperty("webdriver.chrome.driver", "C:/Eden/SQA/chromedriver/chromedriver.exe");
			webDriver = new ChromeDriver();
			try {
				int countIdbill1 = billDAO.countBill();
				webDriver.get("http://localhost:8080/demo_bhyt/Bhyt-new");
				Thread.sleep(1000);
				
				//add Bhyt into Bill list
				
				Select idCardNum = new Select(webDriver.findElement(By.id("idCardNum")));
				idCardNum.selectByValue("012913248");
				Thread.sleep(1000);
				
				WebElement startDate = webDriver.findElement(By.id("startDate"));
				startDate.sendKeys("05/24/2021");
				Thread.sleep(1000);
				
				WebElement endDate = webDriver.findElement(By.id("endDate"));
				endDate.sendKeys("05/24/2022");
				Thread.sleep(1000);
				
				WebElement supportLevel = webDriver.findElement(By.id("supportLevel"));
				supportLevel.sendKeys("0.3");
				Thread.sleep(1000);
				
				WebElement salary = webDriver.findElement(By.id("salary"));
				salary.clear();
				Thread.sleep(500);
				salary.sendKeys("5000000");
				Thread.sleep(1000);
				
				Select hospitalName = new Select(webDriver.findElement(By.id("hospitalName")));
				hospitalName.selectByValue("BV 103");
				Thread.sleep(1000);
				
				WebElement addBH = webDriver.findElement(By.id("addBH"));
				addBH.click();
				
				WebDriverWait wait = new WebDriverWait(webDriver, 5);
				WebElement messageElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("bhyt")));
				String successBhyt = messageElement.getText();
				String expected = "Thêm bảo hiểm vào danh sách hóa đơn thành công!";
				assertEquals(expected, successBhyt);          
				Thread.sleep(1000);
				
				//insert bill
				
				Select type = new Select(wait.until(ExpectedConditions.presenceOfElementLocated(By.id("type"))));
				type.selectByValue("Nhóm do người lao động và người sử dụng lao động đóng");
				Thread.sleep(1000);
				
				WebElement paidDate = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("paidDate")));
				paidDate.sendKeys("05/24/2021");
				Thread.sleep(1000);
				
				Select idCardNum2 = new Select(wait.until(ExpectedConditions.presenceOfElementLocated(By.id("idCardNum"))));
				idCardNum2.selectByValue("01385837528");
				Thread.sleep(1000);
				
				Select tblAssociationid = new Select(wait.until(ExpectedConditions.presenceOfElementLocated(By.id("tblAssociationid"))));
				tblAssociationid.selectByValue("1");
				Thread.sleep(1000);
				
				WebElement saveBill = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("saveBill")));
				saveBill.click();
				
				WebElement messageElement2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("bill")));
				String successBill = messageElement2.getText();
				String expected2 = "Thêm hóa đơn và bảo hiểm y tế thành công!";
				assertEquals(expected2, successBill);
				Thread.sleep(2000);
				
				int countIdbill2 = billDAO.countBill();
				assertEquals(countIdbill1+1, countIdbill2); //checkDB
				
				//rollback
				
				
				
				Connection connection = getConnection();
				String sql = "delete from tblBill where id = ?";
				PreparedStatement p = (PreparedStatement) connection.prepareStatement(sql);
				p.setInt(1, countIdbill2);
				p.executeUpdate();
				
				webDriver.close();
			} catch (Exception e) {
				System.out.println("Test failed!" + e.getMessage());
				webDriver.close();
			} 
		}
	
	@Test
	public void createBill2() {
		billDAO = new BillDAO();
		WebDriver webDriver;
			
			System.setProperty("webdriver.chrome.driver", "C:/Eden/SQA/chromedriver/chromedriver.exe");
			webDriver = new ChromeDriver();
			try {
				int countIdbill1 = billDAO.countBill();
				webDriver.get("http://localhost:8080/demo_bhyt/Bhyt-new");
				Thread.sleep(1000);
				
				//add Bhyt into Bill list
				
				Select idCardNum = new Select(webDriver.findElement(By.id("idCardNum")));
				idCardNum.selectByValue("012913248");
				Thread.sleep(1000);
				
				WebElement startDate = webDriver.findElement(By.id("startDate"));
				startDate.sendKeys("05/24/2021");
				Thread.sleep(1000);
				
				WebElement endDate = webDriver.findElement(By.id("endDate"));
				endDate.sendKeys("05/24/2022");
				Thread.sleep(1000);
				
				WebElement supportLevel = webDriver.findElement(By.id("supportLevel"));
				supportLevel.sendKeys("0.3");
				Thread.sleep(1000);
				
				WebElement salary = webDriver.findElement(By.id("salary"));
				salary.clear();
				Thread.sleep(500);
				salary.sendKeys("5000000");
				Thread.sleep(1000);
				
				Select hospitalName = new Select(webDriver.findElement(By.id("hospitalName")));
				hospitalName.selectByValue("BV 103");
				Thread.sleep(1000);
				
				WebElement addBH = webDriver.findElement(By.id("addBH"));
				addBH.click();
				
				WebDriverWait wait = new WebDriverWait(webDriver, 5);
				WebElement messageElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("bhyt")));
				String successBhyt = messageElement.getText();
				String expected = "Thêm bảo hiểm vào danh sách hóa đơn thành công!";
				assertEquals(expected, successBhyt);          
				Thread.sleep(1000);
				
				//insert bill
				
				Select type = new Select(wait.until(ExpectedConditions.presenceOfElementLocated(By.id("type"))));
				type.selectByValue("Nhóm do người lao động và người sử dụng lao động đóng");
				Thread.sleep(1000);
				
				WebElement paidDate = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("paidDate")));
				paidDate.sendKeys("05/24/2021");
				Thread.sleep(1000);
				
				Select idCardNum2 = new Select(wait.until(ExpectedConditions.presenceOfElementLocated(By.id("idCardNum"))));
				idCardNum2.selectByValue("85837528");
				Thread.sleep(1000);
				
				Select tblAssociationid = new Select(wait.until(ExpectedConditions.presenceOfElementLocated(By.id("tblAssociationid"))));
				tblAssociationid.selectByValue("0");
				Thread.sleep(1000);
				
				WebElement saveBill = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("saveBill")));
				saveBill.click();
				
				WebElement messageElement2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("bill")));
				String successBill = messageElement2.getText();
				String expected2 = "Thêm hóa đơn và bảo hiểm y tế thành công!";
				assertEquals(expected2, successBill);
				Thread.sleep(2000);
				
				int countIdbill2 = billDAO.countBill();
				assertEquals(countIdbill1+1, countIdbill2); //checkDB
				
				//rollback

				Connection connection = getConnection();
				String sql = "delete from tblBill where id = ?";
				PreparedStatement p = (PreparedStatement) connection.prepareStatement(sql);
				p.setInt(1, countIdbill2);
				p.executeUpdate();
				
				webDriver.close();
			} catch (Exception e) {
				System.out.println("Test failed!" + e.getMessage());
				webDriver.close();
			} 
		}
	
	@Test
	public void addBhyt1() {
		WebDriver webDriver;
			System.setProperty("webdriver.chrome.driver", "C:/Eden/SQA/chromedriver/chromedriver.exe");
			webDriver = new ChromeDriver();
			try {
				webDriver.get("http://localhost:8080/demo_bhyt/Bhyt-new");
				Thread.sleep(1000);
				
				//add Bhyt into Bill list
				
				Select idCardNum = new Select(webDriver.findElement(By.id("idCardNum")));
				Thread.sleep(1000);
				
				WebElement startDate = webDriver.findElement(By.id("startDate"));
				startDate.sendKeys("05/24/2021");
				Thread.sleep(1000);
				
				WebElement endDate = webDriver.findElement(By.id("endDate"));
				endDate.sendKeys("05/24/2022");
				Thread.sleep(1000);
				
				WebElement supportLevel = webDriver.findElement(By.id("supportLevel"));
				supportLevel.sendKeys("0.3");
				Thread.sleep(1000);
				
				WebElement salary = webDriver.findElement(By.id("salary"));
				salary.clear();
				Thread.sleep(500);
				salary.sendKeys("5000000");
				Thread.sleep(1000);
				
				Select hospitalName = new Select(webDriver.findElement(By.id("hospitalName")));
				hospitalName.selectByValue("BV 103");
				Thread.sleep(1000);
				
				WebElement addBH = webDriver.findElement(By.id("addBH"));
				addBH.click();
				
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
	public void addBhyt2() {
		WebDriver webDriver;
			System.setProperty("webdriver.chrome.driver", "C:/Eden/SQA/chromedriver/chromedriver.exe");
			webDriver = new ChromeDriver();
			try {
				webDriver.get("http://localhost:8080/demo_bhyt/Bhyt-new");
				Thread.sleep(1000);
				
				//add Bhyt into Bill list
				
				Select idCardNum = new Select(webDriver.findElement(By.id("idCardNum")));
				idCardNum.selectByValue("012913248");
				Thread.sleep(1000);
				
				WebElement startDate = webDriver.findElement(By.id("startDate"));
				startDate.sendKeys("");
				Thread.sleep(1000);
				
				WebElement endDate = webDriver.findElement(By.id("endDate"));
				endDate.sendKeys("05/24/2022");
				Thread.sleep(1000);
				
				WebElement supportLevel = webDriver.findElement(By.id("supportLevel"));
				supportLevel.sendKeys("0.3");
				Thread.sleep(1000);
				
				WebElement salary = webDriver.findElement(By.id("salary"));
				salary.clear();
				Thread.sleep(500);
				salary.sendKeys("5000000");
				Thread.sleep(1000);
				
				Select hospitalName = new Select(webDriver.findElement(By.id("hospitalName")));
				hospitalName.selectByValue("BV 103");
				Thread.sleep(1000);
				
				WebElement addBH = webDriver.findElement(By.id("addBH"));
				addBH.click();
				
				JavascriptExecutor js = (JavascriptExecutor) webDriver; 
				boolean isRequired = (Boolean) js.executeScript("return arguments[0].required;",startDate);
				

				assertTrue(isRequired==true);
				Thread.sleep(1000);
				
				webDriver.close();
			} catch (Exception e) {
				System.out.println("Test failed!" + e.getMessage());
				webDriver.close();
			} 
		}
	
	@Test
	public void addBhyt3() {
		WebDriver webDriver;
			System.setProperty("webdriver.chrome.driver", "C:/Eden/SQA/chromedriver/chromedriver.exe");
			webDriver = new ChromeDriver();
			try {
				webDriver.get("http://localhost:8080/demo_bhyt/Bhyt-new");
				Thread.sleep(1000);
				
				//add Bhyt into Bill list
				
				Select idCardNum = new Select(webDriver.findElement(By.id("idCardNum")));
				idCardNum.selectByValue("012913248");
				Thread.sleep(1000);
				
				WebElement startDate = webDriver.findElement(By.id("startDate"));
				startDate.sendKeys("05/24/2021");
				Thread.sleep(1000);
				
				WebElement endDate = webDriver.findElement(By.id("endDate"));
				endDate.sendKeys("");
				Thread.sleep(1000);
				
				WebElement supportLevel = webDriver.findElement(By.id("supportLevel"));
				supportLevel.sendKeys("0.3");
				Thread.sleep(1000);
				
				WebElement salary = webDriver.findElement(By.id("salary"));
				salary.clear();
				Thread.sleep(500);
				salary.sendKeys("5000000");
				Thread.sleep(1000);
				
				Select hospitalName = new Select(webDriver.findElement(By.id("hospitalName")));
				hospitalName.selectByValue("BV 103");
				Thread.sleep(1000);
				
				WebElement addBH = webDriver.findElement(By.id("addBH"));
				addBH.click();
				
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
	public void addBhyt4() {
		WebDriver webDriver;
			System.setProperty("webdriver.chrome.driver", "C:/Eden/SQA/chromedriver/chromedriver.exe");
			webDriver = new ChromeDriver();
			try {
				webDriver.get("http://localhost:8080/demo_bhyt/Bhyt-new");
				Thread.sleep(1000);
				
				//add Bhyt into Bill list
				
				Select idCardNum = new Select(webDriver.findElement(By.id("idCardNum")));
				idCardNum.selectByValue("012913248");
				Thread.sleep(1000);
				
				WebElement startDate = webDriver.findElement(By.id("startDate"));
				startDate.sendKeys("05/24/2021");
				Thread.sleep(1000);
				
				WebElement endDate = webDriver.findElement(By.id("endDate"));
				endDate.sendKeys("05/24/2022");
				Thread.sleep(1000);
				
				WebElement supportLevel = webDriver.findElement(By.id("supportLevel"));
				supportLevel.sendKeys("");
				Thread.sleep(1000);
				
				WebElement salary = webDriver.findElement(By.id("salary"));
				salary.clear();
				Thread.sleep(500);
				salary.sendKeys("5000000");
				Thread.sleep(1000);
				
				Select hospitalName = new Select(webDriver.findElement(By.id("hospitalName")));
				hospitalName.selectByValue("BV 103");
				Thread.sleep(1000);
				
				WebElement addBH = webDriver.findElement(By.id("addBH"));
				addBH.click();
				
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
	public void addBhyt5() {
		WebDriver webDriver;
			System.setProperty("webdriver.chrome.driver", "C:/Eden/SQA/chromedriver/chromedriver.exe");
			webDriver = new ChromeDriver();
			try {
				webDriver.get("http://localhost:8080/demo_bhyt/Bhyt-new");
				Thread.sleep(1000);
				
				//add Bhyt into Bill list
				
				Select idCardNum = new Select(webDriver.findElement(By.id("idCardNum")));
				idCardNum.selectByValue("012913248");
				Thread.sleep(1000);
				
				WebElement startDate = webDriver.findElement(By.id("startDate"));
				startDate.sendKeys("05/24/2021");
				Thread.sleep(1000);
				
				WebElement endDate = webDriver.findElement(By.id("endDate"));
				endDate.sendKeys("05/24/2022");
				Thread.sleep(1000);
				
				WebElement supportLevel = webDriver.findElement(By.id("supportLevel"));
				supportLevel.sendKeys("0.3");
				Thread.sleep(1000);
				
				WebElement salary = webDriver.findElement(By.id("salary"));
				salary.clear();
				Thread.sleep(500);
				
				Select hospitalName = new Select(webDriver.findElement(By.id("hospitalName")));
				hospitalName.selectByValue("BV 103");
				Thread.sleep(1000);
				
				WebElement addBH = webDriver.findElement(By.id("addBH"));
				addBH.click();
				
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
	public void addBhyt6() {
		WebDriver webDriver;
			System.setProperty("webdriver.chrome.driver", "C:/Eden/SQA/chromedriver/chromedriver.exe");
			webDriver = new ChromeDriver();
			try {
				webDriver.get("http://localhost:8080/demo_bhyt/Bhyt-new");
				Thread.sleep(1000);
				
				//add Bhyt into Bill list
				
				Select idCardNum = new Select(webDriver.findElement(By.id("idCardNum")));
				idCardNum.selectByValue("012913248");
				Thread.sleep(1000);
				
				WebElement startDate = webDriver.findElement(By.id("startDate"));
				startDate.sendKeys("05/24/2021");
				Thread.sleep(1000);
				
				WebElement endDate = webDriver.findElement(By.id("endDate"));
				endDate.sendKeys("05/24/2022");
				Thread.sleep(1000);
				
				WebElement supportLevel = webDriver.findElement(By.id("supportLevel"));
				supportLevel.sendKeys("-0.3");
				Thread.sleep(1000);
				
				WebElement salary = webDriver.findElement(By.id("salary"));
				Thread.sleep(500);
				
				Select hospitalName = new Select(webDriver.findElement(By.id("hospitalName")));
				hospitalName.selectByValue("BV 103");
				Thread.sleep(1000);
				
				WebElement addBH = webDriver.findElement(By.id("addBH"));
				addBH.click();
				
				WebDriverWait wait = new WebDriverWait(webDriver, 5);
				WebElement messageElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("bhyt")));
				String success = messageElement.getText();
				String expected = "Thêm bảo hiểm vào danh sách hóa đơn thất bại!";
				assertEquals(expected, success);
				Thread.sleep(1000);
				
				
				webDriver.close();
			} catch (Exception e) {
				System.out.println("Test failed!" + e.getMessage());
				webDriver.close();
			} 
		}
	
	@Test
	public void addBhyt7() {
		WebDriver webDriver;
			System.setProperty("webdriver.chrome.driver", "C:/Eden/SQA/chromedriver/chromedriver.exe");
			webDriver = new ChromeDriver();
			try {
				webDriver.get("http://localhost:8080/demo_bhyt/Bhyt-new");
				Thread.sleep(1000);
				
				//add Bhyt into Bill list
				
				Select idCardNum = new Select(webDriver.findElement(By.id("idCardNum")));
				idCardNum.selectByValue("012913248");
				Thread.sleep(1000);
				
				WebElement startDate = webDriver.findElement(By.id("startDate"));
				startDate.sendKeys("05/24/2021");
				Thread.sleep(1000);
				
				WebElement endDate = webDriver.findElement(By.id("endDate"));
				endDate.sendKeys("05/24/2022");
				Thread.sleep(1000);
				
				WebElement supportLevel = webDriver.findElement(By.id("supportLevel"));
				supportLevel.sendKeys("1.3");
				Thread.sleep(1000);
				
				WebElement salary = webDriver.findElement(By.id("salary"));
				salary.clear();
				Thread.sleep(500);
				salary.sendKeys("5000000");
				Thread.sleep(500);
				
				Select hospitalName = new Select(webDriver.findElement(By.id("hospitalName")));
				hospitalName.selectByValue("BV 103");
				Thread.sleep(1000);
				
				WebElement addBH = webDriver.findElement(By.id("addBH"));
				addBH.click();
				
				WebDriverWait wait = new WebDriverWait(webDriver, 5);
				WebElement messageElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("bhyt")));
				String success = messageElement.getText();
				String expected = "Thêm bảo hiểm vào danh sách hóa đơn thất bại!";
				assertEquals(expected, success);
				Thread.sleep(1000);
				
				
				webDriver.close();
			} catch (Exception e) {
				System.out.println("Test failed!" + e.getMessage());
				webDriver.close();
			} 
		}
	
	@Test
	public void addBhyt8() {
		WebDriver webDriver;
			System.setProperty("webdriver.chrome.driver", "C:/Eden/SQA/chromedriver/chromedriver.exe");
			webDriver = new ChromeDriver();
			try {
				webDriver.get("http://localhost:8080/demo_bhyt/Bhyt-new");
				Thread.sleep(1000);
				
				//add Bhyt into Bill list
				
				Select idCardNum = new Select(webDriver.findElement(By.id("idCardNum")));
				idCardNum.selectByValue("012913248");
				Thread.sleep(1000);
				
				WebElement startDate = webDriver.findElement(By.id("startDate"));
				startDate.sendKeys("05/24/2021");
				Thread.sleep(1000);
				
				WebElement endDate = webDriver.findElement(By.id("endDate"));
				endDate.sendKeys("05/24/2022");
				Thread.sleep(1000);
				
				WebElement supportLevel = webDriver.findElement(By.id("supportLevel"));
				supportLevel.sendKeys("0.4");
				Thread.sleep(1000);
				
				WebElement salary = webDriver.findElement(By.id("salary"));
				salary.clear();
				Thread.sleep(500);
				salary.sendKeys("-5000000");
				Thread.sleep(500);
				
				Select hospitalName = new Select(webDriver.findElement(By.id("hospitalName")));
				hospitalName.selectByValue("BV 103");
				Thread.sleep(1000);
				
				WebElement addBH = webDriver.findElement(By.id("addBH"));
				addBH.click();
				
				WebDriverWait wait = new WebDriverWait(webDriver, 5);
				WebElement messageElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("bhyt")));
				String success = messageElement.getText();
				String expected = "Thêm bảo hiểm vào danh sách hóa đơn thất bại!";
				assertEquals(expected, success);
				Thread.sleep(1000);
				
				
				webDriver.close();
			} catch (Exception e) {
				System.out.println("Test failed!" + e.getMessage());
				webDriver.close();
			} 
		}
	
	@Test
	public void addBhyt9() {
		WebDriver webDriver;
			System.setProperty("webdriver.chrome.driver", "C:/Eden/SQA/chromedriver/chromedriver.exe");
			webDriver = new ChromeDriver();
			try {
				webDriver.get("http://localhost:8080/demo_bhyt/Bhyt-new");
				Thread.sleep(1000);
				
				//add Bhyt into Bill list
				
				Select idCardNum = new Select(webDriver.findElement(By.id("idCardNum")));
				idCardNum.selectByValue("012913248");
				Thread.sleep(1000);
				
				WebElement startDate = webDriver.findElement(By.id("startDate"));
				startDate.sendKeys("05/24/2021");
				Thread.sleep(1000);
				
				WebElement endDate = webDriver.findElement(By.id("endDate"));
				endDate.sendKeys("05/24/2020");
				Thread.sleep(1000);
				
				WebElement supportLevel = webDriver.findElement(By.id("supportLevel"));
				supportLevel.sendKeys("0.4");
				Thread.sleep(1000);
				
				WebElement salary = webDriver.findElement(By.id("salary"));
				salary.clear();
				Thread.sleep(500);
				salary.sendKeys("-5000000");
				Thread.sleep(500);
				
				Select hospitalName = new Select(webDriver.findElement(By.id("hospitalName")));
				hospitalName.selectByValue("BV 103");
				Thread.sleep(1000);
				
				WebElement addBH = webDriver.findElement(By.id("addBH"));
				addBH.click();
				
				WebDriverWait wait = new WebDriverWait(webDriver, 5);
				WebElement messageElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("bhyt")));
				String success = messageElement.getText();
				String expected = "Thêm bảo hiểm vào danh sách hóa đơn thất bại!";
				assertEquals(expected, success);
				Thread.sleep(1000);
				
				
				webDriver.close();
			} catch (Exception e) {
				System.out.println("Test failed!" + e.getMessage());
				webDriver.close();
			} 
		}
	
	@Test
	public void addBhyt10() {
		WebDriver webDriver;
			System.setProperty("webdriver.chrome.driver", "C:/Eden/SQA/chromedriver/chromedriver.exe");
			webDriver = new ChromeDriver();
			try {
				webDriver.get("http://localhost:8080/demo_bhyt/Bhyt-new");
				Thread.sleep(1000);
				
				//add Bhyt into Bill list
				
				Select idCardNum = new Select(webDriver.findElement(By.id("idCardNum")));
				idCardNum.selectByValue("012913248");
				Thread.sleep(1000);
				
				WebElement startDate = webDriver.findElement(By.id("startDate"));
				startDate.sendKeys("05/24/2021");
				Thread.sleep(1000);
				
				WebElement endDate = webDriver.findElement(By.id("endDate"));
				endDate.sendKeys("05/24/2022");
				Thread.sleep(1000);
				
				WebElement supportLevel = webDriver.findElement(By.id("supportLevel"));
				supportLevel.sendKeys("abcd");
				Thread.sleep(1000);
				
				WebElement salary = webDriver.findElement(By.id("salary"));
				salary.clear();
				Thread.sleep(500);
				salary.sendKeys("5000000");
				Thread.sleep(500);
				
				Select hospitalName = new Select(webDriver.findElement(By.id("hospitalName")));
				hospitalName.selectByValue("BV 103");
				Thread.sleep(1000);
				
				WebElement addBH = webDriver.findElement(By.id("addBH"));
				addBH.click();
				
				WebDriverWait wait = new WebDriverWait(webDriver, 5);
				WebElement messageElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("bhyt")));
				String success = messageElement.getText();
				String expected = "Thêm bảo hiểm vào danh sách hóa đơn thất bại!";
				assertEquals(expected, success);
				Thread.sleep(1000);
				
				
				webDriver.close();
			} catch (Exception e) {
				System.out.println("Test failed!" + e.getMessage());
				webDriver.close();
			} 
		}
	
	@Test
	public void addBhyt11() {
		WebDriver webDriver;
			System.setProperty("webdriver.chrome.driver", "C:/Eden/SQA/chromedriver/chromedriver.exe");
			webDriver = new ChromeDriver();
			try {
				webDriver.get("http://localhost:8080/demo_bhyt/Bhyt-new");
				Thread.sleep(1000);
				
				//add Bhyt into Bill list
				
				Select idCardNum = new Select(webDriver.findElement(By.id("idCardNum")));
				idCardNum.selectByValue("012913248");
				Thread.sleep(1000);
				
				WebElement startDate = webDriver.findElement(By.id("startDate"));
				startDate.sendKeys("05/24/2021");
				Thread.sleep(1000);
				
				WebElement endDate = webDriver.findElement(By.id("endDate"));
				endDate.sendKeys("05/24/2022");
				Thread.sleep(1000);
				
				WebElement supportLevel = webDriver.findElement(By.id("supportLevel"));
				supportLevel.sendKeys("0.3");
				Thread.sleep(1000);
				
				WebElement salary = webDriver.findElement(By.id("salary"));
				salary.clear();
				Thread.sleep(500);
				salary.sendKeys("hjfghs");
				Thread.sleep(500);
				
				Select hospitalName = new Select(webDriver.findElement(By.id("hospitalName")));
				hospitalName.selectByValue("BV 103");
				Thread.sleep(1000);
				
				WebElement addBH = webDriver.findElement(By.id("addBH"));
				addBH.click();
				
				
				
				WebDriverWait wait = new WebDriverWait(webDriver, 5);
				WebElement messageElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("bhyt")));
				String success = messageElement.getText();
				String expected = "Thêm bảo hiểm vào danh sách hóa đơn thất bại!";
				assertEquals(expected, success);
				Thread.sleep(1000);
				
				
				webDriver.close();
			} catch (Exception e) {
				System.out.println("Test failed!" + e.getMessage());
				webDriver.close();
			} 
		}
	
	@Test
	public void createBill3() {
		WebDriver webDriver;
			System.setProperty("webdriver.chrome.driver", "C:/Eden/SQA/chromedriver/chromedriver.exe");
			webDriver = new ChromeDriver();
			try {
				webDriver.get("http://localhost:8080/demo_bhyt/Bhyt-new");
				Thread.sleep(1000);
				
				//add Bhyt into Bill list
				
				Select idCardNum = new Select(webDriver.findElement(By.id("idCardNum")));
				idCardNum.selectByValue("012913248");
				Thread.sleep(1000);
				
				WebElement startDate = webDriver.findElement(By.id("startDate"));
				startDate.sendKeys("05/24/2021");
				Thread.sleep(1000);
				
				WebElement endDate = webDriver.findElement(By.id("endDate"));
				endDate.sendKeys("05/24/2022");
				Thread.sleep(1000);
				
				WebElement supportLevel = webDriver.findElement(By.id("supportLevel"));
				supportLevel.sendKeys("0.3");
				Thread.sleep(1000);
				
				WebElement salary = webDriver.findElement(By.id("salary"));
				salary.clear();
				Thread.sleep(500);
				salary.sendKeys("5000000");
				Thread.sleep(1000);
				
				Select hospitalName = new Select(webDriver.findElement(By.id("hospitalName")));
				hospitalName.selectByValue("BV 103");
				Thread.sleep(1000);
				
				WebElement addBH = webDriver.findElement(By.id("addBH"));
				addBH.click();
				
				WebDriverWait wait = new WebDriverWait(webDriver, 5);
				WebElement messageElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("bhyt")));
				String successBhyt = messageElement.getText();
				String expected = "Thêm bảo hiểm vào danh sách hóa đơn thành công!";
				assertEquals(expected, successBhyt);          
				Thread.sleep(1000);
				
				//insert bill
				
				Select type = new Select(wait.until(ExpectedConditions.presenceOfElementLocated(By.id("type"))));
//				type.selectByValue("Nhóm do người lao động và người sử dụng lao động đóng");
//				Thread.sleep(1000);
				
				WebElement paidDate = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("paidDate")));
				paidDate.sendKeys("05/24/2021");
				Thread.sleep(1000);
				
				Select idCardNum2 = new Select(wait.until(ExpectedConditions.presenceOfElementLocated(By.id("idCardNum"))));
				idCardNum2.selectByValue("85837528");
				Thread.sleep(1000);
				
				Select tblAssociationid = new Select(wait.until(ExpectedConditions.presenceOfElementLocated(By.id("tblAssociationid"))));
				tblAssociationid.selectByValue("1");
				Thread.sleep(1000);
				
				WebElement saveBill = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("saveBill")));
				saveBill.click();
				
				JavascriptExecutor js = (JavascriptExecutor) webDriver; 
				boolean isRequired = (Boolean) js.executeScript("return arguments[0].required;",type);
				assertTrue(isRequired==true);
				Thread.sleep(1000);
				
				//rollback
				billDAO = new BillDAO();
				int countId2 = billDAO.countBill();
				Connection connection = getConnection();
				String sql = "delete from tblBill where id = ?";
				PreparedStatement p = (PreparedStatement) connection.prepareStatement(sql);
				p.setInt(1, countId2);
				p.executeUpdate();
				
				webDriver.close();
			} catch (Exception e) {
				System.out.println("Test failed!" + e.getMessage());
				webDriver.close();
			} 
		}
	
	@Test
	public void createBill4() {
		WebDriver webDriver;
			System.setProperty("webdriver.chrome.driver", "C:/Eden/SQA/chromedriver/chromedriver.exe");
			webDriver = new ChromeDriver();
			try {
				webDriver.get("http://localhost:8080/demo_bhyt/Bhyt-new");
				Thread.sleep(1000);
				
				//add Bhyt into Bill list
				
				Select idCardNum = new Select(webDriver.findElement(By.id("idCardNum")));
				idCardNum.selectByValue("012913248");
				Thread.sleep(1000);
				
				WebElement startDate = webDriver.findElement(By.id("startDate"));
				startDate.sendKeys("05/24/2021");
				Thread.sleep(1000);
				
				WebElement endDate = webDriver.findElement(By.id("endDate"));
				endDate.sendKeys("05/24/2022");
				Thread.sleep(1000);
				
				WebElement supportLevel = webDriver.findElement(By.id("supportLevel"));
				supportLevel.sendKeys("0.3");
				Thread.sleep(1000);
				
				WebElement salary = webDriver.findElement(By.id("salary"));
				salary.clear();
				Thread.sleep(500);
				salary.sendKeys("5000000");
				Thread.sleep(1000);
				
				Select hospitalName = new Select(webDriver.findElement(By.id("hospitalName")));
				hospitalName.selectByValue("BV 103");
				Thread.sleep(1000);
				
				WebElement addBH = webDriver.findElement(By.id("addBH"));
				addBH.click();
				
				WebDriverWait wait = new WebDriverWait(webDriver, 5);
				WebElement messageElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("bhyt")));
				String successBhyt = messageElement.getText();
				String expected = "Thêm bảo hiểm vào danh sách hóa đơn thành công!";
				assertEquals(expected, successBhyt);          
				Thread.sleep(1000);
				
				//insert bill
				
				Select type = new Select(wait.until(ExpectedConditions.presenceOfElementLocated(By.id("type"))));
				type.selectByValue("Nhóm do cơ quan bảo hiểm xã hội đóng");
				Thread.sleep(1000);
				
				WebElement paidDate = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("paidDate")));
				paidDate.sendKeys("");
				Thread.sleep(1000);
				
				Select idCardNum2 = new Select(wait.until(ExpectedConditions.presenceOfElementLocated(By.id("idCardNum"))));
				idCardNum2.selectByValue("85837528");
				Thread.sleep(1000);
				
				Select tblAssociationid = new Select(wait.until(ExpectedConditions.presenceOfElementLocated(By.id("tblAssociationid"))));
				tblAssociationid.selectByValue("2");
				Thread.sleep(1000);
				
				WebElement saveBill = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("saveBill")));
				saveBill.click();
				
				JavascriptExecutor js = (JavascriptExecutor) webDriver; 
				boolean isRequired = (Boolean) js.executeScript("return arguments[0].required;",paidDate);
				assertTrue(isRequired==true);
				Thread.sleep(1000);
				
				
				//rollback
				billDAO = new BillDAO();
				int countId2 = billDAO.countBill();
				Connection connection = getConnection();
				String sql = "delete from tblBill where id = ?";
				PreparedStatement p = (PreparedStatement) connection.prepareStatement(sql);
				p.setInt(1, countId2);
				p.executeUpdate();
				
				webDriver.close();
			} catch (Exception e) {
				System.out.println("Test failed!" + e.getMessage());
				webDriver.close();
			} 
		}
	
	@Test
	public void createBill5() {
		WebDriver webDriver;
			System.setProperty("webdriver.chrome.driver", "C:/Eden/SQA/chromedriver/chromedriver.exe");
			webDriver = new ChromeDriver();
			try {
				webDriver.get("http://localhost:8080/demo_bhyt/Bhyt-new");
				Thread.sleep(1000);
				
				//add Bhyt into Bill list
				
				Select idCardNum = new Select(webDriver.findElement(By.id("idCardNum")));
				idCardNum.selectByValue("012913248");
				Thread.sleep(1000);
				
				WebElement startDate = webDriver.findElement(By.id("startDate"));
				startDate.sendKeys("05/24/2021");
				Thread.sleep(1000);
				
				WebElement endDate = webDriver.findElement(By.id("endDate"));
				endDate.sendKeys("05/24/2022");
				Thread.sleep(1000);
				
				WebElement supportLevel = webDriver.findElement(By.id("supportLevel"));
				supportLevel.sendKeys("0.3");
				Thread.sleep(1000);
				
				WebElement salary = webDriver.findElement(By.id("salary"));
				salary.clear();
				Thread.sleep(500);
				salary.sendKeys("5000000");
				Thread.sleep(1000);
				
				Select hospitalName = new Select(webDriver.findElement(By.id("hospitalName")));
				hospitalName.selectByValue("BV 103");
				Thread.sleep(1000);
				
				WebElement addBH = webDriver.findElement(By.id("addBH"));
				addBH.click();
				
				WebDriverWait wait = new WebDriverWait(webDriver, 5);
				WebElement messageElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("bhyt")));
				String successBhyt = messageElement.getText();
				String expected = "Thêm bảo hiểm vào danh sách hóa đơn thành công!";
				assertEquals(expected, successBhyt);          
				Thread.sleep(1000);
				
				//insert bill
				
				Select type = new Select(wait.until(ExpectedConditions.presenceOfElementLocated(By.id("type"))));
				type.selectByValue("Nhóm do người lao động và người sử dụng lao động đóng");
				Thread.sleep(1000);
				
				WebElement paidDate = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("paidDate")));
				paidDate.sendKeys("05/24/2021");
				Thread.sleep(1000);
				
				Select idCardNum2 = new Select(wait.until(ExpectedConditions.presenceOfElementLocated(By.id("idCardNum"))));
				
				Select tblAssociationid = new Select(wait.until(ExpectedConditions.presenceOfElementLocated(By.id("tblAssociationid"))));
				tblAssociationid.selectByValue("1");
				Thread.sleep(1000);
				
				WebElement saveBill = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("saveBill")));
				saveBill.click();
				
				JavascriptExecutor js = (JavascriptExecutor) webDriver; 
				boolean isRequired = (Boolean) js.executeScript("return arguments[0].required;",idCardNum2);
				assertTrue(isRequired==true);
				Thread.sleep(1000);
				
				
				//rollback
				billDAO = new BillDAO();
				int countId2 = billDAO.countBill();
				Connection connection = getConnection();
				String sql = "delete from tblBill where id = ?";
				PreparedStatement p = (PreparedStatement) connection.prepareStatement(sql);
				p.setInt(1, countId2);
				p.executeUpdate();
				
				webDriver.close();
			} catch (Exception e) {
				System.out.println("Test failed!" + e.getMessage());
				webDriver.close();
			} 
		}
	
	
	
}
