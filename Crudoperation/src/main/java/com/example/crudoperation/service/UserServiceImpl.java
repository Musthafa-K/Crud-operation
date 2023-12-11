package com.example.crudoperation.service;


import com.example.crudoperation.dto.UserDto;
import com.example.crudoperation.entity.User;
import com.example.crudoperation.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;


    public UserServiceImpl(UserRepository userRepository,PasswordEncoder passwordEncoder
                           ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;

    }

    @Override
    @Transactional
    public void saveUser(UserDto userDto) {
        String state= userDto.getState();
        System.out.println(state);
        System.out.println("save user");
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setState(userDto.getState());
        user.setDob(userDto.getDob());
        user.setUsername(userDto.getUsername());
        user.setGender(userDto.getGender());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setConfirmPassword(userDto.getConfirmPassword());
        System.out.println("add user service");
        user.setRole("USER");
        userRepository.save(user);
        System.out.println(user);
    }

    @Override
    public User findByUsername(String username) {
       return userRepository.findByUsername(username);
    }

    @Override
    public User findByEmail(String email) {
        User user= userRepository.findByEmail(email);
        System.out.println(user+" Email is");
        return user;
    }

    @Override
    public UserDto findById(int id) {

        User existing= userRepository.findById(id);
        UserDto userDto=new UserDto();
        userDto.setId(existing.getId());
        userDto.setFirstName(existing.getFirstName());
        userDto.setLastName(existing.getLastName());
        userDto.setEmail(existing.getEmail());
        userDto.setDob(existing.getDob());
        userDto.setState(existing.getState());
        userDto.setUsername(existing.getUsername());
        userDto.setPhoneNumber(existing.getPhoneNumber());
        userDto.setGender(existing.getGender());
        userDto.setRole(existing.getRole());
        return userDto;
    }

    @Override
    public List<UserDto> findAllByRole(String role) {
        List<User> users = userRepository.findAllByRole(role);
        return users.stream().map((user) -> convertEntityToDto(user))
                .collect(Collectors.toList());
    }

    @Override
    public User updateUser(UserDto user) {
        int id=user.getId();
        User existing=userRepository.findById(id);
        existing.setFirstName(user.getFirstName());
        existing.setLastName(user.getLastName());
        existing.setEmail(user.getEmail());
        existing.setDob(user.getDob());
        existing.setUsername(user.getUsername());
        existing.setState(user.getState());
        existing.setPhoneNumber(user.getPhoneNumber());
        existing.setGender(user.getGender());
        return userRepository.save(existing);
    }

    @Override
    @Transactional
    public User deleteUserById(int id) {
        System.out.println("Delete Service");
        return userRepository.deleteById(id);
    }
    public List<UserDto> searchUser(String role,String name) {
        List<User> users = userRepository.findAllByRoleAndFirstNameStartingWithIgnoreCase(role, name);
        return users.stream().map((user) -> convertEntityToDto(user))
                .collect(Collectors.toList());
    }


    private UserDto convertEntityToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        userDto.setPhoneNumber(user.getPhoneNumber());
        userDto.setGender(user.getGender());
        userDto.setUsername(user.getUsername());
        userDto.setDob(user.getDob());
        userDto.setState(user.getState());
        userDto.setPassword(user.getPassword());
        return userDto;
    }

}

