package com.example.SpringBootWithPlSql.repo;

import com.example.SpringBootWithPlSql.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {
    List<User> findByShipperId(String shipperId);
}
