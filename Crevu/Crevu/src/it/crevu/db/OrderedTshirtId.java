package it.crevu.db;

// Generated 26-mar-2013 21.12.16 by Hibernate Tools 3.6.0

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * OrderedTshirtId generated by hbm2java
 */
@Embeddable
public class OrderedTshirtId implements java.io.Serializable {

	private int idOrderDeal;
	private int idSoldTshirt;
	private Date dateCreate;

	public OrderedTshirtId() {
	}

	public OrderedTshirtId(int idOrderDeal, int idSoldTshirt) {
		this.idOrderDeal = idOrderDeal;
		this.idSoldTshirt = idSoldTshirt;
	}

	public OrderedTshirtId(int idOrderDeal, int idSoldTshirt, Date dateCreate) {
		this.idOrderDeal = idOrderDeal;
		this.idSoldTshirt = idSoldTshirt;
		this.dateCreate = dateCreate;
	}

	@Column(name = "id_order_deal", nullable = false)
	public int getIdOrderDeal() {
		return this.idOrderDeal;
	}

	public void setIdOrderDeal(int idOrderDeal) {
		this.idOrderDeal = idOrderDeal;
	}

	@Column(name = "id_sold_tshirt", nullable = false)
	public int getIdSoldTshirt() {
		return this.idSoldTshirt;
	}

	public void setIdSoldTshirt(int idSoldTshirt) {
		this.idSoldTshirt = idSoldTshirt;
	}

	@Column(name = "date_create", length = 10)
	public Date getDateCreate() {
		return this.dateCreate;
	}

	public void setDateCreate(Date dateCreate) {
		this.dateCreate = dateCreate;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof OrderedTshirtId))
			return false;
		OrderedTshirtId castOther = (OrderedTshirtId) other;

		return (this.getIdOrderDeal() == castOther.getIdOrderDeal())
				&& (this.getIdSoldTshirt() == castOther.getIdSoldTshirt())
				&& ((this.getDateCreate() == castOther.getDateCreate()) || (this
						.getDateCreate() != null
						&& castOther.getDateCreate() != null && this
						.getDateCreate().equals(castOther.getDateCreate())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getIdOrderDeal();
		result = 37 * result + this.getIdSoldTshirt();
		result = 37
				* result
				+ (getDateCreate() == null ? 0 : this.getDateCreate()
						.hashCode());
		return result;
	}

}
