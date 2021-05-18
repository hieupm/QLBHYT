package model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tblBill")
public class Bill2 {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 64, nullable = false, unique = false)
	private String type;
	
	@Column(nullable = false, unique = false)
	private Date paidDate;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="tblCustomerid", nullable = false)
	private Customer tblCustomerid;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="tblAssociationid", nullable = true)
	private Association tblAssociationid;


	public Bill2() {
		super();
	}

	public Bill2(int id, String type, Date paidDate, Customer tblCustomerid, Association tblAssociationid) {
		super();
		this.id = id;
		this.type = type;
		this.paidDate = paidDate;
		this.tblCustomerid = tblCustomerid;
		this.tblAssociationid = tblAssociationid;
	}
	
	
	
	public Bill2(String type, Date paidDate, Customer tblCustomerid, Association tblAssociationid) {
		super();
		this.type = type;
		this.paidDate = paidDate;
		this.tblCustomerid = tblCustomerid;
		this.tblAssociationid = tblAssociationid;
	}
	
	
	
	public Bill2(String type, Date paidDate, Customer tblCustomerid) {
		super();
		this.type = type;
		this.paidDate = paidDate;
		this.tblCustomerid = tblCustomerid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getPaidDate() {
		return paidDate;
	}

	public void setPaidDate(Date paidDate) {
		this.paidDate = paidDate;
	}

	public Customer getTblCustomerid() {
		return tblCustomerid;
	}

	public void setTblCustomerid(Customer tblCustomerid) {
		this.tblCustomerid = tblCustomerid;
	}

	public Association getTblAssociationid() {
		return tblAssociationid;
	}

	public void setTblAssociationid(Association tblAssociationid) {
		this.tblAssociationid = tblAssociationid;
	}

	@Override
	public String toString() {
		return "Bill [id=" + id + ", type=" + type + ", paidDate=" + paidDate + ", tblCustomerid=" + tblCustomerid
				+ ", tblAssociationid=" + tblAssociationid + "]";
	}
	
	
}
