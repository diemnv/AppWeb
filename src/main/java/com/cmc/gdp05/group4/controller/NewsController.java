package com.cmc.gdp05.group4.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cmc.gdp05.group4.entity.News;
import com.cmc.gdp05.group4.service.NewsService;

@Controller
public class NewsController {

	@Autowired
	NewsService newsService;

	/**
	 * @return
	 */
	@GetMapping({ "/news" })
	public ModelAndView news() {
		ModelAndView mvn = new ModelAndView();
		List<News> listNews = new ArrayList<>();
		listNews = newsService.getAllNews();
		mvn.addObject("listNews", listNews);
		mvn.setViewName("news");
		return mvn;
	}

	@GetMapping("/addnews")
	public String addNews(News news) {
		return "addnews";
	}

	@PostMapping("/save")
	public String saveNews(News news) {
		System.err.println("==============================================");
//		news.setIdUser(1);
//		news.setIdApprover(1);
		newsService.saveOneNews(news);
		return "redirect:/news";
	}

	@GetMapping("/news/delete/{id}")
	public String deleteOneNews(@PathVariable int id) {
		newsService.deleteOneNews(id);
		return "redirect:/news";
	}

	@GetMapping("/news/edit/{id}")
	public String editOneNews(@PathVariable int id, Model model) {
		model.addAttribute("news", newsService.getOneNews(id));
		return "addnews";
	}

	@PostMapping(value = "/search")
	public String search(@RequestParam("keyword") String keyword, Model model) {
		if ("".equals(keyword)) {
			return "redirect:/news";
		}
		System.err.println(newsService.searchNews(keyword).size());
		model.addAttribute("listNews", newsService.searchNews(keyword));
		return "news";
	}

}