package com.cmc.gdp05.group4.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "news")
public class News {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "news_id")
	private int idNews;

	@Column(name = "url")
	private String url;

	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;

	@Column(name = "content")
	private String content;

	@Column(name = "status", length = 1)
	private int status;

	@Column(name = "is_hot")
	private String isHot;

	@Column(name = "user_id")
	private int idUser;

	@Column(name = "approver_id")
	private int idApprover;

	@CreationTimestamp
	@Column(name = "created_at", updatable = false)
	private Date createdAt;

	@UpdateTimestamp
	@Column(name = "updated_at")
	private Date updatedAt;

	@Column(name = "approved_at")
	private String approvedAt;

	public News() {
		super();
	}

	public News(String url, String title) {
		super();
		this.url = url;
		this.title = title;
	}

	public News(int idNews, String url, String title, String description, String content, int status, String isHot,
			int idUser, int idApprover, Date createdAt, Date updatedAt, String approvedAt) {
		super();
		this.idNews = idNews;
		this.url = url;
		this.title = title;
		this.description = description;
		this.content = content;
		this.status = status;
		this.isHot = isHot;
		this.idUser = idUser;
		this.idApprover = idApprover;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.approvedAt = approvedAt;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getIdNews() {
		return idNews;
	}

	public void setIdNews(int idNews) {
		this.idNews = idNews;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getIsHot() {
		return isHot;
	}

	public void setIsHot(String isHot) {
		this.isHot = isHot;
	}

	public int getIdApprover() {
		return idApprover;
	}

	public void setIdApprover(int idApprover) {
		this.idApprover = idApprover;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getApprovedAt() {
		return approvedAt;
	}

	public void setApprovedAt(String approvedAt) {
		this.approvedAt = approvedAt;
	}

	@Override
	public String toString() {
		return idUser + " - " + url + " - " + title + " - " + description;
	}

}
