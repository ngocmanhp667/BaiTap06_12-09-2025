package com.example.BaiTap05.service;

import com.example.BaiTap05.entity.User;
import com.example.BaiTap05.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    private final String uploadDir = "src/main/resources/static/uploads/";

    public List<User> getAll() { return repository.findAll(); }
    public Optional<User> getById(Integer id) { return repository.findById(id); }
    public User save(User user, MultipartFile image) throws IOException {
        if (!image.isEmpty()) {
            String fileName = image.getOriginalFilename();
            File dest = new File(uploadDir + fileName);
            image.transferTo(dest);
            user.setImagePath("/uploads/" + fileName);
        }
        return repository.save(user);
    }
    public void deleteById(Integer id) { repository.deleteById(id); }
	public void updateUser(User user, MultipartFile image) {

		
	}
}