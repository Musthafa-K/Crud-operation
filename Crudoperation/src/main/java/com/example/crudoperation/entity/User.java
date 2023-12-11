package com.example.crudoperation.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private  String lastName;
    @Column(nullable = false ,unique = true)
    private String username;
    @Column(nullable=false, unique=true)
    private String email;
    private String phoneNumber;
    private String gender;
    private String dob;
    @Column(nullable=false)
    private String password;
    private  String confirmPassword;
    private String state;
    private String role;
}
