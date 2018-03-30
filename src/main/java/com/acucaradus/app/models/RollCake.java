package com.acucaradus.app.models;

public class RollCake {
	private int code;
	private String description;//sabor
	private String recipe;
	private String price;
	private boolean isAvailable;
	
	public RollCake(int code, String descr, String recipe, String price, boolean isAvailable){
		super();
		setCode(code);
		setDescription(descr);
		setRecipe(recipe);
		setPrice(price);
		setAvailable(isAvailable);
	}
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}



	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRecipe() {
		return recipe;
	}
	public void setRecipe(String recipe) {
		this.recipe = recipe;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
}
