package com.jeiyuen.blogpost.service;

import java.util.List;
import java.util.UUID;

import com.jeiyuen.blogpost.entity.Blogs;

public interface BlogService{

    List<Blogs> findall();
    Blogs findBlogById(UUID id);
    Blogs saveBlog(Blogs blog);
    void deleteBlog(UUID id);

}
