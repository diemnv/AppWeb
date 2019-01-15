package com.cmc.gdp05.group4.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cmc.gdp05.group4.entity.RolePermission;

public interface RolePermissionRepository extends JpaRepository<RolePermission,Integer>{
	public List<RolePermission> findByroleID(int id);
}
