package com.hcl.googlepay.dto;

public class TransactionReqDto {
	
	private int from_mobile_no;
	
	public int getFrom_mobile_no() {
		return from_mobile_no;
	}

	public void setFrom_mobile_no(int from_mobile_no) {
		this.from_mobile_no = from_mobile_no;
	}

	private int to_mobile_no;
	
	private int transaction_amount;

	public int getTo_mobile_no() {
		return to_mobile_no;
	}

	public void setTo_mobile_no(int to_mobile_no) {
		this.to_mobile_no = to_mobile_no;
	}

	public int getTransaction_amount() {
		return transaction_amount;
	}

	public void setTransaction_amount(int transaction_amount) {
		this.transaction_amount = transaction_amount;
	}

	
}
