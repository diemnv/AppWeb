package com.cmc.gdp05.group4.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cmc.gdp05.group4.entity.Role;

public interface RoleRepository extends JpaRepository<Role,Integer>{
	public List<Role> findByName(String name);
	public List<Role> findByIdNotAndName(int id,String name);
}
