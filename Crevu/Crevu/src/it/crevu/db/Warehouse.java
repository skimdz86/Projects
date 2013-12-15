package it.crevu.db;

// Generated 26-mar-2013 21.12.16 by Hibernate Tools 3.6.0

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Warehouse generated by hbm2java
 */
@Entity
@Table(name = "warehouse", catalog = "crevu")
public class Warehouse implements java.io.Serializable {

	private Integer id;
	private String name;
	private String place;
	private String description;
	private String email;
	private String address;
	private String phoneNumberOne;
	private String phoneNumberTwo;
	private Date dateCreate;
	private Date dateChange;

	public Warehouse() {
	}

	public Warehouse(String name, String place, String description,
			String email, String address, String phoneNumberOne) {
		this.name = name;
		this.place = place;
		this.description = description;
		this.email = email;
		this.address = address;
		this.phoneNumberOne = phoneNumberOne;
	}

	public Warehouse(String name, String place, String description,
			String email, String address, String phoneNumberOne,
			String phoneNumberTwo, Date dateCreate, Date dateChange) {
		this.name = name;
		this.place = place;
		this.description = description;
		this.email = email;
		this.address = address;
		this.phoneNumberOne = phoneNumberOne;
		this.phoneNumberTwo = phoneNumberTwo;
		this.dateCreate = dateCreate;
		this.dateChange = dateChange;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name", nullable = false, length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "place", nullable = false, length = 200)
	public String getPlace() {
		return this.place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	@Column(name = "description", nullable = false, length = 500)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "email", nullable = false, length = 100)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "address", nullable = false, length = 200)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "phone_number_one", nullable = false, length = 100)
	public String getPhoneNumberOne() {
		return this.phoneNumberOne;
	}

	public void setPhoneNumberOne(String phoneNumberOne) {
		this.phoneNumberOne = phoneNumberOne;
	}

	@Column(name = "phone_number_two", length = 100)
	public String getPhoneNumberTwo() {
		return this.phoneNumberTwo;
	}

	public void setPhoneNumberTwo(String phoneNumberTwo) {
		this.phoneNumberTwo = phoneNumberTwo;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date_create", length = 10)
	public Date getDateCreate() {
		return this.dateCreate;
	}

	public void setDateCreate(Date dateCreate) {
		this.dateCreate = dateCreate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date_change", length = 10)
	public Date getDateChange() {
		return this.dateChange;
	}

	public void setDateChange(Date dateChange) {
		this.dateChange = dateChange;
	}

}
