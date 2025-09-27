package com.example.BaiTap05.repository;

import com.example.BaiTap05.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}