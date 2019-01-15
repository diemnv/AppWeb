package com.cmc.gdp05.group4.service;

import java.util.List;

import com.cmc.gdp05.group4.entity.News;

public interface NewsService {
	List<News> getAllNews();

	News getOneNews(int idNews);

	void saveOneNews(News news);

	void deleteOneNews(int id);

	List<News> searchNews(String title);

}