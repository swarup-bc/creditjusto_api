package com.urs.bsi.vo;

import java.math.BigDecimal;

public class Category {

	private String name;
	private BigDecimal amount;
	private Integer transaction_count;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public Integer getTransaction_count() {
		return transaction_count;
	}
	public void setTransaction_count(Integer transaction_count) {
		this.transaction_count = transaction_count;
	}
	
}
