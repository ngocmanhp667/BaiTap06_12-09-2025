package com.example.BaiTap05.service;

import com.example.BaiTap05.entity.Video;
import com.example.BaiTap05.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class VideoService {
    @Autowired
    private VideoRepository repository;

    public List<Video> getAll() { return repository.findAll(); }
    public Optional<Video> getById(Integer id) { return repository.findById(id); }
    public Video save(Video video) { return repository.save(video); }
    public void deleteById(Integer id) { repository.deleteById(id); }
    public List<Video> search(String keyword) { return repository.searchByKeyword(keyword); }
}