package com.SpringJDBC.Domain;

public class News2 {
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private String headLines;
	private String imageURL;
	private String mainStory;
	private String videoURL;
	private String newstype;
	
	public News2() {
		
	}
	public News2(Long id, String headLines, String imageURL, String mainStory,
			String videoURL, String newstype) {
		super();
		this.id = id;
		this.headLines = headLines;
		this.imageURL = imageURL;
		this.mainStory = mainStory;
		this.videoURL = videoURL;
		this.newstype = newstype;
	}
	@Override
	public String toString() {
		return "News2 [id=" + id + ", headLines=" + headLines + ", imageURL="
				+ imageURL + ", mainStory=" + mainStory + ", videoURL="
				+ videoURL + ", newstype=" + newstype + "]";
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
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public String getMainStory() {
		return mainStory;
	}
	public void setMainStory(String mainStory) {
		this.mainStory = mainStory;
	}
	public String getVideoURL() {
		return videoURL;
	}
	public void setVideoURL(String videoURL) {
		this.videoURL = videoURL;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getNewstype() {
		return newstype;
	}
	public void setNewstype(String newstype) {
		this.newstype = newstype;
	}

}
