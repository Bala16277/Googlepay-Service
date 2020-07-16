package com.hcl.googlepay.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.googlepay.dto.UserRequestDto;
import com.hcl.googlepay.dto.UserResponseDto;
import com.hcl.googlepay.service.UserService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class UserControllerTest {
	
	@InjectMocks
	UserController userController;
	
	@Mock
	UserService userService;
	
	@Test
	public void testAddUsers() {
		UserResponseDto userResponseDto = new UserResponseDto();
		UserRequestDto userRequestDto = new UserRequestDto();
		userRequestDto.setFirstName("bala");
		userRequestDto.setLastName("k");
		userRequestDto.setPassword("bala");
		userRequestDto.setPhoneNumber(970);
		userRequestDto.setUserName("bala");
		userRequestDto.setEmail("bala");
		
		userResponseDto.setMessage("User created successfully");
		userResponseDto.setStatusCode(201);
		Mockito.when(userService.addUser(userRequestDto)).thenReturn(userResponseDto);
		Assert.assertNotNull(userResponseDto);
		Assert.assertEquals("User created successfully", userResponseDto.getMessage());
		
	}

}
