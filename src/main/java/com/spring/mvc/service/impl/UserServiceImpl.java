package com.spring.mvc.service.impl;

import com.spring.mvc.io.entity.UserEntity;
import com.spring.mvc.repository.UserRepository;
import com.spring.mvc.service.UserService;
import com.spring.mvc.shared.Utils;
import com.spring.mvc.shared.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    Utils utils;

    @Override
    public UserDto createUser(UserDto user) {

        if (userRepository.findByEmail(user.getEmail()) !=null){ throw new RuntimeException("Record already exists");}

        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user,userEntity);

        String publicUserId = utils.generateUserId(20);
        userEntity.setUserId( publicUserId);
        userEntity.setEncryptedPassword("test");


        UserEntity storedUserDetails = userRepository.save(userEntity);

        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties(storedUserDetails,returnValue);

        return returnValue;
    }
}
