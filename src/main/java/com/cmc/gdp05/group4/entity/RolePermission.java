package com.cmc.gdp05.group4.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;



class RolePermissionID implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name ="permission_id")
	private int permissionID;
	
	@Column(name ="role_id")
	private int roleID;
}
/**
 * @author haopham
 *
 */
@Entity
@Table(name="role_permission")
@IdClass(RolePermissionID.class)
public class RolePermission {
	
	
	@Id
	@Column(name ="permission_id")
	private int permissionID;
	
	@Id
	@Column(name ="role_id")
	private int roleID;

	public RolePermission(int permissionID, int roleID) {
		super();
		this.permissionID = permissionID;
		this.roleID = roleID;
	}

	public RolePermission() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getPermissionID() {
		return permissionID;
	}

	public void setPermissionID(int permissionID) {
		this.permissionID = permissionID;
	}

	public int getRoleID() {
		return roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}
	
	
	
}
