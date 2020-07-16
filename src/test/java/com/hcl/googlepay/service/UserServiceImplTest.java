package com.hcl.googlepay.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.BeanUtils;

import com.hcl.googlepay.client.BankingServiceClient;
import com.hcl.googlepay.dto.AccountDto;
import com.hcl.googlepay.dto.UserRequestDto;
import com.hcl.googlepay.dto.UserResponseDto;
import com.hcl.googlepay.entity.User;
import com.hcl.googlepay.repository.UserRepository;



@RunWith(MockitoJUnitRunner.Silent.class)
public class UserServiceImplTest {

	
	@InjectMocks
	UserServiceImpl userServiceImpl;
	
	@Mock
	UserRepository userRepository;

	@Mock
	BankingServiceClient bankingServiceClient;
	
	@Test
	public void testAddUser() {
		UserResponseDto userResponseDto = new UserResponseDto();
		UserRequestDto userRequestDto = new UserRequestDto();
		User user = new User();
		user.setUserId(1);
		user.setFirstName("bala");
		user.setLastName("k");
		user.setPassword("bala");
		user.setPhoneNumber(970);
		user.setUserName("bala");
		user.setEmail("bala");

		AccountDto accountDto = new AccountDto();
		accountDto.setAccountId(1);
		accountDto.setAccountName("bala");
		accountDto.setAccountType("savings");
		accountDto.setBalance(2500);
		accountDto.setPhoneNumber(970);
		Mockito.when(bankingServiceClient.getAccountByPhoneNumber(accountDto.getPhoneNumber())).thenReturn(accountDto);
		if(accountDto != null) {
			BeanUtils.copyProperties(user, userRequestDto);
			userResponseDto = userServiceImpl.addUser(userRequestDto);
			Assert.assertNotNull(userResponseDto);
			Assert.assertEquals("User created successfully", userResponseDto.getMessage());
		}
	}
	
	

	@Test
	public void testAddUserforNull() {
		UserResponseDto userResponseDto = new UserResponseDto();
		
		UserRequestDto userRequestDto = new UserRequestDto();
		
		userRequestDto.setFirstName("bala");
		userRequestDto.setLastName("k");
		userRequestDto.setPassword("bala");
		userRequestDto.setPhoneNumber(9809);
		userRequestDto.setUserName("bala");
		userRequestDto.setEmail("bala");

		AccountDto accountDto = null;
		Mockito.when(bankingServiceClient.getAccountByPhoneNumber(userRequestDto.getPhoneNumber())).thenReturn(null);
		if(accountDto == null) {
			userResponseDto = userServiceImpl.addUser(userRequestDto);
			Assert.assertNotNull(userResponseDto);
			Assert.assertEquals("User does not have a account with the associated phone number", userResponseDto.getMessage());
		}
	
	}
}
	
	
