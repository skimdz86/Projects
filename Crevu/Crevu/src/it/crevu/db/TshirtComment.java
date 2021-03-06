package it.crevu.db;

// Generated 20-apr-2013 15.10.16 by Hibernate Tools 3.6.0

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
 * TshirtComment generated by hbm2java
 */
@Entity
@Table(name = "tshirt_comment", catalog = "crevu")
public class TshirtComment implements java.io.Serializable {

	private Integer id;
	private int idTshirtProposal;
	private int author;
	private Date dateCreate;

	public TshirtComment() {
	}

	public TshirtComment(int idTshirtProposal, int author) {
		this.idTshirtProposal = idTshirtProposal;
		this.author = author;
	}

	public TshirtComment(int idTshirtProposal, int author, Date dateCreate) {
		this.idTshirtProposal = idTshirtProposal;
		this.author = author;
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

	@Column(name = "id_tshirt_proposal", nullable = false)
	public int getIdTshirtProposal() {
		return this.idTshirtProposal;
	}

	public void setIdTshirtProposal(int idTshirtProposal) {
		this.idTshirtProposal = idTshirtProposal;
	}

	@Column(name = "author", nullable = false)
	public int getAuthor() {
		return this.author;
	}

	public void setAuthor(int author) {
		this.author = author;
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
