package it.crevu.db;

// Generated 25-mag-2013 12.09.11 by Hibernate Tools 3.6.0

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * User generated by hbm2java
 */
@Entity
@Table(name = "user", catalog = "crevu", uniqueConstraints = {
		@UniqueConstraint(columnNames = "email"),
		@UniqueConstraint(columnNames = "username") })
public class User implements java.io.Serializable {

	private Integer id;
	private String username;
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private Character gender;
	private Date birthDate;
	private String city;
	private String nationality;
	private String fiscalCode;
	private boolean isCompany;
	private String userType;
	private String birdLevel;
	private String userLevel;
	private Date dateCreate;
	private Date dateChange;
	private String cookieSecret;

	public User() {
	}

	public User(String username, String email, String password,
			String nationality, boolean isCompany, String userType,
			String birdLevel, String userLevel) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.nationality = nationality;
		this.isCompany = isCompany;
		this.userType = userType;
		this.birdLevel = birdLevel;
		this.userLevel = userLevel;
	}

	public User(String username, String email, String password,
			String firstName, String lastName, Character gender,
			Date birthDate, String city, String nationality, String fiscalCode,
			boolean isCompany, String userType, String birdLevel,
			String userLevel, Date dateCreate, Date dateChange,
			String cookieSecret) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.birthDate = birthDate;
		this.city = city;
		this.nationality = nationality;
		this.fiscalCode = fiscalCode;
		this.isCompany = isCompany;
		this.userType = userType;
		this.birdLevel = birdLevel;
		this.userLevel = userLevel;
		this.dateCreate = dateCreate;
		this.dateChange = dateChange;
		this.cookieSecret = cookieSecret;
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

	@Column(name = "username", unique = true, nullable = false, length = 100)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "email", unique = true, nullable = false, length = 100)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "password", nullable = false, length = 256)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "first_name", length = 100)
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "last_name", length = 100)
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "gender", length = 1)
	public Character getGender() {
		return this.gender;
	}

	public void setGender(Character gender) {
		this.gender = gender;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "birth_date", length = 10)
	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Column(name = "city", length = 200)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "nationality", nullable = false, length = 50)
	public String getNationality() {
		return this.nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	@Column(name = "fiscal_code", length = 100)
	public String getFiscalCode() {
		return this.fiscalCode;
	}

	public void setFiscalCode(String fiscalCode) {
		this.fiscalCode = fiscalCode;
	}

	@Column(name = "is_company", nullable = false)
	public boolean isIsCompany() {
		return this.isCompany;
	}

	public void setIsCompany(boolean isCompany) {
		this.isCompany = isCompany;
	}

	@Column(name = "user_type", nullable = false, length = 30)
	public String getUserType() {
		return this.userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Column(name = "bird_level", nullable = false, length = 50)
	public String getBirdLevel() {
		return this.birdLevel;
	}

	public void setBirdLevel(String birdLevel) {
		this.birdLevel = birdLevel;
	}

	@Column(name = "user_level", nullable = false, length = 50)
	public String getUserLevel() {
		return this.userLevel;
	}

	public void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
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

	@Column(name = "cookie_secret", length = 256)
	public String getCookieSecret() {
		return this.cookieSecret;
	}

	public void setCookieSecret(String cookieSecret) {
		this.cookieSecret = cookieSecret;
	}

}
