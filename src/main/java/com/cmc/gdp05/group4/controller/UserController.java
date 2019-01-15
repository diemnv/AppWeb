package com.cmc.gdp05.group4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cmc.gdp05.group4.entity.Account;
import com.cmc.gdp05.group4.entity.User;
import com.cmc.gdp05.group4.service.impl.UserServiceImpl;

@Controller
public class UserController {

	@Autowired
	private UserServiceImpl UserService;

	@RequestMapping(value = "/user/list")
	public String list(Model model) {
		return "admin/users/list";
	}

	@RequestMapping(value = "/user/create")
	public String create() {
		return "admin/users/add";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String viewLoginPage(Model model) {
		model.addAttribute("account", new Account());
		return "common/login";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String viewSignupPage(Model model) {
		model.addAttribute("user", new User());
		return "common/register";
	}

	@RequestMapping(value = "/manager", method = RequestMethod.GET)
	public String viewManagerPage() {
		return "admin/layouts/index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String actionLogin(Model model, @ModelAttribute Account account) {
		if (UserService.login(account)) {
			return "redirect:/manager";
		} else {
			model.addAttribute("loginError", true);
			model.addAttribute("user", account);
			return "common/login";
		}
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String actionRegister(Model model, @ModelAttribute User user, RedirectAttributes r) {
		System.out.println(user);
		boolean insertSuccess = UserService.insertUser(user, model);
		if (insertSuccess) {
			r.addFlashAttribute("userCreated", user.getFullName());
			return "redirect:/";
		} else {
			return "common/register";
		}
	}

}
