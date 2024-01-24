package com.example.firsttask2.person.repository;

import com.example.firsttask2.person.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
