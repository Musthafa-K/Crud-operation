package com.example.crudoperation.security;

import com.example.crudoperation.entity.User;
import com.example.crudoperation.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;



    public CustomerUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);


        if (user != null) {
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(user.getRole()));

            return new CustomerUserDetails(
                    user.getUsername(),
                    user.getPassword(),
                    authorities,
                    user.getEmail(),
                    user.getGender(),
                    user.getPhoneNumber(),
                    user.getDob(),
                    user.getState(),
                    user.getFirstName(),
                    user.getLastName()
            );

        }else{
            throw new UsernameNotFoundException("Invalid username or password.");
        }
    }
}
