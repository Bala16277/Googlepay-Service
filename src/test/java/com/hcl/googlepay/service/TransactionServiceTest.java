package com.hcl.googlepay.service;

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

import com.hcl.googlepay.dto.TransactionReqDto;
import com.hcl.googlepay.entity.Transaction;
import com.hcl.googlepay.repository.TransactionRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class TransactionServiceTest {

	@InjectMocks
	TransactionService transactionService;
	
	@Mock
	TransactionRepository transactionRepository;
	
	@Test
	public void fundTransferTest() {
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
		
		Mockito.when(transactionRepository.save(transaction)).thenReturn(transaction);
		Assert.assertNotNull(transaction);
	}
	
}
