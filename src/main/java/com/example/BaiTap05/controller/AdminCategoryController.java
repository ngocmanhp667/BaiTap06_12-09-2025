package com.example.BaiTap05.controller;

import com.example.BaiTap05.entity.Category;
import com.example.BaiTap05.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin/categories")
public class AdminCategoryController {
    @Autowired
    private CategoryService service;

    @GetMapping
    public String list(Model model) {
        List<Category> categories = service.getAll();
        model.addAttribute("categories", categories);
        return "admin/categories/list";  // Thymeleaf view
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("category", new Category());
        return "admin/categories/form";
    }

    @PostMapping
    public String save(@Valid @ModelAttribute Category category, BindingResult result) {
        if (result.hasErrors()) return "admin/categories/form";
        service.save(category);
        return "redirect:/admin/categories";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Integer id, Model model) {
        model.addAttribute("category", service.getById(id).orElse(new Category()));
        return "admin/categories/form";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        service.deleteById(id);
        return "redirect:/admin/categories";
    }
}