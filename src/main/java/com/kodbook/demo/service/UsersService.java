package com.kodbook.demo.service;

import com.kodbook.demo.entity.Users;

public interface UsersService 
{
	public String addUser(Users user);

	public boolean userExists(String username, String email);

	public boolean validateUser(String username, String password);

	public Users getUser(String username);

	public void updateUser(Users user);
	
	

}
