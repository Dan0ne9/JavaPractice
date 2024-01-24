package com.example.firsttask2.person.entity;

import com.example.firsttask2.person.dto.UserResponse;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String personName;

    @Column(nullable = false, unique = true )
    private String login;

    @Column(nullable = false)
    private String password;

    public UserResponse mapToDto(){
        return new UserResponse(this.id,this.personName,this.login,this.password);
    }

    public User(String personName, String login ,String password){
        this.login=login;
        this.personName=personName;
        this.password=password;
    }

}
