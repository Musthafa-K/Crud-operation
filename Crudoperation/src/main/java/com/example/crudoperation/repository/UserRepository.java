package com.example.crudoperation.repository;

import com.example.crudoperation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUsername(String username);
     User findByEmail(String email);
    User findById(int id);

    List<User> findAllByRole(String role);

    List<User> findAllByRoleAndFirstNameStartingWithIgnoreCase(String role,String name);



    User deleteById(int id);
}
