package com.cmc.gdp05.group4.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.*;
@Entity
public class Role implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="role_id")
	private int id ;
	private String name;
	private String description;
	
	@ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            })
	 @JoinTable(name = "role_permission",
	            joinColumns = { @JoinColumn(name = "role_id") },
	            inverseJoinColumns = { @JoinColumn(name = "permission_id") })
	private List<Permission> permission = new ArrayList<Permission>();
	
	public List<Permission> getPermission() {
		return permission;
	}
	public void setPermission(List<Permission> permission) {
		this.permission = permission;
	}
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Role(int id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
