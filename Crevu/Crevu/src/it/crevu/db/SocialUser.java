package it.crevu.db;

// Generated 1-apr-2013 14.32.17 by Hibernate Tools 3.6.0

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * SocialUser generated by hbm2java, but modified by mdz
 */
@Entity
@Table(name = "userconnection", catalog = "crevu", uniqueConstraints = @UniqueConstraint(columnNames = {
		"userId", "providerId", "rank" }))
public class SocialUser implements java.io.Serializable {

	private SocialUserId id;
	private int rank;
	private String displayName;
	private String profileUrl;
	private String imageUrl;
	private String accessToken;
	private String secret;
	private String refreshToken;
	private Long expireTime;

	public SocialUser() {
	}

	public SocialUser(SocialUserId id, int rank, String accessToken) {
		this.id = id;
		this.rank = rank;
		this.accessToken = accessToken;
	}

	public SocialUser(SocialUserId id, int rank, String displayName,
			String profileUrl, String imageUrl, String accessToken,
			String secret, String refreshToken, Long expireTime) {
		this.id = id;
		this.rank = rank;
		this.displayName = displayName;
		this.profileUrl = profileUrl;
		this.imageUrl = imageUrl;
		this.accessToken = accessToken;
		this.secret = secret;
		this.refreshToken = refreshToken;
		this.expireTime = expireTime;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "userId", column = @Column(name = "userId", nullable = false)),
			@AttributeOverride(name = "providerId", column = @Column(name = "providerId", nullable = false)),
			@AttributeOverride(name = "providerUserId", column = @Column(name = "providerUserId", nullable = false)) })
	public SocialUserId getId() {
		return this.id;
	}

	public void setId(SocialUserId id) {
		this.id = id;
	}

	@Column(name = "rank", nullable = false)
	public int getRank() {
		return this.rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Column(name = "displayName")
	public String getDisplayName() {
		return this.displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	@Column(name = "profileUrl", length = 512)
	public String getProfileUrl() {
		return this.profileUrl;
	}

	public void setProfileUrl(String profileUrl) {
		this.profileUrl = profileUrl;
	}

	@Column(name = "imageUrl", length = 512)
	public String getImageUrl() {
		return this.imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Column(name = "accessToken", nullable = false)
	public String getAccessToken() {
		return this.accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	@Column(name = "secret")
	public String getSecret() {
		return this.secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	@Column(name = "refreshToken")
	public String getRefreshToken() {
		return this.refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	@Column(name = "expireTime")
	public Long getExpireTime() {
		return this.expireTime;
	}

	public void setExpireTime(Long expireTime) {
		this.expireTime = expireTime;
	}

}
