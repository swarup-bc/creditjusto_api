package com.urs.bsi.vo;

import java.util.Map;

public class Categories {

	private String currency;
	private Map<String,CategoriesL2> categories;
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public Map<String, CategoriesL2> getCategories() {
		return categories;
	}
	public void setCategories(Map<String, CategoriesL2> categories) {
		this.categories = categories;
	}
	
}
