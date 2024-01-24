package com.example.firsttask2.person.dto;

import com.example.firsttask2.person.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {
    private String personName;
    private String login;
    private String password;

    public User mapToUser(){
        return new User(personName,login,password);
    }

}
