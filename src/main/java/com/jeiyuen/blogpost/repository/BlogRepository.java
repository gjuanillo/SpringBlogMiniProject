package com.jeiyuen.blogpost.repository;

import java.util.List;
import java.util.UUID;

import com.jeiyuen.blogpost.entity.Blogs;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blogs, UUID>{
   List<Blogs> findAllByOrderByUpdatedDesc();
}
