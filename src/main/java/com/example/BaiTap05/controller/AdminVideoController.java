package com.example.BaiTap05.controller;

import com.example.BaiTap05.entity.Video;
import com.example.BaiTap05.service.CategoryService;
import com.example.BaiTap05.service.UserService;
import com.example.BaiTap05.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/admin/videos")
public class AdminVideoController {
    @Autowired
    private VideoService service;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private UserService userService;

    @GetMapping
    public String list(@RequestParam(required = false) String keyword, Model model) {
        List<Video> videos;
        if (keyword != null && !keyword.isEmpty()) {
            videos = service.search(keyword);
        } else {
            videos = service.getAll();
        }
        model.addAttribute("videos", videos);
        model.addAttribute("keyword", keyword);
        model.addAttribute("categories", categoryService.getAll());
        model.addAttribute("users", userService.getAll());
        return "admin/videos/list";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("video", new Video());
        model.addAttribute("categories", categoryService.getAll());
        model.addAttribute("users", userService.getAll());
        return "admin/videos/form";
    }

    @PostMapping
    public String save(@ModelAttribute Video video) {
        service.save(video);
        return "redirect:/admin/videos";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Integer id, Model model) {
        model.addAttribute("video", service.getById(id).orElse(new Video()));
        model.addAttribute("categories", categoryService.getAll());
        model.addAttribute("users", userService.getAll());
        return "admin/videos/form";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        service.deleteById(id);
        return "redirect:/admin/videos";
    }
}