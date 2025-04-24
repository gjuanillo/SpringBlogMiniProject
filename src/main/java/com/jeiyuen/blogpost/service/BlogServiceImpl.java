package com.jeiyuen.blogpost.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
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
    public Optional<Blogs> findBlogById(UUID id) {
        // Optional<Blogs> blog = blogRepository.findById(id);
        // Blogs theBlog = null; //Declare a temporary variable for a specific blog
        // //Check if the ID exists within the database
        // if(blog.isPresent()){
        //     theBlog = blog.get();
        // } else {
        //     throw new RuntimeException("Blog not found with ID: " + id);
        // }
        // return theBlog;
        return blogRepository.findById(id);
    }

    @Override
    public Blogs saveBlog(Blogs blog) {
        if(blog.getUuid() != null){
            throw new IllegalArgumentException("Id already exists");
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
    public Blogs updateBlog(UUID id, Blogs blog) {
        //Verify Request
        if(blog.getTitle() == null){ //verify if title is empty
            throw new IllegalArgumentException("Title cannot be empty");
        }
        if(blog.getAuthor() == null){ //verify if author is empty
            throw new IllegalArgumentException("Author cannot be empty");
        }
        if (!Objects.equals(blog.getUuid(), id) && blog.getUuid() != null) { //verify if there's an attempt to change UUID
            throw new IllegalArgumentException("Blog ID cannot be changed!");
        }
        Blogs existingBlog = blogRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Blog ID does not exist!"));
        existingBlog.setTitle(blog.getTitle());
        existingBlog.setAuthor(blog.getAuthor());
        existingBlog.setUpdated(LocalDateTime.now());
        return blogRepository.save(existingBlog);
    }



    @Override
    public void deleteBlog(UUID id) {
        blogRepository.deleteById(id);
    }

}
