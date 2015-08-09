package com.abhi.News;

import java.io.Serializable;

public class News implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6889942894283029771L;

	private Long id;
	
	private String headLines;
	private String mainStory;
	private String newsType;
	
	public News() {
		
		
	}
	public News(Long id, String headLines, String mainStory, String newsType) {
		super();
		this.id = id;
		this.headLines = headLines;
		this.mainStory = mainStory;
		this.newsType = newsType;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getHeadLines() {
		return headLines;
	}
	public void setHeadLines(String headLines) {
		this.headLines = headLines;
	}
	public String getMainStory() {
		return mainStory;
	}
	public void setMainStory(String mainStory) {
		this.mainStory = mainStory;
	}
	public String getNewsType() {
		return newsType;
	}
	public void setNewsType(String newsType) {
		this.newsType = newsType;
	}
	@Override
	public String toString() {
		return "News [id=" + id + ", headLines=" + headLines + ", mainStory="
				+ mainStory + ", newsType=" + newsType + "]";
	}

}
