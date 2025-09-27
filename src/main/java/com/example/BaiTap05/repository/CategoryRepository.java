package com.example.BaiTap05.repository;

import com.example.BaiTap05.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}