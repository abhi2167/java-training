package com.SpringJDBC.NewsDaoImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.SpringJDBC.Domain.News;
import com.SpringJDBC.Domain.News2;
import com.SpringJDBC.Domain.NewsMetric;
import com.SpringJDBC.Domain.NewsRowMapper;
import com.SpringJDBC.NewsDao.NewsDao;

public class NewsDaoImp1 implements NewsDao {

	
	private JdbcTemplate jdbcTemplate;
	
//	private DataSource dataSource;	
	
//	public void setDataSource(DataSource dataSource) {
//		this.dataSource = dataSource;
//		//this.jdbcTemplate = new JdbcTemplate(dataSource);
//	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void printNews() {
		// TODO Auto-generated method stub
		
		List<Map<String,Object>> rows = jdbcTemplate.queryForList("select * from news");
		for(Map<String,Object> row : rows) {
			for(Map.Entry<String, Object> entry : row.entrySet()) {
				System.out.print("\t"+entry.getKey()+" >>>>  "+entry.getValue());
			}
			System.out.println();
		}
		
		
		
	}


	@Override
	public List<News> getNews() {
		// TODO Auto-generated method stub
		
		List<News> news = jdbcTemplate.query("select * from news", new NewsRowMapper());
		return news;
		/*List<News> news = new ArrayList<News>();
		List<Map<String,Object>> rows = jdbcTemplate.queryForList("select * from news");
		
		for(Map<String,Object> row : rows) {
			
			News n = new News();
			for(Map.Entry<String, Object> entry : row.entrySet()) {
				System.out.println(entry.getKey()+" >>>>  "+entry.getValue());
				
				if(entry.getKey().equalsIgnoreCase(mainstory)) {
					n.setMainStory
				}
				
			}
		}*/
		
		
	}




	@Override
	public List<News2> getAllDefaultNews() {
		// TODO Auto-generated method stub
		
		List<News2> defaultNews = jdbcTemplate.query("select * from news", new BeanPropertyRowMapper<News2>(News2.class));
		
		return defaultNews;
	}

	@Override
	public void persistNews(News news) {
		// TODO Auto-generated method stub
		String insertSQL = "INSERT INTO news(news_id, headlines, mainstory, imageurl, videourl, newstype)"+
	            "VALUES (?, ?, ?, ?, ?, ?);";
		
		jdbcTemplate.update(insertSQL,new Object[]{news.getId(),news.getHeadLines(),
				news.getImageURL(),news.getMainStory(),news.getVideoURL(),news.getNewstype()});
		//jdbcTemplate.query(insertSQL, new BeanPropertyRowMapper<News2>(News2.class));
		
	}

	@Override
	public News getNewsById(Long newsId) {
		// TODO Auto-generated method stub
		News news = jdbcTemplate.queryForObject("select * from news where news_id=?", new Object[] {newsId},new NewsRowMapper());
		return news;
	}

	@Override
	public List<News> searchNewsByQuery(String query) {
		// TODO Auto-generated method stub
		
		List<News> searchResults = jdbcTemplate.query("select * from news where upper(headlines) Like upper('%"+query+"%')",new NewsRowMapper());
		return searchResults;
	}

	@Override
	public List<News> getNewsByType(String newsType) {
		// TODO Auto-generated method stub
		List<News> searchResults = jdbcTemplate.query("select * from news where newstype = ?",
				new Object[]{newsType},new NewsRowMapper());
		
		return searchResults;
	}

	@Override
	public List<NewsMetric> getNewsMetricByType() {
		// TODO Auto-generated method stub
		
		List<NewsMetric> metrics = jdbcTemplate.query("select newstype ,count(*) AS count  from news groupby newstype", new BeanPropertyRowMapper<NewsMetric>(NewsMetric.class));
		return metrics;
	}

	
	
}
