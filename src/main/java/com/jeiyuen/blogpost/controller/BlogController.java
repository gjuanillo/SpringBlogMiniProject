package com.jeiyuen.blogpost.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.jeiyuen.blogpost.entity.Blogs;
import com.jeiyuen.blogpost.service.BlogService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BlogController{
    
    //Inject Blog Service
    private final BlogService blogService;

    BlogController(BlogService theBlogService){
        blogService = theBlogService;
    }

    @GetMapping(path="/blogs")
    public List<Blogs> findAll(){
        return blogService.findall();
    }

    @GetMapping(path="/blogs/{id}")
    public Optional<Blogs> findById(@PathVariable UUID id){
        Optional<Blogs> blog = blogService.findBlogById(id);
        if (blog == null){
            throw new RuntimeException("Blog not found with ID " + id);
        }
        return blog;
    }

    @PostMapping(path="/blogs")
    public Blogs createBlog(@RequestBody Blogs blog){
        blog.setUuid(null);
        blog.setCreationDate(null);
        blog.setUpdated(null);
        return blogService.saveBlog(blog);
    }

    @PutMapping(path="/blogs/{id}")
    public Blogs updateBlog(@PathVariable UUID id, @RequestBody Blogs blog){
        return blogService.updateBlog(id, blog);
    }
    
    @DeleteMapping(path="blogs/{id}")
    public String delete(@PathVariable UUID id){
        Optional<Blogs> blog = blogService.findBlogById(id);
        if (blog == null){
            throw new RuntimeException("Blog not found with ID " + id);
        }
        blogService.deleteBlog(id);
        return "Successfully deleted blog with ID " + id;
    }
}
