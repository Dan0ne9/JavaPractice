package com.example.firsttask2.person.mapper;


import com.example.firsttask2.person.dto.UserResponse;
import com.example.firsttask2.person.entity.User;

public class UserMapper {
    public static UserResponse mapToUserDto(User user){
        return new UserResponse(
                user.getId(),
                user.getPersonName(),
                user.getLogin(),
                user.getPassword()
        );
    }

    public static User mapToUser(UserResponse userDto){
        return new User(
                userDto.getId(),
                userDto.getPersonName(),
                userDto.getLogin(),
                userDto.getPassword()
        );
    }

}
