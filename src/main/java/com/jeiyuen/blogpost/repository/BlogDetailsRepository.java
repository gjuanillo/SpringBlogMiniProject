package com.jeiyuen.blogpost.repository;

import java.util.UUID;

import com.jeiyuen.blogpost.entity.BlogDetails;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogDetailsRepository extends JpaRepository<BlogDetails, UUID>{

}
