package com.SpringJDBC.NewsDao;

import java.util.List;

import com.SpringJDBC.Domain.News;
import com.SpringJDBC.Domain.News2;
import com.SpringJDBC.Domain.NewsMetric;

public interface NewsDao {

	//day1
	public void printNews();
	public List<News> getNews();	
	public List<News2> getAllDefaultNews();
	
	//day2
	
	public void persistNews(News news);
	
	public News getNewsById(Long newsId);
	
	public List<News> searchNewsByQuery(String query);
	
	public List<News> getNewsByType(String newsType);
	
	public List<NewsMetric> getNewsMetricByType();
	
	
	
}
