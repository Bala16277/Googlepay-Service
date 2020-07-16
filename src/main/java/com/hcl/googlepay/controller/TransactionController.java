package com.hcl.googlepay.controller;

<<<<<<< HEAD
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
=======
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
>>>>>>> c66a04367499e1d2cb9d3592ee9c063e729c9c10
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

<<<<<<< HEAD
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

=======
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
	
>>>>>>> c66a04367499e1d2cb9d3592ee9c063e729c9c10
}
