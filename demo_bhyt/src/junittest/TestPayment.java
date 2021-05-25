package junittest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import control.Payment;

public class TestPayment {
	@Test
	public void testPayment1() {
		Payment bhyt = new Payment();
	
		String type = "Nhóm do ngư�?i lao động và ngư�?i sử dụng lao động đóng";
		float supportLevel = (float) 0.3;
		int salary = 7500000;
		double payment = bhyt.pay(type, supportLevel, salary);
		assertEquals(2835000, payment);
	}
	
	@Test
	public void testPayment2() {
		Payment bhyt = new Payment();
		
		String type = "Nhóm do cơ quan bảo hiểm xã hội đóng";
		float supportLevel = (float) 0.3;
		int salary = 8000000;
		double payment = bhyt.pay(type, supportLevel, salary);
		assertEquals(3024000, payment);
	}
	
	@Test
	public void testPayment3() {
		Payment bhyt = new Payment();
		
		String type = "Nhóm được ngân sách Nhà nước hỗ trợ mức đóng";
		float supportLevel = (float) 0.5;
		int salary = 5000000;
		double payment = bhyt.pay(type, supportLevel, salary);
		assertEquals(1350000, payment);
	}
	
	@Test
	public void testPayment4() {
		Payment bhyt = new Payment();
		
		String type = "Nhóm do ngư�?i sử dụng lao động đóng";
		float supportLevel = (float) 0.3;
		int salary = 4000000;
		double payment = bhyt.pay(type, supportLevel, salary);
		assertEquals(1512000, payment);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
