package com.hcl.googlepay.service;

import java.util.Optional;

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

	public UserResponseDto addUser(UserRequestDto userRequestDto) {
		logger.info("inside user req:  ");
		UserResponseDto userResponseDto = new UserResponseDto();
		logger.info("phone::: " + userRequestDto.getPhoneNumber());
		User user = new User();
		int phoneNumber = userRequestDto.getPhoneNumber();
		logger.info("phone:::::::::::::: " + phoneNumber);
		logger.info(bankingServiceClient.getAccountByPhoneNumber(phoneNumber));
		AccountDto accountDto = bankingServiceClient.getAccountByPhoneNumber(phoneNumber);
		logger.info("Account object: " + accountDto);
		if (accountDto != null) {
			Optional<User> users = userRepository.findByPhoneNumber(phoneNumber);
			if (users.isPresent()) {
				userResponseDto.setMessage("User already exists");
				userResponseDto.setStatusCode(HttpStatus.OK.value());
			} else {
				BeanUtils.copyProperties(userRequestDto, user);
				userRepository.save(user);
				userResponseDto.setMessage("User created successfully");
				userResponseDto.setStatusCode(HttpStatus.CREATED.value());
			}
		}

		else {
			userResponseDto.setMessage("User does not have a account with the associated phone number");
			userResponseDto.setStatusCode(HttpStatus.NOT_FOUND.value());
			return userResponseDto;
		}
		return userResponseDto;
	}

}
