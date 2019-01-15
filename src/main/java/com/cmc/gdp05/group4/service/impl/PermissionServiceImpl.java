package com.cmc.gdp05.group4.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmc.gdp05.group4.entity.Permission;
import com.cmc.gdp05.group4.repository.PermissionRepository;
import com.cmc.gdp05.group4.service.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService{

	@Autowired
	PermissionRepository permissionRepository ;
	@Override
	public List<Permission> getListAllPermission() {
		return permissionRepository.findAll();
	}

}
