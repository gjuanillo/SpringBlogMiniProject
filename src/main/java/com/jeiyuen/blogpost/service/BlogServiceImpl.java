package com.jeiyuen.blogpost.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.jeiyuen.blogpost.dto.BlogDTO;
import com.jeiyuen.blogpost.dto.BlogHeaderDTO;
import com.jeiyuen.blogpost.dto.BlogUpdateDTO;
import com.jeiyuen.blogpost.entity.Blogs;
import com.jeiyuen.blogpost.mapper.BlogMapper;
import com.jeiyuen.blogpost.repository.BlogRepository;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class BlogServiceImpl implements BlogService{

    private final BlogRepository blogRepository;
    private final BlogMapper blogMapper;

    public BlogServiceImpl(BlogRepository blogRepository, BlogMapper blogMapper) {
        this.blogRepository = blogRepository;
        this.blogMapper = blogMapper;
    }

    @Override
    public List<BlogHeaderDTO> findall() {
        return blogRepository.findAllByOrderByUpdatedDesc()
            .stream().map(blogMapper::toHeaderDto).collect(Collectors.toList());
    }

    @Override
    public BlogDTO findBlogById(UUID id) {
        return blogRepository.findById(id).map(blogMapper::toDto)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Blog not found"));
    }

    @Override
    public BlogDTO saveBlog(BlogDTO dto) {
        Blogs blog = blogMapper.toEntity(dto);
        blog.setCreationDate(LocalDateTime.now());
        blog.setUpdated(LocalDateTime.now());
        Blogs saved = blogRepository.save(blog);
        return blogMapper.toDto(saved);
    }

    @Override
    public BlogDTO updateBlog(UUID id, BlogUpdateDTO dto) {
        Blogs blog = blogRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Blog with ID " + id + " does not exists!"));
        blogMapper.updateEntity(blog, dto);
        Blogs updated = blogRepository.save(blog);
        return blogMapper.toDto(updated);

    }

    @Override
    public void deleteBlog(UUID id) {
        Blogs blog = blogRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Blog with ID " + id + " does not exists!"));
        blogRepository.delete(blog);
    }


}
