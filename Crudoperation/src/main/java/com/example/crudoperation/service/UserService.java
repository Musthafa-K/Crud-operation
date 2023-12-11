package com.example.crudoperation.service;

import com.example.crudoperation.dto.UserDto;
import com.example.crudoperation.entity.User;

import java.util.List;


public interface UserService {
    void saveUser(UserDto userDto);

    User findByUsername(String username);

    User findByEmail(String email);

    UserDto findById(int id);

    List<UserDto> findAllByRole(String role);

    User updateUser(UserDto user);

    User updatefirstName(UserDto user);

    User deleteUserById(int id);
    List<UserDto> searchUser(String role,String name);


}
