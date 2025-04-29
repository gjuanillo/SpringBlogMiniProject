package com.jeiyuen.blogpost.service;

import java.util.Optional;
import java.util.UUID;

import com.jeiyuen.blogpost.entity.BlogDetails;
import com.jeiyuen.blogpost.repository.BlogDetailsRepository;

public class BlogDetailsServiceImpl implements BlogDetailsService{

    private BlogDetailsRepository blogDetailsRepository;

    public BlogDetailsServiceImpl(BlogDetailsRepository theBlogDetailsRepository){
        blogDetailsRepository = theBlogDetailsRepository;
    }

    @Override
    public Optional<BlogDetails> findBlogDetailsById(UUID id) {
        return blogDetailsRepository.findById(id); 
    }

}
