package com.kodbook.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodbook.demo.entity.Post;
import com.kodbook.demo.repository.PostRepository;

@Service
public class PostServiceImplementation implements PostService {
	@Autowired
	PostRepository repo;

	@Override
	public String createPost(Post post) {
		repo.save(post);
		return "Post is created....";
	}

	@Override
	public List<Post> getAllPosts() {

		return repo.findAll();
	}

	@Override
	public List<Post> fetchAllPosts() {
		return repo.findAll();
	}
	
	
	@Override
	public Post getPost(Long id) 
	{
		return repo.findById(id).get();
	}

	@Override
	public String updatePost(Post post) 
	{
		repo.save(post);
		return "Post is updated....";
	}

}
