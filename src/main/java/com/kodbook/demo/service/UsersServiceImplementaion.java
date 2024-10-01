package com.kodbook.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodbook.demo.entity.Users;
import com.kodbook.demo.repository.UserRepository;
@Service
public class UsersServiceImplementaion implements UsersService
{
	@Autowired
	UserRepository repo;

	@Override
	public String addUser(Users user)
	{
		repo.save(user);
		return "User is added";
	}

	@Override
	public boolean getUser(String email, String username)
	{
		Users user1 = repo.findByUsername(username); 
		Users user2 = repo.findByEmail(email);
		
		if(user1 != null || user2 != null) 
		{
			return true;
		}
		return false;
	}

	@Override
	public Users fetchUser(String username) 
	{
		Users user = repo.findByUsername(username);
		return user;
	}
	
	
}