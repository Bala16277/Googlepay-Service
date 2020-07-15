package com.hcl.googlepay.service;

import java.util.Date;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.googlepay.entity.TransactionDetails;
import com.hcl.googlepay.repository.TransactionRepository;



@Service
public class TransactionService {
	
	@Autowired
	TransactionRepository transactionRepository;
	
		
	private static Logger logger=Logger.getLogger(TransactionService.class);


	public List<TransactionDetails> getFromPhoneNumber(long fromPhoneNumber) {
		
		List<TransactionDetails> listOfTransactionDetails=transactionRepository.findByFromPhoneNumber(fromPhoneNumber);
		List<TransactionDetails> subList=listOfTransactionDetails.subList(listOfTransactionDetails.size()-5, listOfTransactionDetails.size());

		return subList;

	}

	
	
}
