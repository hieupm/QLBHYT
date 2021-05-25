package seleniumtest;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TestCalculatePayment {
	
	@Test
	public void payment1() {
		WebDriver webDriver;
			System.setProperty("webdriver.chrome.driver", "C:/Eden/SQA/chromedriver/chromedriver.exe");
			webDriver = new ChromeDriver();
			try {
				webDriver.get("http://localhost:8080/demo_bhyt/Bhyt-new");
				Thread.sleep(1000);
				
				Select idCardNum = new Select(webDriver.findElement(By.id("idCardNum")));
				idCardNum.selectByValue("012913248");
				Thread.sleep(1000);
				
				WebElement startDate = webDriver.findElement(By.id("startDate"));
				startDate.sendKeys("06/24/2021");
				Thread.sleep(1000);
				
				WebElement endDate = webDriver.findElement(By.id("endDate"));
				endDate.sendKeys("06/24/2022");
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
				
				WebElement add = webDriver.findElement(By.id("addBH"));
				add.click();
				
				WebDriverWait wait = new WebDriverWait(webDriver, 5);
				WebElement messageElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("bhyt")));
				String success = messageElement.getText();
				String expected = "Thêm bảo hiểm vào danh sách hóa đơn thành công!";
				assertEquals(expected, success);
				Thread.sleep(1000);
				Select type = new Select(wait.until(ExpectedConditions.presenceOfElementLocated(By.id("type"))));
				type.selectByValue("Nhóm do người lao động và người sử dụng lao động đóng");
				Thread.sleep(1000);
				WebElement payment = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("pay-0")));
				String money = payment.getText();
				Thread.sleep(1000);
				assertEquals("1890000", money);
				WebElement delete = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("deleteBh?id=0")));
				delete.click();
				Thread.sleep(1000);
				webDriver.close();
			} catch (Exception e) {
				System.out.println("Test failed!" + e.getMessage());
				webDriver.close();
			} 
		}
	
	@Test
	public void payment2() {
		WebDriver webDriver;
			System.setProperty("webdriver.chrome.driver", "C:/Eden/SQA/chromedriver/chromedriver.exe");
			webDriver = new ChromeDriver();
			try {
				webDriver.get("http://localhost:8080/demo_bhyt/Bhyt-new");
				Thread.sleep(1000);
				
				Select idCardNum = new Select(webDriver.findElement(By.id("idCardNum")));
				idCardNum.selectByValue("085835743528");
				Thread.sleep(1000);
				
				WebElement startDate = webDriver.findElement(By.id("startDate"));
				startDate.sendKeys("06/24/2021");
				Thread.sleep(1000);
				
				WebElement endDate = webDriver.findElement(By.id("endDate"));
				endDate.sendKeys("06/24/2022");
				Thread.sleep(1000);
				
				WebElement supportLevel = webDriver.findElement(By.id("supportLevel"));
				supportLevel.sendKeys("0.4");
				Thread.sleep(1000);
				
				WebElement salary = webDriver.findElement(By.id("salary"));
				salary.clear();
				Thread.sleep(500);
				salary.sendKeys("11000000");
				Thread.sleep(1000);
				
				Select hospitalName = new Select(webDriver.findElement(By.id("hospitalName")));
				hospitalName.selectByValue("BV Bạch Mai");
				Thread.sleep(1000);
				
				WebElement add = webDriver.findElement(By.id("addBH"));
				add.click();
				
				WebDriverWait wait = new WebDriverWait(webDriver, 2);
				WebElement messageElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("bhyt")));
				String success = messageElement.getText();
				String expected = "Thêm bảo hiểm vào danh sách hóa đơn thành công!";
				assertEquals(expected, success);
				Thread.sleep(1000);
				Select type = new Select(wait.until(ExpectedConditions.presenceOfElementLocated(By.id("type"))));
				type.selectByValue("Nhóm do cơ quan bảo hiểm xã hội đóng");
				Thread.sleep(1000);
				WebElement payment = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("pay-0")));
				String money = payment.getText();
				Thread.sleep(1000);
				assertEquals("3564000", money);
				WebElement delete = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("deleteBh?id=0")));
				delete.click();
				Thread.sleep(1000);
				webDriver.close();
			} catch (Exception e) {
				System.out.println("Test failed!" + e.getMessage());
				webDriver.close();
			} 
		}
	
	@Test
	public void payment3() {
		WebDriver webDriver;
			System.setProperty("webdriver.chrome.driver", "C:/Eden/SQA/chromedriver/chromedriver.exe");
			webDriver = new ChromeDriver();
			try {
				webDriver.get("http://localhost:8080/demo_bhyt/Bhyt-new");
				Thread.sleep(1000);
				
				Select idCardNum = new Select(webDriver.findElement(By.id("idCardNum")));
				idCardNum.selectByValue("085835743528");
				Thread.sleep(1000);
				
				WebElement startDate = webDriver.findElement(By.id("startDate"));
				startDate.sendKeys("06/24/2021");
				Thread.sleep(1000);
				
				WebElement endDate = webDriver.findElement(By.id("endDate"));
				endDate.sendKeys("06/24/2022");
				Thread.sleep(1000);
				
				WebElement supportLevel = webDriver.findElement(By.id("supportLevel"));
				supportLevel.sendKeys("0.5");
				Thread.sleep(1000);
				
				WebElement salary = webDriver.findElement(By.id("salary"));
				salary.clear();
				Thread.sleep(500);
				salary.sendKeys("8000000");
				Thread.sleep(1000);
				
				Select hospitalName = new Select(webDriver.findElement(By.id("hospitalName")));
				hospitalName.selectByValue("BV Bạch Mai");
				Thread.sleep(1000);
				
				WebElement add = webDriver.findElement(By.id("addBH"));
				add.click();
				
				WebDriverWait wait = new WebDriverWait(webDriver, 2);
				WebElement messageElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("bhyt")));
				String success = messageElement.getText();
				String expected = "Thêm bảo hiểm vào danh sách hóa đơn thành công!";
				assertEquals(expected, success);
				Thread.sleep(1000);
				Select type = new Select(wait.until(ExpectedConditions.presenceOfElementLocated(By.id("type"))));
				type.selectByValue("Nhóm do người sử dụng lao động đóng");
				Thread.sleep(1000);
				WebElement payment = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("pay-0")));
				String money = payment.getText();
				Thread.sleep(1000);
				assertEquals("2160000", money);
				WebElement delete = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("deleteBh?id=0")));
				delete.click();
				Thread.sleep(1000);
				webDriver.close();
			} catch (Exception e) {
				System.out.println("Test failed!" + e.getMessage());
				webDriver.close();
			} 
		}
	
	@Test
	public void payment4() {
		WebDriver webDriver;
			System.setProperty("webdriver.chrome.driver", "C:/Eden/SQA/chromedriver/chromedriver.exe");
			webDriver = new ChromeDriver();
			try {
				webDriver.get("http://localhost:8080/demo_bhyt/Bhyt-new");
				Thread.sleep(1000);
				
				Select idCardNum = new Select(webDriver.findElement(By.id("idCardNum")));
				idCardNum.selectByValue("085835743528");
				Thread.sleep(1000);
				
				WebElement startDate = webDriver.findElement(By.id("startDate"));
				startDate.sendKeys("06/24/2021");
				Thread.sleep(1000);
				
				WebElement endDate = webDriver.findElement(By.id("endDate"));
				endDate.sendKeys("06/24/2022");
				Thread.sleep(1000);
				
				WebElement supportLevel = webDriver.findElement(By.id("supportLevel"));
				supportLevel.sendKeys("0.7");
				Thread.sleep(1000);
				
				WebElement salary = webDriver.findElement(By.id("salary"));
				salary.clear();
				Thread.sleep(500);
				salary.sendKeys("4400000");
				Thread.sleep(1000);
				
				Select hospitalName = new Select(webDriver.findElement(By.id("hospitalName")));
				hospitalName.selectByValue("BV Bạch Mai");
				Thread.sleep(1000);
				
				WebElement add = webDriver.findElement(By.id("addBH"));
				add.click();
				
				WebDriverWait wait = new WebDriverWait(webDriver, 2);
				WebElement messageElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("bhyt")));
				String success = messageElement.getText();
				String expected = "Thêm bảo hiểm vào danh sách hóa đơn thành công!";
				assertEquals(expected, success);
				Thread.sleep(1000);
				Select type = new Select(wait.until(ExpectedConditions.presenceOfElementLocated(By.id("type"))));
				type.selectByValue("Nhóm được ngân sách Nhà nước hỗ trợ mức đóng");
				Thread.sleep(1000);
				WebElement payment = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("pay-0")));
				String money = payment.getText();
				Thread.sleep(1000);
				assertEquals("712800", money);
				WebElement delete = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("deleteBh?id=0")));
				delete.click();
				Thread.sleep(1000);
				webDriver.close();
			} catch (Exception e) {
				System.out.println("Test failed!" + e.getMessage());
				webDriver.close();
			} 
		}
	
}
