package com.cmc.gdp05.group4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NewController {
	@RequestMapping(value = "/new/list")
	public String list(Model model) {
		return "admin/news/list";
	}
	
	@RequestMapping(value= "/new/create")
	public String create() {
		return "admin/news/add" ;
	}
}
