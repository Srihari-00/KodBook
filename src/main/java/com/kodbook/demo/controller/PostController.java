package com.kodbook.demo.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kodbook.demo.entity.Post;
import com.kodbook.demo.service.PostService;

@Controller
public class PostController 
{
	@Autowired
	PostService service;
	
	@PostMapping("/createPost")
	public String createPost(@RequestParam("caption") String caption, @RequestParam("photo") MultipartFile photo)
	{
		Post post = new Post();
		post.setCaption(caption);
		try {
			post.setPhoto(photo.getBytes());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		String msg = service.addPost(post);
		System.out.println(msg);
		return "home";		
	}
	
	@GetMapping("/showAllPosts")
	public String showAllPosts(Model model)
	{
		List<Post> allPosts = service.getAllPosts();
		System.out.println(allPosts);
		model.addAttribute("allPosts", allPosts);
		
		return "showPosts";
	}
}
