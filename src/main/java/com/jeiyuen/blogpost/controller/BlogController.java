package com.jeiyuen.blogpost.controller;

import java.util.List;
import java.util.UUID;

import com.jeiyuen.blogpost.dto.BlogDTO;
import com.jeiyuen.blogpost.dto.BlogHeaderDTO;
import com.jeiyuen.blogpost.dto.BlogUpdateDTO;
import com.jeiyuen.blogpost.service.BlogService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/blogs")
public class BlogController {

    // Inject Blog Service
    private final BlogService blogService;

    BlogController(BlogService theBlogService) {
        blogService = theBlogService;
    }

    // List blogs excluding details
    @GetMapping
    public ResponseEntity<List<BlogHeaderDTO>> findAll() {
        List<BlogHeaderDTO> blogs = blogService.findall();
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    // Show specific blogs with details
    @GetMapping(path = "/{id}")
    public ResponseEntity<BlogDTO> findById(@PathVariable UUID id) {
        BlogDTO blog = blogService.findBlogById(id);
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    // Create Blog
    @PostMapping
    public ResponseEntity<BlogDTO> createBlog(@RequestBody BlogDTO dto) {
        BlogDTO created = blogService.saveBlog(dto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    // Update blog
    @PatchMapping(path = "/{id}")
    public ResponseEntity<BlogDTO> updateBlog(@PathVariable UUID id, @RequestBody BlogUpdateDTO dto) {
        BlogDTO updated = blogService.updateBlog(id, dto);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    // Delete blog by ID
    @DeleteMapping(path = "blogs/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        blogService.deleteBlog(id);
        return ResponseEntity.noContent().build();
    }
}
