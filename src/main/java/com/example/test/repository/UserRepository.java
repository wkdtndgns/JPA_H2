package com.example.test.repository;


import com.example.test.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT count(u.user_no) FROM User u WHERE ( u.name = ?1 or u.email = ?1 or u.tel = ?1 )  and u.password = ?2")
    int login(String id, String password);
}
