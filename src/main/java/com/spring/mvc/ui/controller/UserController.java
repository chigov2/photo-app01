package com.spring.mvc.ui.controller;

import com.spring.mvc.ui.controller.model.request.UserDetailRequestModel;
import com.spring.mvc.ui.controller.model.response.UserRest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    @GetMapping
    public String getUsers(){
        return "getUsers was called";
    }

    @PostMapping
    public UserRest createUser(@RequestBody UserDetailRequestModel userDetails){

        return null;
    }

    @PutMapping
    public String updateUser(){
        return "updateUser was called";
    }

    @DeleteMapping
    public String deleteUse(){
        return  "Delete user";
    }
}
