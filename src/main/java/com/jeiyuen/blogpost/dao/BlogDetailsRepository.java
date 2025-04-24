package com.jeiyuen.blogpost.dao;

import java.util.UUID;

import com.jeiyuen.blogpost.entity.BlogDetails;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogDetailsRepository extends JpaRepository<BlogDetails, UUID>{

}
