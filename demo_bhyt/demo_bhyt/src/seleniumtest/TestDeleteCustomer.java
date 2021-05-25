package seleniumtest;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dao.CustomerDAO;

public class TestDeleteCustomer {
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
	public void deleteCustomer1() {
		WebDriver webDriver;
			System.setProperty("webdriver.chrome.driver", "C:/Eden/SQA/chromedriver/chromedriver.exe");
			webDriver = new ChromeDriver();
			try {
				webDriver.get("http://localhost:8080/demo_bhyt/Customer-list");
				Thread.sleep(3000);
				WebElement edit = webDriver.findElement(By.id("delete?id=10"));
				edit.click();
				
				
				WebDriverWait wait = new WebDriverWait(webDriver, 1);
				WebElement messageElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("message")));
				Thread.sleep(2000);
				String success = messageElement.getText();
				String expected = "Xóa thành công!";
				assertEquals(success, expected);
				webDriver.close();
				
			} catch (Exception e) {
				System.out.println("Test failed!" + e.getMessage());
				webDriver.close();
			} 
		}
}
