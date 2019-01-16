package com.cmc.gdp05.group4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cmc.gdp05.group4.entity.News;
import com.cmc.gdp05.group4.service.NewsService;

@Controller
public class NewsController {

	@Autowired
	NewsService newsService;

	@GetMapping({ "/manager/news/list" })
	public String listNews(Model model) {
		model.addAttribute("listNews", newsService.getAllNews());
		return "admin/news/list";
	}

	@GetMapping("/manager/news/add")
	public String addNews(News news) {
		return "admin/news/add";
	}

	@PostMapping("/save")
	public String saveNews(News news) {
//		news.setIdUser(1);
//		news.setIdApprover(1);
		newsService.saveOneNews(news);
		return "redirect:/manager/news/list";
	}

	@GetMapping("/news/delete/{id}")
	public String deleteOneNews(@PathVariable int id) {
		newsService.deleteOneNews(id);
		return "redirect:/manager/news/list";
	}

	@GetMapping("/news/edit/{id}")
	public String editOneNews(@PathVariable int id, Model model) {
		model.addAttribute("news", newsService.getOneNews(id));
		return "admin/news/add";
	}

	@PostMapping(value = "/search")
	public String search(@RequestParam("keyword") String keyword, Model model) {
		System.err.println(newsService.searchNews(keyword).size());
		model.addAttribute("listNews", newsService.searchNews(keyword));
		return "admin/news/list";
	}

}