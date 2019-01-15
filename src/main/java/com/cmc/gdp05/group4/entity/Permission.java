package com.cmc.gdp05.group4.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author haopham
 *
 */
@Entity
public class Permission {
	/**
	 * 
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="permission_id")
	private int id ;
	
	private String name;
	
	private String description;
	
	private String controller;
	
	private String func;
	
	public Permission() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Permission(int id, String name, String description, String controller, String func) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.controller = controller;
		this.func = func;
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
	public String getController() {
		return controller;
	}
	public void setController(String controller) {
		this.controller = controller;
	}
	public String getFunc() {
		return func;
	}
	public void setFunc(String func) {
		this.func = func;
	}
	

}
