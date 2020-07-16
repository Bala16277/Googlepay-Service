package com.hcl.googlepay.controller;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.googlepay.entity.TransactionDetails;
import com.hcl.googlepay.repository.TransactionRepository;
import com.hcl.googlepay.service.TransactionService;



@RestController
@RequestMapping("/transactions")
public class TransactionController {
	
	private static Logger logger = Logger.getLogger(TransactionService.class);

	@Autowired
	TransactionService trasactionService;
	
	@GetMapping("/transactionsDetails")
		public ResponseEntity<List<TransactionDetails>> getTransactionDetails(@RequestParam long fromPhoneNumber){
		List<TransactionDetails> transactionDetails = trasactionService.getFromPhoneNumber(fromPhoneNumber);
			
			return new ResponseEntity<List<TransactionDetails>>(transactionDetails, HttpStatus.OK);
		}

}
