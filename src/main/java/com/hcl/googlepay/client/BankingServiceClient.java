//package com.hcl.googlepay.client;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.hcl.googlepay.dto.AccountDto;
//
////@FeignClient(value="banking-service", url = "http://localhost:8080/bankingapp/accounts")
////@FeignClient(name="http://bank-service:7777/testbank/users")
////@FeignClient(value="bank-service", url="http://localhost:7777/testbank/users/")
//public interface BankingServiceClient {
//
//
//		@GetMapping("/accounts")
//		public AccountDto getAccountByPhoneNumber(@RequestParam("phoneNumber") int phoneNumber);
//
//
//}
