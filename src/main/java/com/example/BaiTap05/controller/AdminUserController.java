package com.example.BaiTap05.controller;

import com.example.BaiTap05.entity.User;
import com.example.BaiTap05.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/admin/users")
public class AdminUserController {
    @Autowired
    private UserService service;

    @GetMapping
    public String list(Model model) {
        List<User> users = service.getAll();
        model.addAttribute("users", users);
        return "admin/users/list";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("user", new User());
        return "admin/users/form";
    }

    @PostMapping
    public String save(@ModelAttribute User user, @RequestParam("image") MultipartFile image) throws IOException {
        service.save(user, image);
        return "redirect:/admin/users";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Integer id, Model model) {
        model.addAttribute("user", service.getById(id).orElse(new User()));
        return "admin/users/form";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        service.deleteById(id);
        return "redirect:/admin/users";
    }
}