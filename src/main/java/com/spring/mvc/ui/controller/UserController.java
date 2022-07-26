package com.spring.mvc.ui.controller;

import com.spring.mvc.service.UserService;
import com.spring.mvc.shared.dto.UserDto;
import com.spring.mvc.ui.controller.model.request.UserDetailRequestModel;
import com.spring.mvc.ui.controller.model.response.UserRest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/{id}",
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public UserRest getUserById(@PathVariable String id){

        UserRest returnValue = new UserRest() ;

        UserDto userDto = userService.getUserByUserId(id);

        BeanUtils.copyProperties(userDto,returnValue);

        return returnValue;
    }

   @PostMapping
    public UserRest createUser(@RequestBody UserDetailRequestModel userDetails){

        UserRest returnValue = new UserRest();

        UserDto userDto = new UserDto();

        BeanUtils.copyProperties(userDetails, userDto);

        UserDto createUser = userService.createUser(userDto);
        BeanUtils.copyProperties(createUser,returnValue);

        return returnValue;
    }

    @PutMapping
    public String updateUser(){
        return "updateUser was called";
    }

    @DeleteMapping
    public String deleteUse(){
        return  "Delete user";
    }

    @Override
    public String toString() {
        return "UserController{" +
                "userService=" + userService +
                '}';
    }
}
