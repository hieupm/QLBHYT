package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tblAssociation")
public class Association {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 64, nullable = true, unique = false)
	private String name;
	
	@Column(length = 64, nullable = true, unique = false)
	private String address;
	
	@Column(length = 64, nullable = true, unique = false)
	private String telephone;
	public Association() {
		super();
	}
	
	public Association(int id, String name, String address, String telephone) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.telephone = telephone;
	}
	
	public Association( String name, String address, String telephone) {
		super();

		this.name = name;
		this.address = address;
		this.telephone = telephone;
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
		return "Association [id=" + id + ", name=" + name + ", address=" + address + ", telephone=" + telephone + "]";
	}

	
	
	
}
