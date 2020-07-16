package com.hcl.googlepay.client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hcl.googlepay.dto.AccountDto;

//@FeignClient(value="banking-service", url = "http://localhost:8080/bankingapp/accounts")
@FeignClient(name="http://banking-service/bankingapp/accounts")
public interface BankingServiceClient {


		@GetMapping("")
		public AccountDto getAccountByPhoneNumber(@RequestParam("phoneNumber") int phoneNumber);


}
