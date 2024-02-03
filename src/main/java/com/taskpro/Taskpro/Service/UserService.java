package com.taskpro.Taskpro.Service;

import org.springframework.stereotype.Service;

import com.taskpro.Taskpro.Dto.LoginDto;
import com.taskpro.Taskpro.Dto.UserDto;
import com.taskpro.Taskpro.response.LoginResponse;


@Service
public interface UserService {

	String addUser(UserDto userDto);

	LoginResponse loginUser(LoginDto loginDto);

}
