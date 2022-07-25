package com.spring.mvc.service;

import com.spring.mvc.shared.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
   UserDto createUser(UserDto user);
   UserDto getUser(String email);
}
