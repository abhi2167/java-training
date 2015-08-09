package com.SpringJDBC.NewServiceImp1;

import java.util.List;

import com.SpringJDBC.Domain.News;
import com.SpringJDBC.Domain.News2;
import com.SpringJDBC.Domain.NewsMetric;
import com.SpringJDBC.Domain.NewsRowMapper;
import com.SpringJDBC.NewsDao.NewsDao;
import com.SpringJDBC.NewsService.NewsService;

public class NewsServiceImp1 implements NewsService{

	private NewsDao newsDao;
	
	
	public void setNewsDao(NewsDao newsDao) {
		this.newsDao = newsDao;
	}
	
	@Override
	public void printNews() {
		// TODO Auto-generated method stub
		newsDao.printNews();
		
	}

	@Override
	public List<News> getAllNews() {
		// TODO Auto-generated method stub
		return newsDao.getNews();
	}

	@Override
	public List<News2> getAllDefaultNews() {
		// TODO Auto-generated method stub
		return newsDao.getAllDefaultNews();
	}

	public void saveNews(News news) {
		newsDao.persistNews(news);
	}

	@Override
	public News getNewsById(Long newsId) {
		// TODO Auto-generated method stub
		return newsDao.getNewsById(newsId);
	}

	@Override
	public List<News> searchNewsByQuery(String query) {
		// TODO Auto-generated method stub
		return newsDao.searchNewsByQuery(query);
	}

	@Override
	public List<News> getNewsByType(String newsType) {
		// TODO Auto-generated method stub
		return newsDao.getNewsByType(newsType);
	}

	@Override
	public List<NewsMetric> getNewsMetricByType() {
		// TODO Auto-generated method stub
		return newsDao.getNewsMetricByType();
	}
	

}
