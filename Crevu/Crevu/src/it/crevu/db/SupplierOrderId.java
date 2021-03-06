package it.crevu.db;

// Generated 26-mar-2013 21.12.16 by Hibernate Tools 3.6.0

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * SupplierOrderId generated by hbm2java
 */
@Embeddable
public class SupplierOrderId implements java.io.Serializable {

	private int id;
	private int idOrderDeal;
	private int idWarehouse;
	private char status;
	private int tshirtNumber;
	private String attachmentName;
	private Date dateCreate;
	private Date dateChange;

	public SupplierOrderId() {
	}

	public SupplierOrderId(int id, int idOrderDeal, int idWarehouse,
			char status, int tshirtNumber, String attachmentName) {
		this.id = id;
		this.idOrderDeal = idOrderDeal;
		this.idWarehouse = idWarehouse;
		this.status = status;
		this.tshirtNumber = tshirtNumber;
		this.attachmentName = attachmentName;
	}

	public SupplierOrderId(int id, int idOrderDeal, int idWarehouse,
			char status, int tshirtNumber, String attachmentName,
			Date dateCreate, Date dateChange) {
		this.id = id;
		this.idOrderDeal = idOrderDeal;
		this.idWarehouse = idWarehouse;
		this.status = status;
		this.tshirtNumber = tshirtNumber;
		this.attachmentName = attachmentName;
		this.dateCreate = dateCreate;
		this.dateChange = dateChange;
	}

	@Column(name = "id", nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "id_order_deal", nullable = false)
	public int getIdOrderDeal() {
		return this.idOrderDeal;
	}

	public void setIdOrderDeal(int idOrderDeal) {
		this.idOrderDeal = idOrderDeal;
	}

	@Column(name = "id_warehouse", nullable = false)
	public int getIdWarehouse() {
		return this.idWarehouse;
	}

	public void setIdWarehouse(int idWarehouse) {
		this.idWarehouse = idWarehouse;
	}

	@Column(name = "status", nullable = false, length = 1)
	public char getStatus() {
		return this.status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	@Column(name = "tshirt_number", nullable = false)
	public int getTshirtNumber() {
		return this.tshirtNumber;
	}

	public void setTshirtNumber(int tshirtNumber) {
		this.tshirtNumber = tshirtNumber;
	}

	@Column(name = "attachment_name", nullable = false, length = 100)
	public String getAttachmentName() {
		return this.attachmentName;
	}

	public void setAttachmentName(String attachmentName) {
		this.attachmentName = attachmentName;
	}

	@Column(name = "date_create", length = 10)
	public Date getDateCreate() {
		return this.dateCreate;
	}

	public void setDateCreate(Date dateCreate) {
		this.dateCreate = dateCreate;
	}

	@Column(name = "date_change", length = 10)
	public Date getDateChange() {
		return this.dateChange;
	}

	public void setDateChange(Date dateChange) {
		this.dateChange = dateChange;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SupplierOrderId))
			return false;
		SupplierOrderId castOther = (SupplierOrderId) other;

		return (this.getId() == castOther.getId())
				&& (this.getIdOrderDeal() == castOther.getIdOrderDeal())
				&& (this.getIdWarehouse() == castOther.getIdWarehouse())
				&& (this.getStatus() == castOther.getStatus())
				&& (this.getTshirtNumber() == castOther.getTshirtNumber())
				&& ((this.getAttachmentName() == castOther.getAttachmentName()) || (this
						.getAttachmentName() != null
						&& castOther.getAttachmentName() != null && this
						.getAttachmentName().equals(
								castOther.getAttachmentName())))
				&& ((this.getDateCreate() == castOther.getDateCreate()) || (this
						.getDateCreate() != null
						&& castOther.getDateCreate() != null && this
						.getDateCreate().equals(castOther.getDateCreate())))
				&& ((this.getDateChange() == castOther.getDateChange()) || (this
						.getDateChange() != null
						&& castOther.getDateChange() != null && this
						.getDateChange().equals(castOther.getDateChange())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getId();
		result = 37 * result + this.getIdOrderDeal();
		result = 37 * result + this.getIdWarehouse();
		result = 37 * result + this.getStatus();
		result = 37 * result + this.getTshirtNumber();
		result = 37
				* result
				+ (getAttachmentName() == null ? 0 : this.getAttachmentName()
						.hashCode());
		result = 37
				* result
				+ (getDateCreate() == null ? 0 : this.getDateCreate()
						.hashCode());
		result = 37
				* result
				+ (getDateChange() == null ? 0 : this.getDateChange()
						.hashCode());
		return result;
	}

}
