package com.cmc.gdp05.group4.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmc.gdp05.group4.entity.News;
import com.cmc.gdp05.group4.repository.NewsRepository;
import com.cmc.gdp05.group4.service.NewsService;

@Service("newsService")
public class NewsServiceImpl implements NewsService {

	@Autowired
	NewsRepository newsRepository;

	@Override
	public List<News> getAllNews() {
		return newsRepository.findAll();
	}

	@Override
	public News getOneNews(int idNews) {
		return newsRepository.getOne(idNews);
	}

	@Override
	public void saveOneNews(News news) {
		newsRepository.save(news);
	}

	@Override
	public void deleteOneNews(int id) {
		newsRepository.deleteById(id);

	}

	@Override
	public List<News> searchNews(String title) {
		return newsRepository.findByTitleContaining(title);
	}

}

