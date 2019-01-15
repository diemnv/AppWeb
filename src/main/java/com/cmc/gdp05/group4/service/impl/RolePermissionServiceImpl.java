package com.cmc.gdp05.group4.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.cmc.gdp05.group4.entity.RolePermission;
import com.cmc.gdp05.group4.repository.RolePermissionRepository;
import com.cmc.gdp05.group4.service.RolePermissionService;

public class RolePermissionServiceImpl implements RolePermissionService{
	
	@Autowired 
	private RolePermissionRepository rolePermissionRepository;
	
	@Override
	public boolean insert(RolePermission rolePermission) {
		boolean isSuccess = false;
		RolePermission permission = rolePermissionRepository.save(rolePermission);
		if(permission != null) {
			isSuccess = true;
		}
		return isSuccess;
	}

	@Override
	public boolean delete(RolePermission rolePermission) {
		// TODO Auto-generated method stub
		return false;
	}

}
