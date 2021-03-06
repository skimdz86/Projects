package it.crevu.db;

// Generated 26-mar-2013 21.12.16 by Hibernate Tools 3.6.0

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * SoldTshirt generated by hbm2java
 */
@Entity
@Table(name = "sold_tshirt", catalog = "crevu", uniqueConstraints = @UniqueConstraint(columnNames = {
		"id", "date_create" }))
public class SoldTshirt implements java.io.Serializable {

	private SoldTshirtId id;

	public SoldTshirt() {
	}

	public SoldTshirt(SoldTshirtId id) {
		this.id = id;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "id", column = @Column(name = "id", nullable = false)),
			@AttributeOverride(name = "idBuyer", column = @Column(name = "id_buyer", nullable = false)),
			@AttributeOverride(name = "idSeller", column = @Column(name = "id_seller", nullable = false)),
			@AttributeOverride(name = "idTshirtProposal", column = @Column(name = "id_tshirt_proposal", nullable = false)),
			@AttributeOverride(name = "dateCreate", column = @Column(name = "date_create", length = 10)) })
	public SoldTshirtId getId() {
		return this.id;
	}

	public void setId(SoldTshirtId id) {
		this.id = id;
	}

}
