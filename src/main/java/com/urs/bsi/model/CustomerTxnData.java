package com.urs.bsi.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_customer_txn_data")
public class CustomerTxnData {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id	;
	
	private String description;
	private String check_no;
	private String txn_date;
	private BigDecimal txn_amt;
	private String type;
	private int historyId;
	private String timestamp;
	
	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

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
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCheck_no() {
		return check_no;
	}
	public void setCheck_no(String check_no) {
		this.check_no = check_no;
	}
	public String getTxn_date() {
		return txn_date;
	}
	public void setTxn_date(String txn_date) {
		this.txn_date = txn_date;
	}
	public BigDecimal getTxn_amt() {
		return txn_amt;
	}
	public void setTxn_amt(BigDecimal txn_amt) {
		this.txn_amt = txn_amt;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}