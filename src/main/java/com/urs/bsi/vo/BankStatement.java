package com.urs.bsi.vo;

import java.util.List;

public class BankStatement {

	private String bank_statement_id;
	private String account_id;
	private String account_name;
	private List<Transactions> transactions;

	public String getAccount_id() {
		return account_id;
	}
	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}
	public String getAccount_name() {
		return account_name;
	}
	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}
	public String getBank_statement_id() {
		return bank_statement_id;
	}
	public void setBank_statement_id(String bank_statement_id) {
		this.bank_statement_id = bank_statement_id;
	}
	public List<Transactions> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<Transactions> transactions) {
		this.transactions = transactions;
	}
	
}
