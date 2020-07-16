package com.hcl.googlepay.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

<<<<<<< HEAD
import com.hcl.googlepay.entity.TransactionDetails;


public interface TransactionRepository extends JpaRepository<TransactionDetails, Long> {

	
	public  List<TransactionDetails> findByFromPhoneNumber(long fromPhoneNumber);

	//public List<TransactionDetails> getListOfTransactionDetails(long fromPhoneNumber);
	
=======
import com.hcl.googlepay.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer>{

	//List<Transaction> findByTrainingId(int trainingId);
>>>>>>> c66a04367499e1d2cb9d3592ee9c063e729c9c10
}
