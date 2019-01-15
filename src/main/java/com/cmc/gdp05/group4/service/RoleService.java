package com.cmc.gdp05.group4.service;

import java.util.List;

import com.cmc.gdp05.group4.entity.Role;

public interface RoleService {
	
	/**
	* Create by: haopham - CMC
	* Create date: Jan 13, 2019
	* Modifier: haopham
	* Modified date: Jan 13, 2019
	* Description: ....
	* Version 1.0
	* @return
	*/
	public List<Role> findAll();
	
	/**
	* Create by: haopham - CMC
	* Create date: Jan 13, 2019
	* Modifier: haopham
	* Modified date: Jan 13, 2019
	* Description: ....
	* Version 1.0
	* @param role
	* @return
	*/
	public boolean insert(Role role);
	
	
	/**
	* Create by: haopham - CMC
	* Create date: Jan 13, 2019
	* Modifier: haopham
	* Modified date: Jan 13, 2019
	* Description: ....
	* Version 1.0
	* @param role
	* @return
	*/
	public boolean update(Role role);
	
	
	/**
	* Create by: haopham - CMC
	* Create date: Jan 13, 2019
	* Modifier: haopham
	* Modified date: Jan 13, 2019
	* Description: ....
	* Version 1.0
	* @param roleID
	* @return
	*/
	public boolean delete(int roleID);
	
	public Role getByCode(int id);
}
