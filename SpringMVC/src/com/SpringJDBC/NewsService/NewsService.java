package com.SpringJDBC.NewsService;

import java.util.List;

import com.SpringJDBC.Domain.News;
import com.SpringJDBC.Domain.News2;
import com.SpringJDBC.Domain.NewsMetric;

public interface NewsService {

	// day 1
	public void printNews();

	public List<News> getAllNews();

	public List<News2> getAllDefaultNews();

	// day 2

	/*
	 * public void persistNews(News news);
	 * 
	 * public News getNewsById(Long newsId);
	 * 
	 * public List<News> searchNewsByQuery(String query);
	 * 
	 * public List<News> getNewsByType(String newsType);
	 * 
	 * public List<NewsMetric> getNewsMetricByType();
	 */

	public void saveNews(News news);

	public News getNewsById(Long newsId);

	public List<News> searchNewsByQuery(String query);

	public List<News> getNewsByType(String newsType);

	public List<NewsMetric> getNewsMetricByType();

}
