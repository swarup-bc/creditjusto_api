package com.urs.bsi.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_bank_statement_summary_level_data")
public class BankStmtSummaryData {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id	;
	private int historyId;
	private String currency;
	private String account_number;
	private String account_holder_name;
	private String account_type;
	private String name_of_bank;
	private String bank_address;
	private String bank_city;
	private String bank_state;
	private String bank_zip;
	private BigDecimal current_balance;
	private String start_date;
	private String end_date;
	private BigDecimal open_balance;
	private BigDecimal closing_balance;
	private BigDecimal total_deposits;
	private BigDecimal count_deposits;
	private BigDecimal total_withdrawals;
	private BigDecimal count_withdrawals;
	private String native_vs_non_native;
	private int check_sum;
	
	public int getHistoryId() {
		return historyId;
	}
	public void setHistoryId(int historyId) {
		this.historyId = historyId;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	public String getAccount_number() {
		return account_number;
	}
	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}
	public String getAccount_holder_name() {
		return account_holder_name;
	}
	public void setAccount_holder_name(String account_holder_name) {
		this.account_holder_name = account_holder_name;
	}
	public String getAccount_type() {
		return account_type;
	}
	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}
	public String getName_of_bank() {
		return name_of_bank;
	}
	public void setName_of_bank(String name_of_bank) {
		this.name_of_bank = name_of_bank;
	}
	public String getBank_address() {
		return bank_address;
	}
	public void setBank_address(String bank_address) {
		this.bank_address = bank_address;
	}
	public String getBank_city() {
		return bank_city;
	}
	public void setBank_city(String bank_city) {
		this.bank_city = bank_city;
	}
	public String getBank_state() {
		return bank_state;
	}
	public void setBank_state(String bank_state) {
		this.bank_state = bank_state;
	}
	public String getBank_zip() {
		return bank_zip;
	}
	public void setBank_zip(String bank_zip) {
		this.bank_zip = bank_zip;
	}
	public BigDecimal getCurrent_balance() {
		return current_balance;
	}
	public void setCurrent_balance(BigDecimal current_balance) {
		this.current_balance = current_balance;
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
	public BigDecimal getCount_deposits() {
		return count_deposits;
	}
	public void setCount_deposits(BigDecimal count_deposits) {
		this.count_deposits = count_deposits;
	}
	public BigDecimal getTotal_withdrawals() {
		return total_withdrawals;
	}
	public void setTotal_withdrawals(BigDecimal total_withdrawals) {
		this.total_withdrawals = total_withdrawals;
	}
	public BigDecimal getCount_withdrawals() {
		return count_withdrawals;
	}
	public void setCount_withdrawals(BigDecimal count_withdrawals) {
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

}
