package com.cmc.gdp05.group4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RoleController {
	@RequestMapping(value = "/role/list")
	public String list(Model model) {
		return "admin/roles/list";
	}
	
	@RequestMapping(value= "/role/create")
	public String create() {
		return "admin/roles/add" ;
	}
}
