package com.example.firsttask2.person.service;


import com.example.firsttask2.person.dto.UserRequest;
import com.example.firsttask2.person.dto.UserResponse;
import com.example.firsttask2.person.entity.User;
import com.example.firsttask2.person.exceptions.UserNotFoundException;
import com.example.firsttask2.person.mapper.UserMapper;
import com.example.firsttask2.person.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Override
    public UserResponse createUser(UserRequest req){
        User savedUser = userRepository.save(req.mapToUser());
        return savedUser.mapToDto();
    }
    @Override
    public User getUserById(Long userId) throws UserNotFoundException {
        Optional<User> optionalUser = userRepository.findById(userId);
        User user = optionalUser.orElseThrow(()->new UserNotFoundException("Пользователь не найден"));
        return user;
    }
    @Override
    public Collection<UserResponse> getAllUsers(){
        List<User> users = userRepository.findAll();
        return users.stream().map(UserMapper::mapToUserDto).collect(Collectors.toList());
    }
    @Override
    public UserResponse updateUser(UserResponse user) {
        User existingUser = userRepository.findById(user.getId()).get();
        existingUser.setPersonName(user.getPersonName());
        existingUser.setLogin(user.getLogin());
        existingUser.setPassword(user.getPassword());
        User updatedUser = userRepository.save(existingUser);
        return UserMapper.mapToUserDto(updatedUser);
    }
    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
