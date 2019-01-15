package com.cmc.gdp05.group4.service.impl;

import java.util.List;

import org.hibernate.engine.internal.MutableEntityEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmc.gdp05.group4.entity.Role;
import com.cmc.gdp05.group4.entity.RolePermission;
import com.cmc.gdp05.group4.repository.RolePermissionRepository;
import com.cmc.gdp05.group4.repository.RoleRepository;
import com.cmc.gdp05.group4.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private RolePermissionRepository rolePermissionRepository;

	@Override
	public List<Role> findAll() {
		return roleRepository.findAll();
	}

	@Override
	public boolean insert(Role role) {
		boolean isSuccess = false;
		Role role_query = roleRepository.save(role);
		if (role_query != null) {
			isSuccess = true;
		}
		return isSuccess;
	}

	@Override
	public boolean update(Role role) {
		boolean isSuccess = false;
		Role role_query = roleRepository.save(role);
		if (role_query != null) {
			isSuccess = true;
		}
		return isSuccess;
	}

	@Override
	public boolean delete(int roleID) {
		boolean isSuccess = false;
		try {
			Role role = roleRepository.getOne(roleID);
			roleRepository.delete(role);
			isSuccess = true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return isSuccess;
	}

	public boolean insertRole(Role role, List<RolePermission> rolePermissions) {
		boolean isSuccess = false;
			try {
				Role r = roleRepository.save(role);
				if (rolePermissions != null) {
					for(RolePermission rolePer : rolePermissions) {
						rolePer.setRoleID(r.getId());
					}
					rolePermissionRepository.saveAll(rolePermissions);
					
				}
				
				isSuccess = true;
			} catch (Exception e) {
				// TODO: handle exception
			}
		
		return isSuccess ;
	}

	@Override
	public Role getByCode(int id) {
		return roleRepository.getOne(id);
	}

	public boolean updateRole(Role role, List<RolePermission> rolePermissions) {
		boolean isSuccess = false;
			try {
				Role r = roleRepository.save(role);
				List<RolePermission> listRolePermiss = rolePermissionRepository.findByroleID(r.getId());
				rolePermissionRepository.deleteAll(listRolePermiss);
				if (rolePermissions != null) {
					for(RolePermission rolePer : rolePermissions) {
						rolePer.setRoleID(r.getId());
					}
					rolePermissionRepository.saveAll(rolePermissions);
					
				}
				
				isSuccess = true;
			} catch (Exception e) {
				// TODO: handle exception
			}
		
		return isSuccess ;
	}
	
	public boolean deleteRole(int roleID) {
		boolean isSuccess = false;
		try {
			List<RolePermission> listRolePermiss = rolePermissionRepository.findByroleID(roleID);
			rolePermissionRepository.deleteAll(listRolePermiss);
			Role role = roleRepository.getOne(roleID);
			roleRepository.delete(role);
			isSuccess = true ;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return isSuccess;
	}
}
