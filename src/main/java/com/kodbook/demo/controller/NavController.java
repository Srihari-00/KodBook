package com.kodbook.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kodbook.demo.entity.Post;
import com.kodbook.demo.entity.Users;
import com.kodbook.demo.service.PostService;
import com.kodbook.demo.service.UsersService;

import jakarta.servlet.http.HttpSession;

@Controller
public class NavController 
{
	@Autowired
	UsersService service;
	@Autowired
	PostService postService;
	@GetMapping("/")
	public String index() {
		return "index";
	}
	@GetMapping("/openSignUp")
	public String openSignUp() {
		return "signUp";
	}
	@GetMapping("/openCreatePost")
	public String openCreatePost() {
		return "createPost";
	}


	@GetMapping("/goHome")
	public String login(Model model, HttpSession session) {
	    List<Post> allPosts = postService.fetchAllPosts();
	    model.addAttribute("allPosts", allPosts);
	    
	    String username = (String) session.getAttribute("username");
	    model.addAttribute("username", username);
	    
	    return "home";
	}

	@GetMapping("/openMyProfile")
	public String openMyProfile(Model model, HttpSession session) {
		String username = (String) session.getAttribute("username");
		Users user = service.getUser(username);
		model.addAttribute("user", user);
		List<Post> myPosts = user.getPosts();
		model.addAttribute("myPosts", myPosts);
		
		return "myProfile";
	}
	
	@GetMapping("/openEditProfile")
	public String openEditProfile(HttpSession session) {
		
		if(session.getAttribute("username")!=null)
			return "editProfile";
		else
			return "index";
	}
	
	@PostMapping("/visitProfile")
	public String visitProfile(@RequestParam String profileName, Model model) {
		Users user = service.getUser(profileName);
		model.addAttribute("user", user);
		List<Post> myPosts = user.getPosts();
		model.addAttribute("myPosts", myPosts);
		
		return "showUserProfile";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "index";
	}
	
	
}
