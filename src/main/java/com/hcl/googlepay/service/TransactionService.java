package com.hcl.googlepay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.googlepay.clients.AccountClient;
import com.hcl.googlepay.dto.AccountDto;
import com.hcl.googlepay.dto.TransactionReqDto;
import com.hcl.googlepay.entity.Transaction;
import com.hcl.googlepay.repository.TransactionRepository;

import java.time.LocalDateTime; 
import java.time.format.DateTimeFormatter;
import java.util.List;

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

			transaction.setFromMobileNo(transactionReqDto.getFrom_mobile_no());
			transaction.setTo_mobile_no(transactionReqDto.getTo_mobile_no());
			transaction.setTransaction_amount(transactionReqDto.getTransaction_amount());
			transaction.setTransaction_time(transactionDateTime);

			accountClient.fundTransfer(fromAccount.getAcountNumber(), toAccount.getAcountNumber(),
					transactionReqDto.getTransaction_amount());

		}
		return transactionRepository.save(transaction);
	}


	
	
	public List<Transaction> getByPhoneNumber(int from_mobile_no) {
		
		
		List<Transaction> transactions = transactionRepository.findAllByfromMobileNo(from_mobile_no);
		List<Transaction> latestTransactions = transactions.subList(transactions.size() -2, transactions.size());
		return latestTransactions;

	}
	

}
