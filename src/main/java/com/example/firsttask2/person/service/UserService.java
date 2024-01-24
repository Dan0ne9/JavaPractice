package com.example.firsttask2.person.service;

import com.example.firsttask2.person.dto.UserRequest;
import com.example.firsttask2.person.dto.UserResponse;
import com.example.firsttask2.person.entity.User;
import com.example.firsttask2.person.exceptions.UserNotFoundException;

import java.util.Collection;


public interface UserService {
    UserResponse createUser(UserRequest user);

    User getUserById(Long userId) throws UserNotFoundException;

    Collection<UserResponse> getAllUsers();

    UserResponse updateUser(UserResponse user);

    void deleteUser(Long userId);

}
