package com.hcl.googlepay.service;

import com.hcl.googlepay.dto.UserRequestDto;
import com.hcl.googlepay.dto.UserResponseDto;

public interface UserService {

	public UserResponseDto addUser(UserRequestDto requestDto);
	
}
