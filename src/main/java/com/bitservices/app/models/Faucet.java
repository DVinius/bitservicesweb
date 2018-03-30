package com.bitservices.app.models;

import com.bitservices.app.enums.FaucetType;

public class Faucet {
	private Integer id;
	private FaucetType faucetType;
	private String name;
	private String description;
	private String url;
	private String actionName;
	private String image;
	
	public Faucet(Integer id, String name, String url, final String descr) { 
		super();
		this.id = id;
		this.name = name;
		this.url = url;
		this.description = descr;
	}
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public FaucetType getFaucetType() {
		return faucetType;
	}

	public void setFaucetType(FaucetType faucetType) {
		this.faucetType = faucetType;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
