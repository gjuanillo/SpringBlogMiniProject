package com.jeiyuen.blogpost.service;

import java.util.Optional;
import java.util.UUID;

import com.jeiyuen.blogpost.entity.BlogDetails;

public interface BlogDetailsService{
    Optional<BlogDetails> findBlogDetailsById(UUID id);
}
