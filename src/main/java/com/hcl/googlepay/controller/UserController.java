package com.hcl.googlepay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.googlepay.dto.UserRequestDto;
import com.hcl.googlepay.dto.UserResponseDto;
import com.hcl.googlepay.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	
	
	@Autowired
	UserService userService;
	
	@PostMapping("/")
	public ResponseEntity<UserResponseDto> addUsers(@RequestBody UserRequestDto userRequestDto) {
		System.out.println("phone::: "+userRequestDto.getPhoneNumber());
		UserResponseDto userResponseDto = userService.addUser(userRequestDto);
		return new ResponseEntity<UserResponseDto>(userResponseDto, HttpStatus.CREATED);
	}

}
