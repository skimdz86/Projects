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
 * TextWish generated by hbm2java
 */
@Entity
@Table(name = "text_wish", catalog = "crevu")
public class TextWish implements java.io.Serializable {

	private Integer id;
	private int idUser;
	private int idText;
	private Date dateCreate;

	public TextWish() {
	}

	public TextWish(int idUser, int idText) {
		this.idUser = idUser;
		this.idText = idText;
	}

	public TextWish(int idUser, int idText, Date dateCreate) {
		this.idUser = idUser;
		this.idText = idText;
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

	@Column(name = "id_user", nullable = false)
	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	@Column(name = "id_text", nullable = false)
	public int getIdText() {
		return this.idText;
	}

	public void setIdText(int idText) {
		this.idText = idText;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date_create", length = 10)
	public Date getDateCreate() {
		return this.dateCreate;
	}

	public void setDateCreate(Date dateCreate) {
		this.dateCreate = dateCreate;
	}

}
