package com.example.BaiTap05.controller;

import com.example.BaiTap05.entity.User;
import com.example.BaiTap05.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Controller
public class ProfileController {

    @Autowired
    private UserService userService;

    @GetMapping("/profile")
    public String showProfile(Model model) {
        Optional<User> user = userService.getUserById(1);  // Giả sử ID=1
        model.addAttribute("user", user.orElse(new User()));
        return "profile";  // Trả về view profile.html
    }

    @PostMapping("/profile/update")
    public String updateProfile(@ModelAttribute User user, @RequestParam("image") MultipartFile image) throws IOException {
        user.setId(1);  // Giả sử ID=1
        userService.updateUser(user, image);
        return "redirect:/profile";
    }
}