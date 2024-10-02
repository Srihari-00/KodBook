package com.kodbook.demo.service;

import java.util.List;

import com.kodbook.demo.entity.Post;

public interface PostService 
{
	public String createPost(Post post);
	
	public List<Post> getAllPosts();
	
	public Post getPost(Long id);
	
	public List<Post> fetchAllPosts();
	
	public String updatePost(Post post);
}
