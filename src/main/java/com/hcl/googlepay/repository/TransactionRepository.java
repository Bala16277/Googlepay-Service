package com.hcl.googlepay.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.googlepay.entity.TransactionDetails;


public interface TransactionRepository extends JpaRepository<TransactionDetails, Long> {

	
	public  List<TransactionDetails> findByFromPhoneNumber(long fromPhoneNumber);

	//public List<TransactionDetails> getListOfTransactionDetails(long fromPhoneNumber);
	
}
