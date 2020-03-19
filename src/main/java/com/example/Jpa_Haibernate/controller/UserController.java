package com.example.Jpa_Haibernate.controller;

import com.example.Jpa_Haibernate.model.UserModel;
import com.example.Jpa_Haibernate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/employees")
    public ResponseEntity<List<UserModel>> findAllUser(){
        return ResponseEntity.ok().body(userService.findAllUser());
    }
    @GetMapping("/")
    public String Hello(){
        return "Hello World";
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Optional<UserModel>> findUserById(@PathVariable("id") long id){
        return ResponseEntity.ok().body(userService.findUserById(id));
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<UserModel> updatedUser(@PathVariable("id") long id, @RequestBody UserModel userModel){
        userModel.setId(id);
        return ResponseEntity.ok().body(userService.updateUser(userModel));
    }

    @PostMapping("/employees")
    public ResponseEntity<UserModel> createUser(@RequestBody UserModel userModel){
        return ResponseEntity.ok().body(userService.insertUser(userModel));
    }

    @DeleteMapping("/employees/{id}")
    public HttpStatus deleteUser(@PathVariable("id") long id){
        userService.deleteUser(id);
        return HttpStatus.OK;
    }
}
