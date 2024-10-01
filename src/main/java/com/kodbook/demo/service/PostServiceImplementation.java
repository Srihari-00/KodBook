package com.kodbook.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodbook.demo.entity.Post;
import com.kodbook.demo.repository.PostRepository;

@Service
public class PostServiceImplementation implements PostService
{
	@Autowired
	PostRepository repo;

	@Override
	public String addPost(Post post) 
	{
		repo.save(post);
		return "Post is created....";
	}

}
