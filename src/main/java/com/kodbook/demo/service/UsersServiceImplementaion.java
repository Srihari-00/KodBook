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
	public boolean userExists( String username, String email)
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
	public boolean validateUser(String username, String password) {
		String dbPass = repo.findByUsername(username).getPassword();
		if(password.equals(dbPass)) {
			return true;
		}
		return false;
	}

	@Override
	public Users getUser(String username) {
		return repo.findByUsername(username);
	}

	@Override
	public void updateUser(Users user) {
		repo.save(user);
	}
	
	
}