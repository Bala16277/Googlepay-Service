package com.hcl.googlepay.service;

<<<<<<< HEAD
import java.util.Date;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.googlepay.entity.TransactionDetails;
import com.hcl.googlepay.repository.TransactionRepository;



@Service
public class TransactionService {
	
	private static Logger logger = Logger.getLogger(TransactionRepository.class);
	
	@Autowired
	TransactionRepository transactionRepository;
	
		


	public List<TransactionDetails> getFromPhoneNumber(long fromPhoneNumber) {
		
		List<TransactionDetails> listOfTransactionDetails=transactionRepository.findByFromPhoneNumber(fromPhoneNumber);
		List<TransactionDetails> subList=listOfTransactionDetails.subList(listOfTransactionDetails.size()-5, listOfTransactionDetails.size());

		return subList;

	}
	
=======
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.googlepay.clients.AccountClient;
import com.hcl.googlepay.dto.AccountDto;
import com.hcl.googlepay.dto.TransactionReqDto;
import com.hcl.googlepay.entity.Transaction;
import com.hcl.googlepay.repository.TransactionRepository;

import java.time.LocalDateTime; 
import java.time.format.DateTimeFormatter;

@Service
public class TransactionService {

	@Autowired
	TransactionRepository transactionRepository;

	@Autowired
	AccountClient accountClient;

	public Transaction fundTransfer(TransactionReqDto transactionReqDto) {

		AccountDto fromAccount = accountClient.getAccounts(transactionReqDto.getFrom_mobile_no());
		AccountDto toAccount = accountClient.getAccounts(transactionReqDto.getTo_mobile_no());

		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String transactionDateTime = myDateObj.format(myFormatObj);

		Transaction transaction = new Transaction();

		if (fromAccount.getPhoneNumber() == transactionReqDto.getFrom_mobile_no()
				&& toAccount.getPhoneNumber() == transactionReqDto.getTo_mobile_no()
				&& fromAccount.getAvailableBallance() >= transactionReqDto.getTransaction_amount()) {

			transaction.setFrom_mobile_no(transactionReqDto.getFrom_mobile_no());
			transaction.setTo_mobile_no(transactionReqDto.getTo_mobile_no());
			transaction.setTransaction_amount(transactionReqDto.getTransaction_amount());
			transaction.setTransaction_time(transactionDateTime);

			accountClient.fundTransfer(fromAccount.getAcountNumber(), toAccount.getAcountNumber(),
					transactionReqDto.getTransaction_amount());

		}
		return transactionRepository.save(transaction);
	}

>>>>>>> c66a04367499e1d2cb9d3592ee9c063e729c9c10
}
