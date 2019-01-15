package com.cmc.gdp05.group4.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.cmc.gdp05.group4.common.Validator;
import com.cmc.gdp05.group4.common.UserConstant;
import com.cmc.gdp05.group4.entity.Account;
import com.cmc.gdp05.group4.entity.User;
import com.cmc.gdp05.group4.repository.UserDAO;

@Service
public class UserServiceImpl {
	@Autowired
	private UserDAO userDAO;

	public boolean login(Account account) {
		List<User> list = userDAO.findByEmailAndPassword(account.getUsername(), account.getPassword());
		return list.size() != 0;
	}

	public boolean insertUser(User user, Model model) {
		boolean success = true;
		if (user.getFullName().length() <= 0) {
			model.addAttribute("fullNameError", UserConstant.FULL_NAME_ERROR);
			success = false;
		}
		if (!Validator.validateEmail(user.getEmail()) || userDAO.findByEmail(user.getEmail()).size() > 0) {
			model.addAttribute("emailError", UserConstant.EMAIL_ERROR);
			success = false;
		}
		if (user.getPassword().length() <= 0) {
			model.addAttribute("passwordError", UserConstant.PASSWORD_ERROR);
			success = false;
		}
		
		if (user.getMobile().length() < 9 || user.getMobile().length() > 10) {
			model.addAttribute("mobileError", UserConstant.PHONE_ERROR);
			success = false;
		}
		if (success) {
			userDAO.save(user);
		}
		return success;
	}
}
