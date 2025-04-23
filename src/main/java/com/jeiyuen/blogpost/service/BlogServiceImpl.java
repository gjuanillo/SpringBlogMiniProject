package com.jeiyuen.blogpost.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.jeiyuen.blogpost.dao.BlogRepository;
import com.jeiyuen.blogpost.entity.Blogs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BlogServiceImpl implements BlogService{

    private final BlogRepository blogRepository;

    @Autowired
    public BlogServiceImpl(BlogRepository theBlogRepository){
        blogRepository = theBlogRepository;
    }

    @Override
    public List<Blogs> findall() {
        return blogRepository.findAllByOrderByUpdatedDesc();
    }

    @Override
    public Blogs findBlogById(UUID id) {
        Optional<Blogs> blog = blogRepository.findById(id);
        Blogs theBlog = null; //Declare a temporary variable for a specific blog
        //Check if the ID exists within the database
        if(blog.isPresent()){
            theBlog = blog.get();
        } else {
            throw new RuntimeException("Blog not found with ID: " + id);
        }
        return theBlog;
    }

    @Override
    public Blogs saveBlog(Blogs blog) {
        if(blog.getUuid() != null){
            throw new IllegalArgumentException("Id is already exists");
        }
        if(blog.getTitle() == null){
            throw new IllegalArgumentException("Title cannot be empty");
        }
        LocalDateTime now = LocalDateTime.now();
        return blogRepository.save(new Blogs(
                    null,
                    blog.getTitle(),
                    blog.getAuthor(),
                    now,
                    now));
    }
    
    @Transactional
    @Override
    public void deleteBlog(UUID id) {
        blogRepository.deleteById(id);
    }

}
