package com.kodbook.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodbook.demo.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long>
{

}
