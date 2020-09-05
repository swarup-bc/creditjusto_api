package com.urs.bsi.vo;

import java.util.List;

public class Group {

	private String unique_id;
	private List<BankStatement> transactions;
	private List<Summary> summaries;
	private Categories summary_categories;
	public String getUnique_id() {
		return unique_id;
	}
	public void setUnique_id(String unique_id) {
		this.unique_id = unique_id;
	}
	public List<BankStatement> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<BankStatement> transactions) {
		this.transactions = transactions;
	}
	public List<Summary> getSummaries() {
		return summaries;
	}
	public void setSummaries(List<Summary> summaries) {
		this.summaries = summaries;
	}
	
	public Categories getSummary_categories() {
		return summary_categories;
	}
	public void setSummary_categories(Categories summary_categories) {
		this.summary_categories = summary_categories;
	}
	
}
