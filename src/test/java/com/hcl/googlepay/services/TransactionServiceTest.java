/*package com.hcl.googlepay.services;

import java.util.List;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.util.Assert;

import com.hcl.googlepay.entity.TransactionDetails;
import com.hcl.googlepay.repository.TransactionRepository;
import com.hcl.googlepay.service.TransactionService;

public class TransactionServiceTest {
	
	@Mock 
	TransactionRepository transactionRepository;
	
	@Mock
	TransactionService transactionService;
	
	@Test
	public  void testgetFromPhoneNumber(long fromPhoneNumber){
		
		TransactionDetails transactionDetails=new TransactionDetails();
		transactionDetails.setFromPhoneNumber(9666644981L);
		transactionDetails.setToPhoneNumber(9490908890L);
		transactionDetails.setTransaction_Amount(1000);
	//	int transaction_amount=1000;
		transactionDetails.setTransaction_Id(1);
		//transactionDetails.setTransaction_Time(16-07-2020);
		
		TransactionDetails transactionDetails1=new TransactionDetails();
		transactionDetails1.setFromPhoneNumber(9666644981L);
		transactionDetails1.setToPhoneNumber(9490908891L);
		transactionDetails1.setTransaction_Amount(1000);
	//	int transaction_amount=1000;
		transactionDetails1.setTransaction_Id(2);
		//transactionDetails1.setTransaction_Time(16-07-2020);
		
		//transactionDetails.getFromPhoneNumber();
		
		transactionDetails.getFromPhoneNumber();
		transactionDetails.getToPhoneNumber();
		
		transactionDetails1.getFromPhoneNumber();
		transactionDetails1.getTransaction_Amount();
	//	Mockito.when(transactionRepository.findByFromPhoneNumber(transactionDetails)).
		
		org.junit.Assert.assertNotNull(transactionDetails1);
		//org.junit.Assert.
		
		List<TransactionDetails> listOfTransactionDetails=transactionRepository.findByFromPhoneNumber(fromPhoneNumber);
		List<TransactionDetails> subList=listOfTransactionDetails.subList(listOfTransactionDetails.size()-5, listOfTransactionDetails.size());

		
		
		
	}
	
	

}*/
