package com.hcl.googlepay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.googlepay.dto.TransactionReqDto;
import com.hcl.googlepay.entity.Transaction;
import com.hcl.googlepay.service.TransactionService;


@RestController
@RequestMapping("/fundtransfer")
public class TransactionController {

	@Autowired
	TransactionService transactionService;
		
	@PostMapping("")
	public ResponseEntity<String> transferFund(@RequestBody TransactionReqDto transactionReqDto) {
		
		transactionService.fundTransfer(transactionReqDto);
		return new ResponseEntity<String>("Amount transfered successfully", HttpStatus.CREATED);
	}
	
	
	@GetMapping("/transactions")
	public ResponseEntity<List<Transaction>> getTransactions(@RequestParam int from_mobile_no){
	List<Transaction> transactions = transactionService.getByPhoneNumber(from_mobile_no);
		
		return new ResponseEntity<List<Transaction>>(transactions, HttpStatus.OK);
	}
	
}
