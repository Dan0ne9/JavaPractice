package com.example.firsttask2.person.controller;

import com.example.firsttask2.person.dto.UserRequest;
import com.example.firsttask2.person.dto.UserResponse;
import com.example.firsttask2.person.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@AllArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest req){
        System.out.println("Записываю пользователя");
        return new ResponseEntity<>(userService.createUser(req), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Collection<UserResponse>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> getUserById(@PathVariable("id") Long userId) {
        try{
            UserResponse user = userService.getUserById(userId).mapToDto();
            return new ResponseEntity<>(user, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable("id") Long userId, @RequestBody UserResponse user){
        user.setId(userId);
        UserResponse updatedUser = userService.updateUser(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>("Person deleted!",HttpStatus.OK);
    }



}
