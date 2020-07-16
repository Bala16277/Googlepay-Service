package com.hcl.googlepay.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transaction {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer transaction_id;
	
	private int transaction_amount;
	
	private int fromMobileNo;
	
	private int to_mobile_no;
	
	private String transaction_time;

	public String getTransaction_time() {
		return transaction_time;
	}

	public void setTransaction_time(String transaction_time) {
		this.transaction_time = transaction_time;
	}

	public Integer getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(Integer transaction_id) {
		this.transaction_id = transaction_id;
	}

	public int getTransaction_amount() {
		return transaction_amount;
	}

	public void setTransaction_amount(int transaction_amount) {
		this.transaction_amount = transaction_amount;
	}



	public int getFromMobileNo() {
		return fromMobileNo;
	}

	public void setFromMobileNo(int fromMobileNo) {
		this.fromMobileNo = fromMobileNo;
	}

	public int getTo_mobile_no() {
		return to_mobile_no;
	}

	public void setTo_mobile_no(int to_mobile_no) {
		this.to_mobile_no = to_mobile_no;
	}


}
