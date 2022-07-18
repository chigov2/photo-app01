package com.spring.mvc.ui.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    @GetMapping
    public String getUsers(){
        return "getUsers was called";
    }

    @PostMapping
    public  String createUser(){
        return "postUser was called: Create user";
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
