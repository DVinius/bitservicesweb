package com.bitservices.app.models;

import java.util.Date;

public class News {
	private Integer nid;
	private String url;
	private String title;
	private String myComment;
	private Integer votesUp;
	private Integer votesDown;
	private Date publishedDate;
	private String img;
	
	public News() {
		super();
	}
	
	public News(final Integer id) {
		this();
		this.nid = id;
	}
	
	public News(final Integer nid, String url, String title, String myComment, Integer votesUp, Integer votesDown) {
		super();
		this.nid = nid;
		this.url = url;
		this.title = title;
		this.myComment = myComment;
		this.votesUp = votesUp;
		this.votesDown = votesDown;
	}
	
	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}

	public Integer getNid() {
		return nid;
	}

	public void setNid(Integer nid) {
		this.nid = nid;
	}


	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMyComment() {
		return myComment;
	}
	public void setMyComment(String myComment) {
		this.myComment = myComment;
	}
	public Integer getVotesUp() {
		return votesUp;
	}
	public void setVotesUp(Integer votesUp) {
		this.votesUp = votesUp;
	}
	public Integer getVotesDown() {
		return votesDown;
	}
	public void setVotesDown(Integer votesDown) {
		this.votesDown = votesDown;
	}
	
}
