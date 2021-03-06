package it.crevu.db;

// Generated 20-apr-2013 15.10.16 by Hibernate Tools 3.6.0

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TshirtProposalId generated by hbm2java
 */
@Embeddable
public class TshirtProposalId implements java.io.Serializable {

	private int id;
	private int idUser;
	private int idText;
	private String name;
	private String color;
	private Float price;
	private boolean approved;
	private int votes;
	private int likes;
	private int retweets;
	private String brand;
	private boolean active;
	private Date dateCreate;
	private Date dateChange;
	private Integer personalRank;

	public TshirtProposalId() {
	}

	public TshirtProposalId(int id, int idUser, int idText, boolean approved,
			int votes, int likes, int retweets, boolean active) {
		this.id = id;
		this.idUser = idUser;
		this.idText = idText;
		this.approved = approved;
		this.votes = votes;
		this.likes = likes;
		this.retweets = retweets;
		this.active = active;
	}

	public TshirtProposalId(int id, int idUser, int idText, String name,
			String color, Float price, boolean approved, int votes, int likes,
			int retweets, String brand, boolean active, Date dateCreate,
			Date dateChange, Integer personalRank) {
		this.id = id;
		this.idUser = idUser;
		this.idText = idText;
		this.name = name;
		this.color = color;
		this.price = price;
		this.approved = approved;
		this.votes = votes;
		this.likes = likes;
		this.retweets = retweets;
		this.brand = brand;
		this.active = active;
		this.dateCreate = dateCreate;
		this.dateChange = dateChange;
		this.personalRank = personalRank;
	}

	@Column(name = "id", nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
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

	@Column(name = "name", length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "color", length = 100)
	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Column(name = "price", precision = 12, scale = 0)
	public Float getPrice() {
		return this.price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	@Column(name = "approved", nullable = false)
	public boolean isApproved() {
		return this.approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	@Column(name = "votes", nullable = false)
	public int getVotes() {
		return this.votes;
	}

	public void setVotes(int votes) {
		this.votes = votes;
	}

	@Column(name = "likes", nullable = false)
	public int getLikes() {
		return this.likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	@Column(name = "retweets", nullable = false)
	public int getRetweets() {
		return this.retweets;
	}

	public void setRetweets(int retweets) {
		this.retweets = retweets;
	}

	@Column(name = "brand", length = 100)
	public String getBrand() {
		return this.brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Column(name = "active", nullable = false)
	public boolean isActive() {
		return this.active;
	}

	public void setActive(boolean active) {
		this.active = active;
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

	@Column(name = "personal_rank")
	public Integer getPersonalRank() {
		return this.personalRank;
	}

	public void setPersonalRank(Integer personalRank) {
		this.personalRank = personalRank;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TshirtProposalId))
			return false;
		TshirtProposalId castOther = (TshirtProposalId) other;

		return (this.getId() == castOther.getId())
				&& (this.getIdUser() == castOther.getIdUser())
				&& (this.getIdText() == castOther.getIdText())
				&& ((this.getName() == castOther.getName()) || (this.getName() != null
						&& castOther.getName() != null && this.getName()
						.equals(castOther.getName())))
				&& ((this.getColor() == castOther.getColor()) || (this
						.getColor() != null && castOther.getColor() != null && this
						.getColor().equals(castOther.getColor())))
				&& ((this.getPrice() == castOther.getPrice()) || (this
						.getPrice() != null && castOther.getPrice() != null && this
						.getPrice().equals(castOther.getPrice())))
				&& (this.isApproved() == castOther.isApproved())
				&& (this.getVotes() == castOther.getVotes())
				&& (this.getLikes() == castOther.getLikes())
				&& (this.getRetweets() == castOther.getRetweets())
				&& ((this.getBrand() == castOther.getBrand()) || (this
						.getBrand() != null && castOther.getBrand() != null && this
						.getBrand().equals(castOther.getBrand())))
				&& (this.isActive() == castOther.isActive())
				&& ((this.getDateCreate() == castOther.getDateCreate()) || (this
						.getDateCreate() != null
						&& castOther.getDateCreate() != null && this
						.getDateCreate().equals(castOther.getDateCreate())))
				&& ((this.getDateChange() == castOther.getDateChange()) || (this
						.getDateChange() != null
						&& castOther.getDateChange() != null && this
						.getDateChange().equals(castOther.getDateChange())))
				&& ((this.getPersonalRank() == castOther.getPersonalRank()) || (this
						.getPersonalRank() != null
						&& castOther.getPersonalRank() != null && this
						.getPersonalRank().equals(castOther.getPersonalRank())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getId();
		result = 37 * result + this.getIdUser();
		result = 37 * result + this.getIdText();
		result = 37 * result
				+ (getName() == null ? 0 : this.getName().hashCode());
		result = 37 * result
				+ (getColor() == null ? 0 : this.getColor().hashCode());
		result = 37 * result
				+ (getPrice() == null ? 0 : this.getPrice().hashCode());
		result = 37 * result + (this.isApproved() ? 1 : 0);
		result = 37 * result + this.getVotes();
		result = 37 * result + this.getLikes();
		result = 37 * result + this.getRetweets();
		result = 37 * result
				+ (getBrand() == null ? 0 : this.getBrand().hashCode());
		result = 37 * result + (this.isActive() ? 1 : 0);
		result = 37
				* result
				+ (getDateCreate() == null ? 0 : this.getDateCreate()
						.hashCode());
		result = 37
				* result
				+ (getDateChange() == null ? 0 : this.getDateChange()
						.hashCode());
		result = 37
				* result
				+ (getPersonalRank() == null ? 0 : this.getPersonalRank()
						.hashCode());
		return result;
	}

}
