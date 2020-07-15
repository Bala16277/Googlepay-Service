package com.hcl.googlepay.service;

import org.jboss.logging.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hcl.googlepay.client.BankingServiceClient;
import com.hcl.googlepay.dto.AccountDto;
import com.hcl.googlepay.dto.UserRequestDto;
import com.hcl.googlepay.dto.UserResponseDto;
import com.hcl.googlepay.entity.User;
import com.hcl.googlepay.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private static Logger logger = Logger.getLogger(UserServiceImpl.class);

	@Autowired
	UserRepository userRepository;

	@Autowired
	BankingServiceClient bankingServiceClient;

//	@Autowired
//	AccountRepository accountRepository;

	public UserResponseDto addUser(UserRequestDto userRequestDto) {
		logger.info("inside user req:  ");
		
		UserResponseDto userResponseDto = new UserResponseDto();
		System.out.println("phone::: " + userRequestDto.getPhoneNumber());
		User user = new User();
		String phoneNumber = userRequestDto.getPhoneNumber();
		logger.info("phone:::::::::::::: " + phoneNumber);
		System.out.println(bankingServiceClient.getAccountByPhoneNumber(phoneNumber));
		AccountDto accountDto = bankingServiceClient.getAccountByPhoneNumber(phoneNumber);
		System.out.println(accountDto);
		if (accountDto != null) {
			BeanUtils.copyProperties(userRequestDto, user);
			User user1 = userRepository.save(user);
			System.out.println(user1.getPhoneNumber());
			userResponseDto.setMessage("User created successfully");
			userResponseDto.setStatusCode(HttpStatus.CREATED.value());

		} else {
			userResponseDto.setMessage("User does not have a account with the associated phone number");
			userResponseDto.setStatusCode(HttpStatus.NOT_FOUND.value());
			return userResponseDto;
		}
		return userResponseDto;
	}

}
