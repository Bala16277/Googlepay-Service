package com.hcl.googlepay.controller;

import org.jboss.logging.Logger;
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
	
	private static Logger logger = Logger.getLogger(UserController.class);
	
	@Autowired
	UserService userService;
	
	@PostMapping("/")
	public ResponseEntity<UserResponseDto> addUsers(@RequestBody UserRequestDto userRequestDto) {
		logger.info("phone number:::: "+userRequestDto.getPhoneNumber());
		UserResponseDto userResponseDto = userService.addUser(userRequestDto);
		return new ResponseEntity<>(userResponseDto, HttpStatus.CREATED);
	}

}
