package com.kodbook.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kodbook.demo.entity.Users;
import com.kodbook.demo.service.UsersService;

@Controller
public class UserController
{
	@Autowired
	UsersService service;
	
	@PostMapping("/validate")
	public String addUser(@ModelAttribute Users user)
	{
		boolean status = service.getUser(user.getEmail(), user.getUsername());
		if(status == false)
		{
			String msg = service.addUser(user);
			System.out.println(msg);
			return "index";
		}
		else return "signup";
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute Users user) 
	{
		String username = user.getUsername();
		String email = user.getEmail();
		String password = user.getPassword();
		
		String db_pass = service.fetchUser(username).getPassword();
		
		boolean status = service.getUser(user.getEmail(), user.getUsername());
		if(status == true)
		{
			if(db_pass.equals(password))
			{
				return "home";
			}
		}
		return "index";
	}

}
