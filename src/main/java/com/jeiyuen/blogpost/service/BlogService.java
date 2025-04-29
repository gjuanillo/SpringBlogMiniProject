package com.jeiyuen.blogpost.service;

import java.util.List;
import java.util.UUID;

import com.jeiyuen.blogpost.dto.BlogDTO;
import com.jeiyuen.blogpost.dto.BlogHeaderDTO;
import com.jeiyuen.blogpost.dto.BlogUpdateDTO;

public interface BlogService{

    //Find Blogs excluding details
    List<BlogHeaderDTO> findall();
    //Find Blog by ID, including details
    BlogDTO findBlogById(UUID id);
    //Save Blog on creation
    BlogDTO saveBlog(BlogDTO dto);
    //Update blog
    BlogDTO updateBlog(UUID id, BlogUpdateDTO dto);
    //Delete blog
    void deleteBlog(UUID id);
    //TODO Handle media upload
}
