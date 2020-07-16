package com.hcl.googlepay.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;

import com.hcl.googlepay.dto.TransactionReqDto;
import com.hcl.googlepay.entity.Transaction;
import com.hcl.googlepay.service.TransactionService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class TransactionControllerTest {

	@InjectMocks TransactionController transactionController;
	@Mock TransactionService transactionService;
	
	@Test
	public void transferFundTest (){
		
		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String transactionDateTime = myDateObj.format(myFormatObj);
		
		TransactionReqDto transactionReqDto = new TransactionReqDto();
		transactionReqDto.setFrom_mobile_no(123456789);
		transactionReqDto.setTo_mobile_no(123456789);
		transactionReqDto.setTransaction_amount(1000);
		
		Transaction transaction = new Transaction();
		BeanUtils.copyProperties(transactionReqDto, transaction);
		transaction.setTransaction_time(transactionDateTime);
		
		Mockito.when(transactionService.fundTransfer(transactionReqDto)).thenReturn(transaction);
		ResponseEntity<String> transactionRes = transactionController.transferFund(transactionReqDto);
		
		Assert.assertNotNull(transactionRes);
		Assert.assertNotNull(transaction);
	}
}
