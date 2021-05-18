package model;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tblBHYT")
public class BHYT2 {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, unique = false)
	private Date startDate;
	
	@Column(nullable = false, unique = false)
	private Date endDate;
	
	@Column(length = 64, nullable = false, unique = false)
	private float supportLevel;
	
	@Column(length = 64, nullable = false, unique = false)
	private int salary;
	

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="tblCustomerid", nullable = false)
	protected Customer customer;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="tblHospitalid", nullable = false)
	protected Hospital hospital;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="tblBillid", nullable = false)
	private Bill2 tblBillid;
	
	
	public BHYT2() {
		super();
	}
	
	
	public BHYT2(int id, Date startDate, Date endDate, float supportLevel, int salary, Customer customer,
			Hospital hospital, Bill2 tblBillid) {
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

	public BHYT2(Date startDate, Date endDate, float supportLevel, int salary, Customer customer, Hospital hospital,
			Bill2 tblBillid) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.supportLevel = supportLevel;
		this.salary = salary;
		this.customer = customer;
		this.hospital = hospital;
		this.tblBillid = tblBillid;
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

	public Bill2 getTblBillid() {
		return tblBillid;
	}

	public void setTblBillid(Bill2 tblBillid) {
		this.tblBillid = tblBillid;
	}

	@Override
	public String toString() {
		return "BHYT [id=" + id + ", startDate=" + startDate + ", endDate=" + endDate + ", supportLevel=" + supportLevel
				+ ", salary=" + salary + ", customer=" + customer + ", hospital=" + hospital + ", tblBillid="
				+ tblBillid + "]";
	}

	

	

	
	
}
