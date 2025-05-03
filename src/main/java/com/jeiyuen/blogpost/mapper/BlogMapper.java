package com.jeiyuen.blogpost.mapper;

import java.time.LocalDateTime;

import com.jeiyuen.blogpost.dto.BlogDTO;
import com.jeiyuen.blogpost.dto.BlogHeaderDTO;
import com.jeiyuen.blogpost.dto.BlogUpdateDTO;
import com.jeiyuen.blogpost.entity.BlogDetails;
import com.jeiyuen.blogpost.entity.Blogs;

import org.springframework.stereotype.Component;

@Component
public class BlogMapper {

    // Map entity to dto
    public BlogDTO toDto(Blogs blog) {
        BlogDTO dto = new BlogDTO();
        dto.setUuid(blog.getUuid());
        dto.setTitle(blog.getTitle());
        dto.setAuthor(blog.getAuthor());
        dto.setCreated(blog.getCreationDate());
        dto.setUpdated(blog.getUpdated());
        if (blog.getBlogDetails() != null) {
            dto.setBlogContent(blog.getBlogDetails().getBlogContent());
        }
        return dto;
    }

    // Map dto to entity
    public Blogs toEntity(BlogDTO dto) {
        Blogs blog = new Blogs();
        blog.setUuid(dto.getUuid());
        blog.setTitle(dto.getTitle());
        blog.setAuthor(dto.getAuthor());
        blog.setCreationDate(dto.getCreated());
        blog.setUpdated(dto.getUpdated());

        BlogDetails details = new BlogDetails();
        details.setBlogContent(dto.getBlogContent());
        details.setBlogs(blog);
        blog.setBlogDetails(details);
        details.setBlogs(blog);

        return blog;
    }

    // Map update body dto to entity
    public void updateEntity(Blogs blog, BlogUpdateDTO dto) {
        if (dto.getTitle() != null) {
            blog.setTitle(dto.getTitle());
        }
        if (dto.getAuthor() != null) {
            blog.setAuthor(dto.getAuthor());
        }
        if (dto.getBlogContent() != null && blog.getBlogDetails() != null) {
            blog.getBlogDetails().setBlogContent(dto.getBlogContent());
        }
        blog.setUpdated(LocalDateTime.now());
    }

    public BlogHeaderDTO toHeaderDto(Blogs blog){
        BlogHeaderDTO header = new BlogHeaderDTO();
        header.setUuid(blog.getUuid());
        header.setTitle(blog.getTitle());
        header.setAuthor(blog.getAuthor());
        header.setCreated(blog.getCreationDate());
        header.setUpdated(blog.getUpdated());
        return header;
    }
}
