package com.example.crudoperation.security;


import lombok.Getter;

import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;


import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Getter
@Setter
public class CustomerUserDetails extends org.springframework.security.core.userdetails.User
{


    private  String firstName;
    private String lastName;
    private String username;
    private String gender;
    private String phoneNumber;
    private String email;
    private String state;
    private String dob;



    public CustomerUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities,
                             String gender, String phoneNumber,String email, String dob, String state,String firstName,String lastName) {
        super(username, password, authorities);
        this.firstName=firstName;
        this.lastName=lastName;
        this.username=username;
        this.phoneNumber = phoneNumber;
        this.dob=dob;
        this.email=email;
        this.state=state;
        this.gender = gender;

    }


}
