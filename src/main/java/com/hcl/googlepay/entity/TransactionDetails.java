package com.hcl.googlepay.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import ch.qos.logback.core.net.SyslogOutputStream;

@Entity
@Table(name = "transaction")
public class TransactionDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer transaction_Id;
	
	private long fromPhoneNumber;
	
	private long toPhoneNumber;
	
	private int transaction_Amount;
	
	//@Temporal(TemporalType.DATE)
	private Date transaction_Time;

	public TransactionDetails(String string) {
		// TODO Auto-generated constructor stub
	}

	public TransactionDetails() {
		// TODO Auto-generated constructor stub
	}

	public Integer getTransaction_Id() {
		return transaction_Id;
	}

	public void setTransaction_Id(Integer transaction_Id) {
		this.transaction_Id = transaction_Id;
	}

	public long getFromPhoneNumber() {
		return fromPhoneNumber;
	}

	public void setFromPhoneNumber(long fromPhoneNumber) {
		this.fromPhoneNumber = fromPhoneNumber;
	}

	public long getToPhoneNumber() {
		return toPhoneNumber;
	}

	public void setToPhoneNumber(long toPhoneNumber) {
		this.toPhoneNumber = toPhoneNumber;
	}

	public int getTransaction_Amount() {
		return transaction_Amount;
	}

	public void setTransaction_Amount(int transaction_Amount) {
		this.transaction_Amount = transaction_Amount;
	}

	public Date getTransaction_Time() {
		return transaction_Time;
	}

	public void setTransaction_Time(Date transaction_Time) {
		this.transaction_Time = transaction_Time;
	}

	
	
}
