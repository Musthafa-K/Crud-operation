package com.example.crudoperation.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.Default;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto
{
    private Integer id;
    private String name;
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @NotEmpty(message = "Enter your email")
    @Email
    private String email;
    @NotEmpty
    private String username;
    @NotEmpty
    private String phoneNumber;
    @NotEmpty
    private String dob;
    @NotEmpty
    private String gender;
    @NotEmpty
    private String password;
    @NotEmpty
    private String confirmPassword;
    @NotEmpty
    private String state;

    private String role;




}
