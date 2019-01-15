package com.cmc.gdp05.group4.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cmc.gdp05.group4.entity.News;

@Repository("newsRepository")
public interface NewsRepository extends JpaRepository<News, Integer> {

	List<News> findByTitleContaining(String q);
}
