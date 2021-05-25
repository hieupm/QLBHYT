package seleniumtest;

import static org.junit.Assert.assertEquals;
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
import org.openqa.selenium.support.ui.WebDriverWait;

import dao.CustomerDAO;

public class TestEditCustomer {
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
	public void updateCustomer1() {
		WebDriver webDriver;

			System.setProperty("webdriver.chrome.driver", "C:/Eden/SQA/chromedriver/chromedriver.exe");
			webDriver = new ChromeDriver();
			try {
				webDriver.get("http://localhost:8080/demo_bhyt/Customer-list");
				Thread.sleep(1000);
				WebElement edit = webDriver.findElement(By.id("edit?id=3"));
				edit.click();
				WebElement name = webDriver.findElement(By.id("name"));
				name.clear();
				Thread.sleep(1000);
				name.sendKeys("Phạm Minh Hiếu");
				Thread.sleep(1000);
				WebElement idCardNum = webDriver.findElement(By.id("idCardNum"));
				idCardNum.clear();
				Thread.sleep(1000);
				idCardNum.sendKeys("012903248");
				Thread.sleep(1000);
				
				WebElement dob = webDriver.findElement(By.id("dob"));
				dob.clear();
				Thread.sleep(1000);
				dob.sendKeys("06/06/1999");
				Thread.sleep(1000);
				
				WebElement address = webDriver.findElement(By.id("address"));
				address.clear();
				Thread.sleep(1000);
				address.sendKeys("Nguyễn Trãi, Hà Nội");
				Thread.sleep(1000);
				
				WebElement telephone = webDriver.findElement(By.id("telephone"));
				telephone.clear();
				Thread.sleep(1000);
				telephone.sendKeys("0164579895");
				Thread.sleep(1000);
				
				WebElement save = webDriver.findElement(By.id("saveCus"));
				save.click();
				
				WebDriverWait wait = new WebDriverWait(webDriver, 1);
				WebElement messageElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("message")));
				Thread.sleep(2000);
				String success = messageElement.getText();
				String expected = "Cập nhật thành công!";
				assertEquals(expected, success);
				webDriver.close();
				
			} catch (Exception e) {
				System.out.println("Test failed!" + e.getMessage());
				webDriver.close();
			} 
		}
	
	@Test
	public void updateCustomer2() {
		WebDriver webDriver;

			System.setProperty("webdriver.chrome.driver", "C:/Eden/SQA/chromedriver/chromedriver.exe");
			webDriver = new ChromeDriver();
			try {
				webDriver.get("http://localhost:8080/demo_bhyt/Customer-list");

				WebElement edit = webDriver.findElement(By.id("edit?id=3"));
				edit.click();
				WebElement name = webDriver.findElement(By.id("name"));
				name.clear();
				Thread.sleep(1000);
				name.sendKeys("");
				Thread.sleep(1000);
				WebElement idCardNum = webDriver.findElement(By.id("idCardNum"));
				idCardNum.clear();
				Thread.sleep(1000);
				idCardNum.sendKeys("012303248");
				Thread.sleep(1000);
				
				WebElement dob = webDriver.findElement(By.id("dob"));
				dob.clear();
				Thread.sleep(1000);
				dob.sendKeys("06/06/1999");
				Thread.sleep(1000);
				
				WebElement address = webDriver.findElement(By.id("address"));
				address.clear();
				Thread.sleep(1000);
				address.sendKeys("Nguyễn Trãi, Hà Nội");
				Thread.sleep(1000);
				
				WebElement telephone = webDriver.findElement(By.id("telephone"));
				telephone.clear();
				Thread.sleep(1000);
				telephone.sendKeys("0164579895");
				Thread.sleep(1000);
				
				WebElement save = webDriver.findElement(By.id("saveCus"));
				save.click();
				
				JavascriptExecutor js = (JavascriptExecutor) webDriver; 
				boolean isRequired = (Boolean) js.executeScript("return arguments[0].required;",name);
				
				assertTrue(isRequired);
				Thread.sleep(2000);
				webDriver.close();
				
			} catch (Exception e) {
				System.out.println("Test failed!" + e.getMessage());
				webDriver.close();
			} 
		}
	
	@Test
	public void updateCustomer3() {
		WebDriver webDriver;

			System.setProperty("webdriver.chrome.driver", "C:/Eden/SQA/chromedriver/chromedriver.exe");
			webDriver = new ChromeDriver();
			try {
				webDriver.get("http://localhost:8080/demo_bhyt/Customer-list");

				WebElement edit = webDriver.findElement(By.id("edit?id=3"));
				edit.click();
				WebElement name = webDriver.findElement(By.id("name"));
				name.clear();
				Thread.sleep(1000);
				name.sendKeys("Phạm Minh Hiếu");
				Thread.sleep(1000);
				WebElement idCardNum = webDriver.findElement(By.id("idCardNum"));
				idCardNum.clear();
				Thread.sleep(1000);
				idCardNum.sendKeys("");
				Thread.sleep(1000);
				
				WebElement dob = webDriver.findElement(By.id("dob"));
				dob.clear();
				Thread.sleep(1000);
				dob.sendKeys("06/06/1999");
				Thread.sleep(1000);
				
				WebElement address = webDriver.findElement(By.id("address"));
				address.clear();
				Thread.sleep(1000);
				address.sendKeys("Nguyễn Trãi, Hà Nội");
				Thread.sleep(1000);
				
				WebElement telephone = webDriver.findElement(By.id("telephone"));
				telephone.clear();
				Thread.sleep(1000);
				telephone.sendKeys("0164579895");
				Thread.sleep(1000);
				
				WebElement save = webDriver.findElement(By.id("saveCus"));
				save.click();
				
				JavascriptExecutor js = (JavascriptExecutor) webDriver; 
				boolean isRequired = (Boolean) js.executeScript("return arguments[0].required;",name);
				
				assertTrue(isRequired);
				Thread.sleep(2000);
				webDriver.close();
				
			} catch (Exception e) {
				System.out.println("Test failed!" + e.getMessage());
				webDriver.close();
			} 
		}
	
	@Test
	public void updateCustomer4() {
		WebDriver webDriver;

			System.setProperty("webdriver.chrome.driver", "C:/Eden/SQA/chromedriver/chromedriver.exe");
			webDriver = new ChromeDriver();
			try {
				webDriver.get("http://localhost:8080/demo_bhyt/Customer-list");

				WebElement edit = webDriver.findElement(By.id("edit?id=3"));
				edit.click();
				WebElement name = webDriver.findElement(By.id("name"));
				name.clear();
				Thread.sleep(1000);
				name.sendKeys("Phạm Minh Hiếu");
				Thread.sleep(1000);
				WebElement idCardNum = webDriver.findElement(By.id("idCardNum"));
				idCardNum.clear();
				Thread.sleep(1000);
				idCardNum.sendKeys("012903248");
				Thread.sleep(1000);
				
				WebElement dob = webDriver.findElement(By.id("dob"));
				dob.clear();
				Thread.sleep(1000);
				dob.sendKeys("");
				Thread.sleep(1000);
				
				WebElement address = webDriver.findElement(By.id("address"));
				address.clear();
				Thread.sleep(1000);
				address.sendKeys("Nguyễn Trãi, Hà Nội");
				Thread.sleep(1000);
				
				WebElement telephone = webDriver.findElement(By.id("telephone"));
				telephone.clear();
				Thread.sleep(1000);
				telephone.sendKeys("0164579895");
				Thread.sleep(1000);
				
				WebElement save = webDriver.findElement(By.id("saveCus"));
				save.click();
				
				JavascriptExecutor js = (JavascriptExecutor) webDriver; 
				boolean isRequired = (Boolean) js.executeScript("return arguments[0].required;",name);
				
				assertTrue(isRequired);
				Thread.sleep(2000);
				webDriver.close();
				
			} catch (Exception e) {
				System.out.println("Test failed!" + e.getMessage());
				webDriver.close();
			} 
		}
	
	@Test
	public void updateCustomer5() {
		WebDriver webDriver;

			System.setProperty("webdriver.chrome.driver", "C:/Eden/SQA/chromedriver/chromedriver.exe");
			webDriver = new ChromeDriver();
			try {
				webDriver.get("http://localhost:8080/demo_bhyt/Customer-list");

				WebElement edit = webDriver.findElement(By.id("edit?id=3"));
				edit.click();
				WebElement name = webDriver.findElement(By.id("name"));
				name.clear();
				Thread.sleep(1000);
				name.sendKeys("Phạm Minh Hiếu");
				Thread.sleep(1000);
				WebElement idCardNum = webDriver.findElement(By.id("idCardNum"));
				idCardNum.clear();
				Thread.sleep(1000);
				idCardNum.sendKeys("012903248");
				Thread.sleep(1000);
				
				WebElement dob = webDriver.findElement(By.id("dob"));
				dob.clear();
				Thread.sleep(1000);
				dob.sendKeys("06/06/1999");
				Thread.sleep(1000);
				
				WebElement address = webDriver.findElement(By.id("address"));
				address.clear();
				Thread.sleep(1000);
				address.sendKeys("");
				Thread.sleep(1000);
				
				WebElement telephone = webDriver.findElement(By.id("telephone"));
				telephone.clear();
				Thread.sleep(1000);
				telephone.sendKeys("0164579895");
				Thread.sleep(1000);
				
				WebElement save = webDriver.findElement(By.id("saveCus"));
				save.click();
				
				JavascriptExecutor js = (JavascriptExecutor) webDriver; 
				boolean isRequired = (Boolean) js.executeScript("return arguments[0].required;",name);
				
				assertTrue(isRequired);
				Thread.sleep(2000);
				webDriver.close();
				
			} catch (Exception e) {
				System.out.println("Test failed!" + e.getMessage());
				webDriver.close();
			} 
		}
	
	@Test
	public void updateCustomer6() {
		WebDriver webDriver;

			System.setProperty("webdriver.chrome.driver", "C:/Eden/SQA/chromedriver/chromedriver.exe");
			webDriver = new ChromeDriver();
			try {
				webDriver.get("http://localhost:8080/demo_bhyt/Customer-list");

				WebElement edit = webDriver.findElement(By.id("edit?id=3"));
				edit.click();
				WebElement name = webDriver.findElement(By.id("name"));
				name.clear();
				Thread.sleep(1000);
				name.sendKeys("Phạm Minh Hiếu");
				Thread.sleep(1000);
				WebElement idCardNum = webDriver.findElement(By.id("idCardNum"));
				idCardNum.clear();
				Thread.sleep(1000);
				idCardNum.sendKeys("012903248");
				Thread.sleep(1000);
				
				WebElement dob = webDriver.findElement(By.id("dob"));
				dob.clear();
				Thread.sleep(1000);
				dob.sendKeys("06/06/1999");
				Thread.sleep(1000);
				
				WebElement address = webDriver.findElement(By.id("address"));
				address.clear();
				Thread.sleep(1000);
				address.sendKeys("Hà Nội");
				Thread.sleep(1000);
				
				WebElement telephone = webDriver.findElement(By.id("telephone"));
				telephone.clear();
				Thread.sleep(1000);
				telephone.sendKeys("");
				Thread.sleep(1000);
				
				WebElement save = webDriver.findElement(By.id("saveCus"));
				save.click();
				
				JavascriptExecutor js = (JavascriptExecutor) webDriver; 
				boolean isRequired = (Boolean) js.executeScript("return arguments[0].required;",name);
				
				assertTrue(isRequired);
				Thread.sleep(2000);
				webDriver.close();
				
			} catch (Exception e) {
				System.out.println("Test failed!" + e.getMessage());
				webDriver.close();
			} 
		}
	
	@Test
	public void updateCustomer7() {
		WebDriver webDriver;

			System.setProperty("webdriver.chrome.driver", "C:/Eden/SQA/chromedriver/chromedriver.exe");
			webDriver = new ChromeDriver();
			try {
				webDriver.get("http://localhost:8080/demo_bhyt/Customer-list");
				Thread.sleep(1000);
				WebElement edit = webDriver.findElement(By.id("edit?id=3"));
				edit.click();
				WebElement name = webDriver.findElement(By.id("name"));
				name.clear();
				Thread.sleep(1000);
				name.sendKeys("Phạm Minh Hiếu");
				Thread.sleep(1000);
				WebElement idCardNum = webDriver.findElement(By.id("idCardNum"));
				idCardNum.clear();
				Thread.sleep(1000);
				idCardNum.sendKeys("05734287528");
				Thread.sleep(1000);
				
				WebElement dob = webDriver.findElement(By.id("dob"));
				dob.clear();
				Thread.sleep(1000);
				dob.sendKeys("06/06/1999");
				Thread.sleep(1000);
				
				WebElement address = webDriver.findElement(By.id("address"));
				address.clear();
				Thread.sleep(1000);
				address.sendKeys("Nguyễn Trãi, Hà Nội");
				Thread.sleep(1000);
				
				WebElement telephone = webDriver.findElement(By.id("telephone"));
				telephone.clear();
				Thread.sleep(1000);
				telephone.sendKeys("0164579895");
				Thread.sleep(1000);
				
				WebElement save = webDriver.findElement(By.id("saveCus"));
				save.click();
				
				WebDriverWait wait = new WebDriverWait(webDriver, 1);
				WebElement messageElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("message")));
				Thread.sleep(2000);
				String failure = messageElement.getText();
				String expected = "Cập nhật thất bại!";
				assertEquals(expected, failure);
				webDriver.close();
				
			} catch (Exception e) {
				System.out.println("Test failed!" + e.getMessage());
				webDriver.close();
			} 
		}
}
