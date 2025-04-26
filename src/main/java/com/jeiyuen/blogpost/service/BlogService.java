package com.jeiyuen.blogpost.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.jeiyuen.blogpost.entity.Blogs;

public interface BlogService{

    //Find Blogs excluding details
    List<Blogs> findall();
    //Find Blog by ID, including details
    Optional<Blogs> findBlogById(UUID id);
    //Save Blog on creation
    Blogs saveBlog(Blogs blog);
    //Update blog
    Blogs updateBlog(UUID id, Blogs blog);
    //Delete blog
    void deleteBlog(UUID id);
    //TODO Handle media upload
}
