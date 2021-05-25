package control;

public class Payment{
	
	public double pay(String type, float supportLevel, int salary) {
		double payment = 0;
		if(type == "Nhóm do người lao động và người sử dụng lao động đóng" ||
				   type == "Nhóm do cơ quan bảo hiểm xã hội đóng" ||
				   type == "Nhóm được ngân sách Nhà nước hỗ trợ mức đóng" ||
				   type == "Nhóm do người sử dụng lao động đóng") {
					payment = salary*0.045*(1-supportLevel)*12;

		} 
		return Math.round(payment);
	}
	
	
}
