package com.example.BaiTap05.service;

import com.example.BaiTap05.entity.Category;
import com.example.BaiTap05.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository repository;

    public List<Category> getAll() { return repository.findAll(); }
    public Optional<Category> getById(Integer id) { return repository.findById(id); }
    public Category save(Category category) { return repository.save(category); }
    public void deleteById(Integer id) { repository.deleteById(id); }
}