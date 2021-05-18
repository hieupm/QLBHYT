package model;

import java.sql.Date;

public class BHYT {
	private int id;

	private Date startDate;
	private Date endDate;
	private float supportLevel;
	private int salary;
	protected Customer customer;
	protected Hospital hospital;
	private int tblBillid;
	
	
	public BHYT() {
		super();
	}

	public BHYT(int id, Date startDate, Date endDate, float supportLevel, int salary, Customer customer,
			Hospital hospital, int tblBillid) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.supportLevel = supportLevel;
		this.salary = salary;
		this.customer = customer;
		this.hospital = hospital;
		this.tblBillid = tblBillid;
	}
	public BHYT(Date startDate, Date endDate, float supportLevel, int salary, Customer customer,
			Hospital hospital, int tblBillid) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.supportLevel = supportLevel;
		this.salary = salary;
		this.customer = customer;
		this.hospital = hospital;
		this.tblBillid = tblBillid;
	}
	
	public BHYT(Date startDate, Date endDate, float supportLevel, int salary, Customer customer,
			Hospital hospital) {
		super();

		this.startDate = startDate;
		this.endDate = endDate;
		this.supportLevel = supportLevel;
		this.salary = salary;
		this.customer = customer;
		this.hospital = hospital;

	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public float getSupportLevel() {
		return supportLevel;
	}

	public void setSupportLevel(float supportLevel) {
		this.supportLevel = supportLevel;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	public int getTblBillid() {
		return tblBillid;
	}

	public void setTblBillid(int tblBillid) {
		this.tblBillid = tblBillid;
	}

	@Override
	public String toString() {
		return "BHYT [id=" + id + ", startDate=" + startDate + ", endDate=" + endDate + ", supportLevel=" + supportLevel
				+ ", salary=" + salary + ", customer=" + customer + ", hospital=" + hospital + ", tblBillid="
				+ tblBillid + "]";
	}

	

	

	
	
}
