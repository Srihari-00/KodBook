package com.kodbook.demo.service;

import java.util.List;

import com.kodbook.demo.entity.Post;

public interface PostService 
{
	public String addPost(Post post);
	
	public List<Post> getAllPosts();
}
