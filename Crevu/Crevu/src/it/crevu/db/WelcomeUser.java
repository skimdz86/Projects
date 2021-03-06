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
 * WelcomeUser generated by hbm2java
 */
@Entity
@Table(name = "welcome_user", catalog = "crevu")
public class WelcomeUser implements java.io.Serializable {

	private Integer id;
	private String nickname;
	private String email;
	private String message;
	private Date dateCreate;

	public WelcomeUser() {
	}

	public WelcomeUser(String nickname, String email, Date dateCreate) {
		this.nickname = nickname;
		this.email = email;
		this.dateCreate = dateCreate;
	}

	public WelcomeUser(String nickname, String email, String message,
			Date dateCreate) {
		this.nickname = nickname;
		this.email = email;
		this.message = message;
		this.dateCreate = dateCreate;
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

	@Column(name = "nickname", nullable = false, length = 100)
	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Column(name = "email", nullable = false, length = 100)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "message", length = 4000)
	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date_create", nullable = false, length = 10)
	public Date getDateCreate() {
		return this.dateCreate;
	}

	public void setDateCreate(Date dateCreate) {
		this.dateCreate = dateCreate;
	}

}
