package com.example.adminstudy.repository;

import com.example.adminstudy.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>
{
//    // select * from user where account = ?
//    Optional<User> findByAccount(String account);
//
//    Optional<User> findByEmail(String email);
//
//    // select * from user where account = ? and email = ?
//    Optional<User> findByAccountAAndEmail(String account, String email);



}
