package com.kodbook.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavController 
{
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/signup")
	public String signup() {
		return "signup";
	}
	
	@GetMapping("/resetpassword")
	public String resetpassword() {
		return "resetpassword";
	}
	
	@GetMapping("/openCreatePost")
	public String openCreatePost()
	{
		return "createPost";	
	}

}
