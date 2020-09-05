package com.urs.bsi.vo;

import java.math.BigDecimal;

public class Summary {

	private String account_id;
	private String account_name;
	private String id;
	private String start_date;
	private String end_date;
	private BigDecimal current_balance;
	private BigDecimal open_balance;
	private BigDecimal closing_balance;
	private BigDecimal total_deposits;
	private int count_deposits;
	private BigDecimal total_withdrawals;
	private int count_withdrawals;
	private String native_vs_non_native;
	private int check_sum;
	private Bank bank;
	
	
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public BigDecimal getCurrent_balance() {
		return current_balance;
	}
	public void setCurrent_balance(BigDecimal current_balance) {
		this.current_balance = current_balance;
	}
	public BigDecimal getOpen_balance() {
		return open_balance;
	}
	public void setOpen_balance(BigDecimal open_balance) {
		this.open_balance = open_balance;
	}
	public BigDecimal getClosing_balance() {
		return closing_balance;
	}
	public void setClosing_balance(BigDecimal closing_balance) {
		this.closing_balance = closing_balance;
	}
	public BigDecimal getTotal_deposits() {
		return total_deposits;
	}
	public void setTotal_deposits(BigDecimal total_deposits) {
		this.total_deposits = total_deposits;
	}
	public int getCount_deposits() {
		return count_deposits;
	}
	public void setCount_deposits(int count_deposits) {
		this.count_deposits = count_deposits;
	}
	public BigDecimal getTotal_withdrawals() {
		return total_withdrawals;
	}
	public void setTotal_withdrawals(BigDecimal total_withdrawals) {
		this.total_withdrawals = total_withdrawals;
	}
	public int getCount_withdrawals() {
		return count_withdrawals;
	}
	public void setCount_withdrawals(int count_withdrawals) {
		this.count_withdrawals = count_withdrawals;
	}
	public String getNative_vs_non_native() {
		return native_vs_non_native;
	}
	public void setNative_vs_non_native(String native_vs_non_native) {
		this.native_vs_non_native = native_vs_non_native;
	}
	public int getCheck_sum() {
		return check_sum;
	}
	public void setCheck_sum(int check_sum) {
		this.check_sum = check_sum;
	}
	public Bank getBank() {
		return bank;
	}
	public void setBank(Bank bank) {
		this.bank = bank;
	}
	
}
