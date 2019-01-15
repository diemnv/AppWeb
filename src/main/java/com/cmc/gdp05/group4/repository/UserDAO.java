package com.cmc.gdp05.group4.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cmc.gdp05.group4.entity.User;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {
	public List<User> findByEmailAndPassword(String email, String password);
	public List<User> findByEmail(String email);
}
