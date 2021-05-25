package model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tblCustomer")
public class Customer {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 64, nullable = false, unique = false)
	private String name;
	
	@Column(length = 64, nullable = false, unique = true)
	private String idCardNum;
	
	@Column(nullable = false, unique = false)
	private Date dob;
	
	@Column(length = 64, nullable = false, unique = false)
	private String address;
	
	@Column(length = 64, nullable = false, unique = false)
	private String telephone;
	
	public Customer() {
		super();
	}

	
	public Customer(int id, String name, String idCardNum, Date dob, String address, String telephone) {
		super();
		this.id = id;
		this.name = name;
		this.idCardNum = idCardNum;
		this.dob = dob;
		this.address = address;
		this.telephone = telephone;
	}

	public Customer(String name, String idCardNum, Date dob, String address, String telephone) {
		super();
		this.name = name;
		this.idCardNum = idCardNum;
		this.dob = dob;
		this.address = address;
		this.telephone = telephone;
	}

	
	
	public Customer(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}


	public Customer(String idCardNum) {
		super();
		this.idCardNum = idCardNum;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdCardNum() {
		return idCardNum;
	}

	public void setIdCardNum(String idCardNum) {
		this.idCardNum = idCardNum;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", idCardNum=" + idCardNum + ", dob=" + dob + ", address="
				+ address + ", telephone=" + telephone + "]";
	}

	
	
	
}

