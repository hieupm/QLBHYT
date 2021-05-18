package model;

import java.sql.Date;

public class Bill {
	private int id;
	private String type;
	private Date paidDate;
	private int tblCustomerid;
	private int tblAssociationid;


	public Bill() {
		super();
	}

	public Bill(int id, String type, Date paidDate, int tblCustomerid, int tblAssociationid) {
		super();
		this.id = id;
		this.type = type;
		this.paidDate = paidDate;
		this.tblCustomerid = tblCustomerid;
		this.tblAssociationid = tblAssociationid;
	}
	
	
	
	public Bill(String type, Date paidDate, int tblCustomerid, int tblAssociationid) {
		super();
		this.type = type;
		this.paidDate = paidDate;
		this.tblCustomerid = tblCustomerid;
		this.tblAssociationid = tblAssociationid;
	}
	
	
	
	public Bill(String type, Date paidDate, int tblCustomerid) {
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

	public int getTblCustomerid() {
		return tblCustomerid;
	}

	public void setTblCustomerid(int tblCustomerid) {
		this.tblCustomerid = tblCustomerid;
	}

	public int getTblAssociationid() {
		return tblAssociationid;
	}

	public void setTblAssociationid(int tblAssociationid) {
		this.tblAssociationid = tblAssociationid;
	}

	@Override
	public String toString() {
		return "Bill [id=" + id + ", type=" + type + ", paidDate=" + paidDate + ", tblCustomerid=" + tblCustomerid
				+ ", tblAssociationid=" + tblAssociationid + "]";
	}
	
	
}
