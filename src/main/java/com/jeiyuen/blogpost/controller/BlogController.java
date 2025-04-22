package com.jeiyuen.blogpost.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BlogController{
    
    @GetMapping(path="/blogs")
    public String showBlogs(){
        return "Spring Application Initialized";
    }
}
