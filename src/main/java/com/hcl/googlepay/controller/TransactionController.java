package com.hcl.googlepay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.googlepay.clients.AccountClient;
import com.hcl.googlepay.dto.TransactionReqDto;
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
	
}
